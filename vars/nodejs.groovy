def call(Map params = [:]) {
    //Start Default Arguments
    def args = [
          COMPONENT   : '',
          LABEL       : 'raja'

    ]
    args << params

    pipeline {
        agent {
            label params.LABEL
        }

        stages {

//            stage("COMPILE") {
//                steps {
//                    sh "echo COMPILE"
//                }
//            }

            stage("CODE QUALITY") {
                steps {
                    sh "echo CODE QUALITY"
                    sh "echo COMPONENT = ${params.COMPONENT}"
                }
            }
//
//            stage("TEST CASES") {
//                steps {
//                    sh "echo TEST CASES"
//                }
//            }


        }
    }
}