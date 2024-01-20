@Library('sharedLib') _

def gitConfig = [
    branches: [[name: '*/main']],
    userRemoteConfigs: [[url: 'https://github.com/vyadav5/config_file.git']]
]

pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                script {
                    checkout scmGit(gitConfig)
                    def config = demo.setupCommonConfig()
                    deleteDir()
                    demo.clone(config)
                }
            }
        }
        stage('Approval') {
            steps {
                script {
                    checkout scmGit(gitConfig)
                    def config = demo.setupCommonConfig()
                    demo.approvalStage(config)
                }
            }
        }
    }
}



REPO_URL: 'https://github.com/vyadav5/ansible-newRelic.git'
KEEP_APPROVAL_STAGE: "true"


def clone(String repoUrl) {
    sh "git clone ${repoUrl}"
}