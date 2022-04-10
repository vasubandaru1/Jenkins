def call(Map params = [:]) {

    def args = [
            COMPONENT: '',
            LABEL    : 'work'

    ]

    args << params


    pipeline {
        agent {
            label params.LABEL
        }

        stages {

            stage('Labeling Build') {
                steps {
                    script {
                        str = GIT_BRANCH.split('/').last()
                        addShortText background: 'yellow', color: 'black', borderColor: 'yellow', text: "COMPONENT = ${params.COMPONENT}"
                        addShortText background: 'yellow', color: 'black', borderColor: 'yellow', text: "BRANCH = ${str}"
                    }
                }
            }


            stage('nodejs dependecies') {
                steps {
                    sh '''
                      echo '+++++++Before'
                      ls -l
                      npm install
                      echo '+++++++After'
                      ls -ltr

                      '''


                }
            }

            stage('code quality') {
                steps {
                    sh 'echo  code quality'

                }
            }

            stage('Test cases') {
                steps {
                    sh 'echo  test cases'


                }
            }

            stage('Upload Artifacts') {
                when {
                    expression { sh([returnStdout: true, script: 'echo ${GIT_BRANCH} | grep tags || true']) }
                }
                steps {
                    sh """
          GIT_TAG=`echo ${GIT_BRANCH} | awk -F / '{print \$NF}'`
          echo \${GIT_TAG} >version
          zip -r ${params.COMPONENT}-\${GIT_TAG}.zip node_modules server.js version
          curl -f -v -u ${NEXUS} --upload-file ${params.COMPONENT}-\${GIT_TAG}.zip http://172.31.86.98:8080/repository/${params.COMPONENT}/${params.COMPONENT}-\${GIT_TAG}.zip
          """

//
//            stage('Upload Artifacts') {
//                when {
//                    expression {sh([returnStdout: true, script: 'echo ${GIT_BRANCH} | grep tags || true' ]) }
//                }
//
//                steps {
//                    sh 'echo  test cases'
//                    sh 'env'
//
//
//                }
//            }
//


            }

                post {
                    always {
                        cleanWs()
                    }
                }
            }
        }
    }
}






