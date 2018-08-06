package offlineinstaller.offlineinstaller;
import java.io.IOException;
import org.apache.log4j.Logger;

public class AutoRestart{
	
	public AutoRestart(boolean autoRestart)
	{
		this.autoRestartOption = autoRestart;
	}

	final static Logger logger = Logger.getLogger(AutoRestart.class);
	public int dialogReturnValue;
	private String path;
	boolean autoRestartOption = false;
	Runtime runtime ;
	
	public void restart() {
			
			logger.info("Starting the AutoRestart part");
			
				runtime = Runtime.getRuntime();
				try {
					path = PropertiesLoader.getAutoRestartPath();
					Runtime.getRuntime().exec(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	}
