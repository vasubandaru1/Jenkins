def call(String COMPONENT, String LABEL) {

pipeline {
    agent LABEL

    stages {
        stage("compile") {
            steps {
                sh  "echo COMPONENT = ${COMPONENT}"

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
