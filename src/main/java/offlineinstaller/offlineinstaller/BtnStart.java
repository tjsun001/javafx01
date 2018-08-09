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
	Runtime runtime;
	Process process;
	int exitValue;
	
	@SuppressWarnings("restriction")
	public void handle(ActionEvent event) {
			
			logger.info("Start button was clicked");
			dialogReturnValue = JOptionPane.showConfirmDialog(null, "Are you sure you want to Start ?", "Start", JOptionPane.YES_NO_OPTION);
			if (dialogReturnValue == 0){
				logger.info("Yes was pressed ");
				try {
					runtime = Runtime.getRuntime(); 
					process = runtime.exec(wsusHomePath);
					
					exitValue = process.waitFor();
					executionStatus = this.setExecutionStatus(exitValue);
					
					if (executionStatus) {
						
					}
					
				} catch (IOException e) {
					e.printStackTrace();
					executionStatus = false;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	public boolean setExecutionStatus(int status) {
		exitValue = status;
		if (status == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	public String constructHomePath(String wsusHomePath) {
		wsusHomePath = "cmd /c start cmd.exe /K " + wsusHomePath + "\\cmd\\doUpdate.cmd";
		return wsusHomePath;
	}
}
