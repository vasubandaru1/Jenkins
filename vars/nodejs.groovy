def call(String COMPONENT, String ) {

pipeline {
    agent any

    stages {
        stage("compile") {
            steps {
                ssh ''

                "echo  compile"
                "echo COMPONENT = ${COMPONENT}"
                
                ''
            }
        }

        stage("code quality") {
            steps {
                ssh ''
                
                "echo  code quality"
                
                ''
            }
        }

        stage("Test cases") {
            steps {
                ssh ''

                "echo  test cases"
                
                ''
            }
        }
    }
}
}
