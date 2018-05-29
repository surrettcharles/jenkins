#!groovy

import jenkins.model.*
import hudson.util.*;
import jenkins.install.InstallState;
import java.util.logging.Logger;

Logger logger = Logger.getLogger("");

def instance = Jenkins.getInstance();

if(instance.getSetupWizard() != null) {
	logger.info("Disabling install setup...");
	instance.setInstallState(InstallState.INITIAL_SETUP_COMPLETED);
	logger.info("Install setup disabled");
} else {
	logger.info("Setup already disabled, skipping");
}
