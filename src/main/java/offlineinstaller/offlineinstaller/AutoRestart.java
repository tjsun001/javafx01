package offlineinstaller.offlineinstaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AutoRestart{
	final List<String> commands = new ArrayList<String>(); 
	ProcessBuilder processBuilder;
	Process process;
	String wsusHomePath ; 
	
	public AutoRestart(String autoRestartPath)
	{
		this.wsusHomePath = autoRestartPath;
	}

	final static Logger logger = Logger.getLogger(AutoRestart.class);
	public int dialogReturnValue;
	String autoRestartPath;
	Runtime runtime ;
	
	public void restart() {
			
			logger.info("Starting the AutoRestart part");
			
			commands.add("cmd.exe ");
			commands.add("/C");
			commands.add(wsusHomePath + "/cmd/RecallStub.cmd");
			
						
			processBuilder = new ProcessBuilder(commands);
			try {
				process = processBuilder.start();
			} catch (IOException e) {
				logger.error("process builder in autoRetart failed");
				e.printStackTrace();
			}
	}
}
