def call(String project, String imageTag, String dockerhubUser) {

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerHubCred',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh '''
            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
        '''
        
        sh """
            docker push ${dockerhubUser}/${project}:${imageTag}
        """
    }
}
