node {
	def mvn = tool name: 'Maven_3.6.3', type: 'maven'
	stage('Git Checkout'){
		// Clone repo
		git branch: 'master', 
		credentialsId: 'github', 
		url: 'https://github.com/swax06/Calculator'

	}

	stage('Building Package'){
		// Build using maven
		sh "${mvn}/bin/mvn clean package"
	}

	stage('Junit Testing'){
		// testing using Junit
		sh "${mvn}/bin/mvn test"
	}

	stage('Email Notification'){
		mail bcc: '', body: """Hi Team, You build successfully deployed
		Thanks,
		DevOps Team""", cc: '', from: '', replyTo: '', subject: " Success", 
		to: '06swastik@gmail.com'
	}
	
	stage('Build Docker Image'){
		sh 'cp target/*SNAPSHOT.jar calculator.jar'
    }
	stage('Upload Image to DockerHub'){
	    script{
			def dockerImage=docker.build("swax06/Calculator")
			docker.withRegistry( '', 'docker-hub-creds') {
				dockerImage.push()
			}
		}
	}
	
}

