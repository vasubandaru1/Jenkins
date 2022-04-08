def call(String COMPONENT ) {

pipeline {
    agent any

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
