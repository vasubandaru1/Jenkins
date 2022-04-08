def call(String COMPONENT ) {

pipeline {
    agent any

    stages {
        stage("compile") {
            steps {
                ssh "echo  compile"
                ssh  "echo COMPONENT = ${COMPONENT}"

            }
        }

        stage("code quality") {
            steps {
                ssh "echo  code quality"

            }
        }

        stage("Test cases") {
            steps {
                ssh "echo  test cases"

            }
        }
    }
}
}
