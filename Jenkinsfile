pipeline {
  agent any
  stages {
    stage('Récupération des sources') {
      steps {
        git(branch: 'master', url: 'https://github.com/aub91/portail_promotion.git', credentialsId: '4abfae6d-c653-4cb3-8841-46a36185915b')
      }
    }
    stage('build maven') {
      steps {
        bat(script: 'runmaven.bat', encoding: 'UTF-8')
      }
    }
	stage('Publication') {
    steps {
      nexusArtifactUploader {
        nexusVersion('nexus3')
        protocol('http')
        nexusUrl('localhost:8081/nexus')
        groupId('fr.afcepf.al32.groupe32')
        version('0.0.1-SNAPSHOT')
        repository('maven-snapshots')
        credentialsId('nexus')
        artifact {
            artifactId('nexus-artifact-uploader')
            type('war')
            classifier('debug')
            file('portailPromo_web\target\portailPromo_web-0.0.1-SNAPSHOT.war')
        }
      
      }
    }
}
  }
}