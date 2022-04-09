def call(Map params = [:]) {

    def args= [
            COMPONENT      : "",
            LABEL          : "master"

    ]

    args << params


    pipeline {
        agent {
            label "${LABEL}"
        }

        stages {
            stage("compile") {
                steps {
                    sh "echo COMPONENT = ${COMPONENT}"

                }
            }

            stage("code quality") {
                steps {
                    sh "echo  code quality"

                }
            }

            stage("Test cases") {
                steps {
                    sh "echo  test cases"

                }
            }
        }
    }

}