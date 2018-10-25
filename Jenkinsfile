pipeline {
  agent any
  stages {
    stage('Récupération des sources') {
      steps {
        git(branch: 'master', url: 'https://github.com/aub91/portail_promotion.git', credentialsId: '	24a8db7b-ad15-45fb-81fc-04d671e7a329')
      }
    }
    stage('build maven') {
      steps {
        bat(script: 'runmaven.bat', encoding: 'UTF-8')
      }
    }
  }
}