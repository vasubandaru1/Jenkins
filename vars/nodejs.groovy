def call(Map params = [:]) {
    //Start Default Arguments
    def args = [
          COMPONENT   : '',
          LABEL       : 'work'

    ]
    args << params

    pipeline {
        agent {
            label params.LABEL
        }

        stages {

            stage ("Labiling Build") {
                steps {
                    script {
                        addShortText background: 'yellow', color: 'black', bordercolor: 'yellow', text: "${params.COMPONENT}"

                    }
                }
            }

            stage("COMPILE") {
                steps {
                    sh "echo COMPILE"
                }
            }

            stage("CODE QUALITY") {
                steps {
                    sh "echo CODE QUALITY"
                    sh "echo COMPONENT = ${params.COMPONENT}"
                }
            }

            stage("TEST CASES") {
                steps {
                    sh "echo TEST CASES"
                }
            }


            stage("ARTIFACTORY") {
                steps {
                    sh "echo TEST CASES"
                    sh  "env"
                }
            }


        }
    }
}