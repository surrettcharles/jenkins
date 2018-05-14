multibranchPipelineJob('example') {
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
