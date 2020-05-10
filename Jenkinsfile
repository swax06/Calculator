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
	   sh "${mvn}/bin/mvn clean package deploy"
   }
 
}
