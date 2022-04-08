def call(String COMPONENT) {

pipeline {
    agent {label 'work'}

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
