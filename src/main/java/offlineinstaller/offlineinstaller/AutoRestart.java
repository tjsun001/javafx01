package offlineinstaller.offlineinstaller;
import java.io.IOException;
import java.util.Optional;

import org.apache.log4j.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class AutoRestart{
	
	public AutoRestart(boolean autoRestart)
	{
		this.autoRestartOption = autoRestart;
	}

	final static Logger logger = Logger.getLogger(BtnStart.class);
	public int dialogReturnValue;
	private String path;
	boolean autoRestartOption = false;
	
	public void restart() {
			
			logger.info("Starting the AutoRestart part");
			
				Runtime runtime = Runtime.getRuntime();
				try {
					path = PropertiesLoader.getAutoRestartPath();
					Runtime.getRuntime().exec(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	}
