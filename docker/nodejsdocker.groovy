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
            repositoryName('sjain21/jenkins')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('CBR!@fusionfactory1234')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
