def call () {

    pipeline {
        agent any

        stages {

            stage("COMPILE") {
                steps {
                    sh 'echo COMPILE'
                }
            }

            stage("CODE QUALITY") {
                steps {
                    sh 'echo CODE QUALITY'
                }
            }

            stage("TEST CASES") {
                steps {
                    sh 'echo TEST CASES'
                }
            }


        }
    }
}