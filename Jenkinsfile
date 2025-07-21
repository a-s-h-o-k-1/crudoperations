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
                echo '🚀 Building the project...'
                sh '''
                    ls -la
                    java --version
                    mvn --version
                    mvn clean
                    mvn package -DskipTests
                    ls -la
                '''
            }
        }

        stage('Test') {
            agent {
                docker {
                    image 'maven:3.9-eclipse-temurin-17' // Reuse the same Docker image
                    reuseNode true
                }
            }
            steps {
                echo '🧪 Running tests...'
                sh '''
                    java --version
                    mvn --version
                    mvn test
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Build & Test stages completed successfully!'
        }
        failure {
            echo '❌ Build or Tests failed. Check the logs for details.'
        }
    }
}
