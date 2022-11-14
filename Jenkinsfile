pipeline { 
     agent any
     /*tools {
    maven "maven"
     }*/
     stages{
        stage('Checkout GIT') 
        { 
        steps{ 
            echo 'Pulling...' 
              git branch: 'Ahmed-Miladi', credentialsId: 'token', url: 'https://github.com/zadab/Projetdevops2022.git'

          }
        }
          
          /*stage ('Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
      }
    }*/
          stage("build & SonarQube analysis") {
//          stage ('SonarQube tests') {
            steps {
                withSonarqubeEnv(installationName:'sonarQube') {
                //withSonarqubeEnv('sonarQube') { 
                sh 'mvn sonar:sonar'
                }
      }
    }
     /*
    stage('Creation livrable'){ 
             steps{ 
                 sh "mvn clean package"
             }
         }
         
         stage('Compilation'){ 
             steps{ 
                 sh "mvn compile"
             }
         }*/
}
     }
