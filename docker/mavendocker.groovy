job('Maven_Shubham_JOB') {
    scm {
        git('git://github.com/shubhamj-cuelogic/dockerRemoteProject.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('shubham.jain@cuelogic.co.in')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('sjain21/dockerremote')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('shubhamjain1234')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
