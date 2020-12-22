pipeline {
    agent { label 'jnlp-java-build-tools' }
    options {
        buildDiscarder(logRotator(numToKeepStr: "3"))
        timeout(time: 1, unit: 'HOURS')
    }
    stages {
        stage('Prepare') {
            steps {
                sh 'chmod +x ./mvnw'
            }
        }
        stage('Compile') {
            steps {
                withMaven(
                    mavenSettingsConfig: 'MavenJenkinsSettings') {
                    sh './mvnw clean package'
                 }
            }
        }
        stage('Test') {
            steps {
                withMaven(
                    mavenSettingsConfig: 'MavenJenkinsSettings') {
                    sh './mvnw verify'
                }
            }
        }

    }
    post {
        always{
          echo 'Run some clean steps and test reports'
          junit "**/**/target/surefire-reports/*.xml" 
        }
    }
}
