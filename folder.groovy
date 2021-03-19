String jenkinsTemplateLibraryUrl = 'https://github.com/paradyme-management/jte-the-basics.git'
String githubCredId = 'jenkins-library-access'
folder("appetizer") {
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
                                                repoUrl('https://github.com/paradyme-management/jte-the-basics')
                                            }
                                        }
                                        gitTool('/usr/bin/git')
                                        branches {
                                            branchSpec {
                                                name ('*/jte-2.0')
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
                        baseDir('appetizer2')
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
                                        repoUrl('https://github.com/paradyme-management/jte-the-basics')
                                    }
                                }
                                gitTool('/usr/bin/git')
                                branches {
                                    branchSpec {
                                        name ('*/jte-2.0')
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
