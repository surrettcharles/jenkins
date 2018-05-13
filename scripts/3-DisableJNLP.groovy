// Harden Jenkins and remove all the nagging warnings in the web interface
import jenkins.*;
import jenkins.model.*;
import hudson.model.*;
import java.util.logging.Logger;

Logger logger = Logger.getLogger("");

Jenkins jenkins = Jenkins.getInstance();

logger.info("Disabling all JNLP protocols...");

// Disable jnlp
jenkins.setSlaveAgentPort(-1);
def p = AgentProtocol.all();
p.each { x ->
    if (x.name && x.name.contains("JNLP")) {
        p.remove(x);
    }
}

jenkins.save();

logger.info("JNLP protocols disabled")
