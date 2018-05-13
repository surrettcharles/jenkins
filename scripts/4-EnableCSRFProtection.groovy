import hudson.security.csrf.DefaultCrumbIssuer;
import jenkins.model.Jenkins;
import java.util.logging.Logger;

Logger logger = Logger.getLogger("");

logger.info("Configuring CSRF protection...");

def instance = Jenkins.instance;
instance.setCrumbIssuer(new DefaultCrumbIssuer(true));
instance.save();

logger.info("CSRF protection enabled");
