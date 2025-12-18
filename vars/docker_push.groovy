def call(String Project, String ImageTag, String dockerhubUser){
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubpass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerHubUser} -p ${dockerHubpass}"
  }
  sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
