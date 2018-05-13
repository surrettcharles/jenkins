#!groovy

import jenkins.model.*
import hudson.util.*;
import jenkins.install.InstallState;
import java.util.logging.Logger;

Logger logger = Logger.getLogger("");

logger.info("Disabling install setup...");

def instance = Jenkins.getInstance();
instance.setInstallState(InstallState.INITIAL_SETUP_COMPLETED);

logger.info("Install setup disabled");
