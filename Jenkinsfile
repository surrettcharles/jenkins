pipeline {
	agent any

	options {
		buildDiscarder(logRotator(numToKeepStr: '10'))
		timestamps()
	}

	stages {
		stage('Determine Version') {
			steps {
				script {
					if(BRANCH_NAME =~ /^master$/) {
						buildType = 'release'
					} else {
						buildType = 'feature'
						env.feature = BRANCH_NAME.replace('features/', '')
					}

					if(buildType == 'release') {
						versionNumber = VersionNumber projectStartDate: '', versionNumberString: '${BUILD_YEAR}.${BUILD_MONTH}.R${BUILDS_THIS_MONTH_Z}', versionPrefix: '', worstResultForIncrement: 'SUCCESS'
					} else {
						versionNumber = VersionNumber projectStartDate: '', versionNumberString: '${BUILD_YEAR}.${BUILD_MONTH}.F${feature}.${BUILDS_THIS_MONTH_Z}', versionPrefix: '', worstResultForIncrement: 'SUCCESS'
					}
				}
			}
		}
		stage('Tag SCM') {
			steps {
				sshagent(['github']) {
					sh "git tag -a -m 'Jenkins build' ${versionNumber}"
					sh "git push --tags --set-upstream origin ${GIT_BRANCH}"
				}
			}
		}
	}
	post {
		always {
			cleanWs notFailBuild: true
		}
	}
}
