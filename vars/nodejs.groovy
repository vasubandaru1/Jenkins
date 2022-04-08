def call(Map params = [:]) {
    //start default arguments
    def args;LinkedHashMap = [
          COMPONENT : '',
          LABEL    : 'work'

    ]
    args << params

    pipeline {
        agent {
            label LABEL
        }

        stages {

            stage("COMPILE") {
                steps {
                    sh "echo COMPILE"
                }
            }

            stage("CODE QUALITY") {
                steps {
                    sh "echo CODE QUALITY"
                    sh "echo COMPONENT = ${COMPONENT}"
                    sh "echo  EX_COMP = ${EX_COMP}"
                }
            }

            stage("TEST CASES") {
                steps {
                    sh "echo TEST CASES"
                }
            }


        }
    }
}