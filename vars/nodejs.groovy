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
            stage('compile') {
                steps {
                    sh "echo COMPONENT = ${params.COMPONENT}"

                }
            }
//
//            stage("code quality") {
//                steps {
//                    sh "echo  code quality"
//
//                }
//            }
//
//            stage("Test cases") {
//                steps {
//                    sh "echo  test cases"
//
//                }
//            }
        }
    }

}