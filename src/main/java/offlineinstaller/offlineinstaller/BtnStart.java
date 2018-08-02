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

public class BtnStart extends Button implements EventHandler<ActionEvent> {
	
	public BtnStart(ActionEvent event)
	{
		handle(event);
	}

	final static Logger logger = Logger.getLogger(BtnStart.class);
	public int dialogReturnValue;
	private String path;
	public void handle(ActionEvent event) {
			
			logger.info("Start button was clicked");
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Offline Installation");
			String s = "Are you sure you want to Start Installation ?";
			alert.setContentText(s);
			Optional<ButtonType> result = alert.showAndWait();
			if ((result.get() == ButtonType.OK)){
				logger.info("Yes was pressed ");
				Runtime runtime = Runtime.getRuntime();
				try {
					path = PropertiesLoader.getInstallerPath();
//					path = "cmd /c start cmd.exe /K \"dir && cd C:\\Users\\Administrator\\Downloads\\wsus\\cmd\\ && doUpdate.cmd\"";
//					path = "cmd /c start cmd.exe /K \"dir && cd C:\\Users\\Administrator\\Downloads\\wsus\\cmd\\doUpdate.cmd\"";
					Runtime.getRuntime().exec(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else { if((result.get().equals(ButtonType.CANCEL))){
				logger.info("Cancel was pressed " );			
			}
			}
				
			if (dialogReturnValue == 1) {
				logger.info("No was pressed " + dialogReturnValue);
			}
	}
	}
