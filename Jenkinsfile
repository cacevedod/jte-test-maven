pipeline{
    agent {
        docker { image 'maven:3-alpine' }
    }
    stages{
        stage('build'){
            steps{
                sh 'chmod +x mvnw'
                sh 'mvn clean package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar'
            }            
        }
        stage('test'){
            steps{
                sh 'mvn verify'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: 'target/site/jacoco-aggregate/jacoco.xml'
                }
            }            
        }
        stage('approve'){
            agent none
            steps{
                script{
                    timeout(time: 5, unit: 'SECONDS'){
                        input message: 'Apruebas el despliegue', submitter: 'admin'
                    }
                }
            }
        }        
        stage('deploy'){
            steps{
                echo "Pendiente de implementación"
            }
        }
    }
}