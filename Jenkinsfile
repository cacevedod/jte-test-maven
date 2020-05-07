pipeline{
    agent {
        docker { image 'maven:3-alpine' }
    }
    stages{
        stage('build'){
            steps{
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar'
            }            
        }
        stage('test'){
            steps{
                sh './mvnw verify'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: 'target/site/jacoco-aggregate/jacoco.xml'
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