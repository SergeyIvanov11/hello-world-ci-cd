pipeline {
    agent any

    tools {
        jdk 'jdk-19'
        maven 'mvn'
    }

    environment {
        MAVEN_OPTS = "-Dfile.encoding=UTF-8"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/SergeyIvanov11/hello-world-ci-cd.git',
                    credentialsId: 'github-credentials'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -B clean compile'
            }
        }

        stage('Checkstyle') {
            steps {
                sh 'mvn checkstyle:check'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Coverage Report') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            echo '✅ Сборка и тесты успешно завершены!'
        }
        failure {
            echo '❌ Ошибка сборки или тестов!'
        }
    }
}