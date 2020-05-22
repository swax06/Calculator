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

	stage('Build Docker Image'){
		sh 'docker build -t swax06/calculator:1.0-SNAPSHOT .'
    }
	stage('Upload Image to DockerHub'){
		withCredentials([string(credentialsId: 'docker-pwd', variable: 'docker_pass')]) {
			sh 'docker login -u swax06 -p ${docker_pass}'
		}
	    sh 'docker push swax06/calculator:1.0-SNAPSHOT'
	}

	stage('Deploy'){
		steps{
			script {
				step([ $class: "RundeckNotifier",
				includeRundeckLogs: true,
				jobId: "deb9a3fa-f87a-4028-af5c-c48cd729a129",
				rundeckInstance: "Rundeck_inst_1",
				shouldFailTheBuild: true,shouldWaitForRundeckJob: false,
				tailLog: true])
			}
		}
	}


	stage('Email Notification'){
		mail bcc: '', body: """Hi Team, You build successfully deployed
		Thanks,
		DevOps Team""", cc: '', from: '', replyTo: '', subject: "New Build Success", 
		to: 'swastik.shrivastava@iiitb.org'
	}
	

}

