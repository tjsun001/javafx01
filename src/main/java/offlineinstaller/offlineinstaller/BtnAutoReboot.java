package offlineinstaller.offlineinstaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BtnAutoReboot extends Button implements EventHandler<ActionEvent>{
	final List<String> commands = new ArrayList<String>(); 
	ProcessBuilder processBuilder;
	Process process;
	String wsusHomePath ; 
	
	public BtnAutoReboot(ActionEvent event, String wsusHomePath)
	{
		this.wsusHomePath = wsusHomePath;
		handle(event);
	}
	public BtnAutoReboot() {	
		// TODO Auto-generated constructor stub
	}
	
	final static Logger logger = Logger.getLogger(BtnAutoReboot.class);
	public int dialogReturnValue;
	String autoRestartPath;
	Runtime runtime ;
	
	public void restart() {
			
	}

	@Override
	public void handle(ActionEvent arg0) {
		logger.info("Starting the AutoReboot");
		
		Thread rebootingMsgThread = new Thread() {
		    public void run() {
		        JOptionPane.showMessageDialog(null, "AutoReboot starting in 10 seconds");
		    }
		};
		rebootingMsgThread.start();
		try {
			rebootingMsgThread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		rebootingMsgThread.interrupt();
		
		commands.add("cmd.exe ");
		commands.add("/C");
		commands.add("start ");
		commands.add(wsusHomePath + "\\cmd\\RecallStub.cmd");
		logger.info("commands = " + commands.toString());
		
		processBuilder = new ProcessBuilder(commands);
		try {
			process = processBuilder.start();
		} catch (IOException e) {
			logger.error("process builder in autoRetart failed");
			e.printStackTrace();
		}
		
	}
}
