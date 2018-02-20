job('Maven Shubham example') {
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
        shell("clean install")
    }
}
