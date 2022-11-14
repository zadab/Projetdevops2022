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
     
     stage('Creation livrable'){ 
             steps{ 
                 sh "mvn clean package"
             }
         }
         
         stage('Compilation'){ 
             steps{ 
                 sh "mvn compile"
             }
         }
