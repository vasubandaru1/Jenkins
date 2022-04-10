def call(Map params = [:]) {

    def args= [
            COMPONENT      : '',
            LABEL          : 'work'

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


            stage('maven package') {
                steps {
                    sh  ''' 
                     mvn package
                      
                      '''


                }
            }

            stage('submit code quality') {
                steps {
                    sh '''

                    sonar-scanner -Dsonar.projectKey=params.COMPONENT -Dsonar.java.binaries=target/. -Dsonar.sources=.  -Dsonar.host.url=http://172.31.16.189:9000 -Dsonar.login=fafb7a5e6fe61b24e3e21862ff3fe5b4d4180779
                    
                    '''

                }
            }

//            stage('check code quality') {
//                steps {
//                    sh    '''
//
//
////                    sonar-quality-gate.sh admin Vasu@1991 172.31.16.189 params.COMPONENT
//                      echo ok
//                    '''
//
//                }
//            }
            stage('Test cases') {
                steps {
                    sh 'echo  test cases'


                }
            }

            stage('Upload Artifacts') {
                when {
                    expression {sh([returnStdout: true, script: 'echo ${GIT_BRANCH} | grep tags || true' ]) }
                }

                steps {
                    sh 'echo  test cases'
                    sh 'env'


                }
            }


    }

            post {
                always {
                    cleanWs()
                }
            }
    }
}

//vasu





