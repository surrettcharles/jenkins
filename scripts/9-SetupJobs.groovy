import javaposse.jobdsl.plugin.JenkinsDslScriptLoader;
import javaposse.jobdsl.plugin.JenkinsJobManagement;
import java.util.logging.Logger;

Logger logger = Logger.getLogger("");

def jobDslDirectory = new File('/jenkins-jobs');
def workspace = new File('.');

def jobManagement = new JenkinsJobManagement(System.out, [:], workspace);

logger.info("Loading DSL jobs...");

jobDslDirectory.eachFile { jobDslScript ->
	logger.info("Loading job ${jobDslScript.name}");
	new JenkinsDslScriptLoader(jobManagement).runScript(jobDslScript.text);
};

logger.info("DSL jobs loaded");
