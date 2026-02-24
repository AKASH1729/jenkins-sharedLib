def call(String project, String imageTag, String dockerhubUser) {
    withCredentials([
        usernamePassword(
            credentialsId: 'dockerHubCred',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh '''
             echo "$PASSWORD" | docker login -u "$USERNAME" --password-stdin
        '''

        sh """
            docker push ${dockerhubUser}/${project}:${imageTag}
        """
    }
}
