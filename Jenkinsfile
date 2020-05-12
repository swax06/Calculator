pipeline {
	environment {
		registry = "swax06/calculator"
		registryCredential = 'dockerhub'
		dockerImage = ''
	}
	agent any
	
	stages {
		stage('SCM Checkout'){
			git branch: 'master', 
			credentialsId: 'github', 
			url: 'https://github.com/swax06/Calculator'

		}
		stage('Build') {
			steps{
				script {
					dockerImage = docker.build registry + ":latest"
				}
			}
		}
		stage('test'){
			steps {
				sh 'pip3 install pytest'
				sh 'pytest'
			}
		}
		stage('Archive'){
			steps{
				script {
					docker.withRegistry( '', registryCredential ) {
						dockerImage.push()
					}
				}
			}
		}
		stage('Deploy') {
			steps {
				build 'new_calculator'
			}
		}
	}
}
