package offlineinstaller.offlineinstaller;
import java.io.IOException;
//import java.util.Optional;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class BtnStart extends Button implements EventHandler<ActionEvent> {
	
	public BtnStart(ActionEvent event, String wsusPath)
	{	
		this.wsusHomePath = constructHomePath(wsusPath);
		handle(event);
	}

	public BtnStart() {	
		// TODO Auto-generated constructor stub
	}

	final static Logger logger = Logger.getLogger(BtnStart.class);
	public int dialogReturnValue;
	private boolean executionStatus = false;
	private String wsusHomePath;
	
	@SuppressWarnings("restriction")
	public void handle(ActionEvent event) {
			
			logger.info("Start button was clicked");
			dialogReturnValue = JOptionPane.showConfirmDialog(null, "Are you sure you want to Start ?", "Start", JOptionPane.YES_NO_OPTION);
			if (dialogReturnValue == 0){
				logger.info("Yes was pressed ");
				try {
					Runtime.getRuntime().exec(wsusHomePath);
					executionStatus = true;
				} catch (IOException e) {
					e.printStackTrace();
					executionStatus = false;
				}
			}else { if((dialogReturnValue == 1)){
				logger.info("Cancel was pressed " );			
			}
			}
				
			if (dialogReturnValue == 1) {
				logger.info("No was pressed " + dialogReturnValue);
			}
	}
	public boolean getExecutionStatus() {
		return executionStatus;
	}
	public void setExecutionStatus(boolean status) {
		executionStatus = status;
		
	}
	public String constructHomePath(String wsusHomePath) {
		wsusHomePath = "cmd /c start cmd.exe /K " + wsusHomePath + "\\cmd\\doUpdate.cmd";
		return wsusHomePath;
	}
}
