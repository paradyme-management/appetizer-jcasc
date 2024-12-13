String jobFolderName = 'appetizer'
String orgName = 'paradyme-management'
String applicationGithubCredId = 'appetizer-github-credentials'

multibranchPipelineJob("$jobFolderName/appetizer-server") {
    branchSources {
        github {
            id(UUID.randomUUID().toString())
            scanCredentialsId(applicationGithubCredId)
            checkoutCredentialsId(applicationGithubCredId)
            repoOwner(orgName)
            repository("appetizer-server")
            buildOriginBranch(true)
            buildOriginBranchWithPR(true)
            buildOriginPRHead(true)
            buildOriginPRMerge(true)
        }
    }
    configure {
        it / 'projectFactories' << 'org.boozallen.plugins.jte.job.TemplateMultiBranchProjectFactory' {
        }
        it / factory(class: 'org.boozallen.plugins.jte.job.TemplateBranchProjectFactory') {
            filterBranches(true)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(3)
            daysToKeep(3)
        }
    }
}

multibranchPipelineJob("$jobFolderName/appetizer-ui") {
    branchSources {
        github {
            id(UUID.randomUUID().toString())
            scanCredentialsId(applicationGithubCredId)
            checkoutCredentialsId(applicationGithubCredId)
            repoOwner(orgName)
            repository("appetizer-ui")
            buildOriginBranch(true)
            buildOriginBranchWithPR(true)
            buildOriginPRHead(true)
            buildOriginPRMerge(true)
        }
    }
    configure {
        it / 'projectFactories' << 'org.boozallen.plugins.jte.job.TemplateMultiBranchProjectFactory' {
        }
        it / factory(class: 'org.boozallen.plugins.jte.job.TemplateBranchProjectFactory') {
            filterBranches(true)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(3)
            daysToKeep(3)
        }
    }
}

