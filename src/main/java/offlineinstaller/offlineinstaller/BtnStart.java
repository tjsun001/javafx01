package offlineinstaller.offlineinstaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	private List<String> wsusHomePath;
	Runtime runtime;
	Process process;
	int exitValue;
	final List<String> commands = new ArrayList<String>(); 
	ProcessBuilder processBuilder;
	
	@SuppressWarnings("restriction")
	public void handle(ActionEvent event) {
			
			logger.info("Start button was clicked");
			dialogReturnValue = JOptionPane.showConfirmDialog(null, "Are you sure you want to Start ?", "Start", JOptionPane.YES_NO_OPTION);
			if (dialogReturnValue == 0){
				logger.info("Yes was pressed ");
				try {
					
					processBuilder = new ProcessBuilder(commands);
					process = processBuilder.start();
					Thread runningMsgThread = new Thread() {
					    public void run() {
					        JOptionPane.showMessageDialog(null, "Offline install is currently running");
					    }
					};
					runningMsgThread.start();
					exitValue = process.waitFor();
					runningMsgThread.interrupt();
					
					Thread completedMsgThread = new Thread() {
					    public void run() {
					        JOptionPane.showMessageDialog(null, "Offline install has completed", null, JOptionPane.INFORMATION_MESSAGE);
					    }
					};
					completedMsgThread.start();
					Thread.sleep(10000);
					completedMsgThread.interrupt();
					
					this.setExecutionStatus(exitValue);
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
	public void setExecutionStatus(int status) {
		
		if (status == 0) {
			executionStatus = true;
		}else {
			executionStatus = false; 
		}		
	}
	public List<String> constructHomePath(String wsusHomePath) {
		
		commands.add("cmd ");
		commands.add("/C");
		commands.add("start /wait cd_script.cmd");
		
		return commands;
	}
}
