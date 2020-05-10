node {
	def tomcatIp = '192.168.0.6'
        def tomcatUser = 'admin'
        def stopTomcat = "ssh ${tomcatUser}@${tomcatIp} /opt/tomcat8/bin/shutdown.sh"
        def startTomcat = "ssh ${tomcatUser}@${tomcatIp} /opt/tomcat8/bin/startup.sh"
        def copyWar = "scp -o StrictHostKeyChecking=no target/myweb.war ${tomcatUser}@${tomcatIp}:/opt/tomcat8/webapps/"
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
	stage('Deploy Dev'){
	   //sh 'mv target/myweb*.war target/myweb.war' 
	   
	       //sshagent(['tomcat-dev']) {
		//		sh "${stopTomcat}"
		//		sh "${copyWar}"
		//		sh "${startTomcat}"
		  // }
	   }
	
	stage('Build Docker Image'){
            //sh 'docker build -t swax06/calculator:1.0 .'
        }
	stage('Upload Image to DockerHub'){
	    //sh 'docker push kammana/calculator:1.0'
	 }
	
}
