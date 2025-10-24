pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git branch: 'master',
                    url: 'https://github.com/SergeyIvanov11/hello-world-ci-cd',
                    credentialsId: '4e54e4cc-df0c-43c2-bd11-1c7854d71b9e'
      }
    }
    stage('Build & Test') {
      steps {
        sh 'mvn -B -Dfile.encoding=UTF-8 clean verify'
      }
      post { always {
        junit '**/target/surefire-reports/*.xml'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }}
    }
  }
}