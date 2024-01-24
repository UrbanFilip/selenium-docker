pipeline {

  agent any

  stages {

      stage('Build Jar') {
        steps {
          bat "mvn clean package -DskipTests"
        }
      }

      stage('Build Image') {
        steps{
          bat "docker build -t=simba195/selenium:latest ."
        }
      }

      stage('Push Image') {
        environment {
            DOCKER_HUB = credentials('dockerhub-cred')
            }
        steps{
          bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
          bat "docker push simba195/selenium:latest"
          bat "docker tag simba195/selenium:latest simba195/selenium:${env.BUILD_NUMBER}"
          bat "docker push simba195/selenium:${env.BUILD_NUMBER}"
        }
      }
  }
  post {
    always {
        bat "docker logout"
    }
  }
}