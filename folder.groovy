String jenkinsTemplateLibraryUrl = 'https://github.com/paradyme-management/jenkins-template-engine.git'
String githubCredId = 'jenkins-library-access'
folder("appetizer") {
    displayName("appetizer")
    description("Folder for the appetizer application.")
    properties {
        templateConfigFolderProperty {
            tier {
                librarySources {
                    librarySource {
                        libraryProvider {
                            scmLibraryProvider {
                                baseDir('libraries')
                                scm {
                                    gitSCM {
                                        userRemoteConfigs {
                                            userRemoteConfig {
                                                url(jenkinsTemplateLibraryUrl)
                                                name('origin')
                                                refspec('+refs/heads/*:refs/remotes/origin/*')
                                                credentialsId(githubCredId)
                                            }
                                        }
                                        browser {
                                            githubWeb {
                                                repoUrl('https://github.com/paradyme-management/jenkins-template-engine')
                                            }
                                        }
                                        gitTool('/usr/bin/git')
                                        branches {
                                            branchSpec {
                                                name ('*/main')
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                configurationProvider {
                    scmPipelineConfigurationProvider {
                        baseDir('infrastructure')
                        scm {
                            gitSCM {
                                userRemoteConfigs {
                                    userRemoteConfig {
                                        url(jenkinsTemplateLibraryUrl)
                                        name('origin')
                                        refspec('+refs/heads/*:refs/remotes/origin/*')
                                        credentialsId(githubCredId)
                                    }
                                }
                                browser {
                                    githubWeb {
                                        repoUrl('https://github.com/paradyme-management/jenkins-template-engine')
                                    }
                                }
                                gitTool('/usr/bin/git')
                                branches {
                                    branchSpec {
                                        name ('*/main')
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
