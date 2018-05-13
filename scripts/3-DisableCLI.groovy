/**
* shutdown jenkins CLI
*
* as advised in https://github.com/jenkinsci-cert/SECURITY-218, this script
* will shutdown the Jenkins CLI components
*
**/

import java.util.logging.Logger
import jenkins.*;
import jenkins.model.*;
import hudson.model.*;

Logger logger = Logger.getLogger("")
Jenkins jenkins = Jenkins.getInstance()

// disable remoting cli
jenkins.getDescriptor("jenkins.CLI").get().setEnabled(false)

// disabled CLI access over TCP listener (separate port)
def p = AgentProtocol.all()
p.each { x ->
    if (x.name && x.name.contains("CLI")) {
        p.remove(x)
    }
}

// disable CLI access over /cli URL
def removal = { lst ->
    lst.each { x ->
        if (x.getClass().name.contains("CLIAction")) {
            lst.remove(x)
        }
    }
}

logger.info("Removing the Jenkins CLI subsystem")
removal(jenkins.getExtensionList(RootAction.class))
removal(jenkins.actions)
