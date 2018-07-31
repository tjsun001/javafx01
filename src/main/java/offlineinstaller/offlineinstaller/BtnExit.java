package offlineinstaller.offlineinstaller;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BtnExit extends Button implements EventHandler<ActionEvent> {
	
	ActionEvent event;
	Stage PrimaryStage;
	final static Logger logger = Logger.getLogger(BtnExit.class);

	public static void main1(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public BtnExit(ActionEvent event, Stage primaryStage)
	{
		this.event 			= event;
		this.primaryStage 	= primaryStage;
		this.primaryStage.toString();
		handle(event);
	}

	/**
	 * @param args
	 */
	Stage primaryStage;
	int dialogReturnValue;
	
	public void handle(ActionEvent event) {
			
		logger.info("Exit button was clicked");
		dialogReturnValue 		= JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit ?", "Exit", JOptionPane.YES_NO_OPTION);
		if (dialogReturnValue 	== 0) {
			logger.info("Yes was pressed " + dialogReturnValue);
			this.primaryStage.close();
		}
		if (dialogReturnValue	 == 1) {
			logger.info("No was pressed " + dialogReturnValue);
		}
		}

	}
