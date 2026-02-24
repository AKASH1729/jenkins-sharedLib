def call(String project, String imageTag, String dockerhubUser) {
    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-creds',
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD'
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
