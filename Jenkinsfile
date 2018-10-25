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
	stage('Publication'){
		steps {
			nexusArtifactUploader(nexusVersion: 'nexus3', protocol: 'http', nexusUrl: 'localhost:8081', groupId: 'fr.afcepf.al32.groupe2', version: '0.0.1-SNAPSHOT', repository: 'maven-snapshots', credentialsId: 'bdf8ef1a-2969-48a6-9e45-a265ae641a8a', artifacts: [[artifactId: 'portailPromo_web', type: 'war', file: 'portailPromo_web/target/portailPromo_web-0.0.1-SNAPSHOT.war']])
		}
	}
  }
}