def jobName = 'example'

multibranchPipelineJob(jobName) {
  branchSources {
    github {
      scanCredentialsId('github-ci')
      repoOwner('owner')
      repository('repo')
    }
  }
  orphanedItemStrategy {
    discardOldItems {
      numToKeep(10)
    }
  }
}

queue(jobName)
