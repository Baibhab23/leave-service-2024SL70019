pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build and Test') {
      steps { sh 'mvn clean verify' }
      post { always { junit 'target/surefire-reports/*.xml' } }
    }
    stage('Build Docker Image') {
      steps { sh 'docker build -t leave-service:${BUILD_NUMBER} .' }
    }
    stage('Deploy to Staging') {
      steps {
        sh 'docker rm -f leave-staging || true'
        sh 'docker run -d --name leave-staging -e APP_ENV=staging -p 8085:8080 leave-service:${BUILD_NUMBER}'
        sh 'sleep 5'
        sh 'curl -s http://localhost:8085'
      }
    }
    stage('Approval') {
      steps { input message: 'Staging verified. Promote to production?', ok: 'Deploy' }
    }
    stage('Deploy to Production') {
      steps {
        sh 'docker rm -f leave-production || true'
        sh 'docker run -d --name leave-production -e APP_ENV=production -p 8086:8080 leave-service:${BUILD_NUMBER}'
        sh 'sleep 5'
        sh 'curl -s http://localhost:8086'
      }
    }
  }
}
