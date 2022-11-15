pipeline {
    agent any  
    environment {
        DOCKERHUB_CREDENTIALS = credentials('achat')
    }
   

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'hamzakhezami1',
                url : 'https://github.com/zadab/Projetdevops2022'
              
            }
        }
        stage('MNV CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }
       stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar  -Dsonar.login=admin -Dsonar.password=181JMT1084'
            }
        }
        stage('MVN Mockito') {
            steps {
                sh 'mvn test'
            }
        }
          stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }
         stage("Building Docker Image") {
                steps{
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/achat .'
                }
        }
        
        stage("Login to DockerHub") {
                steps{
                   // sh 'sudo chmod 666 /var/run/docker.sock'
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
                }
        }
        stage("Push to DockerHub") {
                steps{
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/achat'
                }
        }
        stage("Docker-compose") {
                steps{
                    sh 'docker-compose up -d'
                }
        }
       
    
    }
     post {
                success {
                     mail to: "hamza.khezami@esprit.tn",
                     subject: "success",
                     body: "success on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
                }
failure {
                    mail to: "hamza.khezami@esprit.tn",
                     subject: "Failure",
                     body: "Failure on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL} "     
                }
    }
}
