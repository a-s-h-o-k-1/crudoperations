pipeline {
    agent any

    stages {
        stage('Build') {
         agent {
                docker {
                    image 'maven:3.9-eclipse-temurin-17' // Docker image with Java 17 + Maven
                    reuseNode true
                }
            }
            steps {
              sh '''
                    ls -la
                    java --version
                    mvn --version
                    mvn clean
                    mvn package
                    ls -la
              '''
            }
        }
    }
}
