node {
    environment {
        registry = "swax06/calculator"
        registryCredential = 'dockerhub'
        dockerImage = ''
    }
    agent any
	def mvn = tool name: 'Maven_3.6.3', type: 'maven'
	stage('SCM Checkout'){
		// Clone repo
		git branch: 'master', 
		credentialsId: 'github', 
		url: 'https://github.com/swax06/Calculator'

	}

	stage('Mvn Package'){
		// Build using maven
		sh "${mvn}/bin/mvn clean package"
	}
	stage('Email Notification'){
		mail bcc: '', body: """Hi Team, You build successfully deployed
		Thanks,
		DevOps Team""", cc: '', from: '', replyTo: '', subject: " Success", to: '06swastik@gmail.com'

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
                build 'calculator_new'
            }
        }
}
