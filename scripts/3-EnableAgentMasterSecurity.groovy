// Harden Jenkins and remove all the nagging warnings in the web interface
import jenkins.model.Jenkins;
import jenkins.security.s2m.*;
import java.util.logging.Logger;

Logger logger = Logger.getLogger("");

Jenkins jenkins = Jenkins.getInstance();

logger.info("Enabling Agent -> Master security subsystem...");

// Enable Agent to master security subsystem
jenkins.injector.getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false);

logger.info("Agent -> Master security subsystem enabled");
