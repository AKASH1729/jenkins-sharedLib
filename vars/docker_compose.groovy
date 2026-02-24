def call(String backendTag, String frontendTag) {

    withEnv([
        "BACKEND_DOCKER_TAG=${backendTag}",
        "FRONTEND_DOCKER_TAG=${frontendTag}"
    ]) {
        sh '''
            docker compose down || true
            docker compose pull
            docker compose up -d
        '''
    }
}
