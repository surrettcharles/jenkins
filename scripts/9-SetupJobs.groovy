import javaposse.jobdsl.plugin.JenkinsDslScriptLoader;
import javaposse.jobdsl.plugin.JenkinsJobManagement;
import java.util.logging.Logger;

Logger logger = Logger.getLogger("");

String jobPath = System.getenv("JOB_PATH");
def jobDslDirectory = new File(jobPath);
def workspace = new File('.');

def jobManagement = new JenkinsJobManagement(System.out, [:], workspace);

logger.info("Loading DSL jobs...");

if(jobDslDirectory.exists()) {
	jobDslDirectory.eachFile { jobDslScript ->
		logger.info("Loading job ${jobDslScript.name}");
		new JenkinsDslScriptLoader(jobManagement).runScript(jobDslScript.text);
	};
}

logger.info("DSL jobs loaded");
