node {
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
	stage('Build Docker Image'){
            sh 'docker build -t swax06/calculator:1.0-SNAPSHOT'
        }

}
