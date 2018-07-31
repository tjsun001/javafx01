package offlineinstaller.offlineinstaller;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BtnExitTest extends Button implements EventHandler<ActionEvent> {
	
	ActionEvent event;
	Stage PrimaryStage;
	final static Logger logger = Logger.getLogger(BtnExitTest.class);

	public static void main1(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public BtnExitTest(ActionEvent event, Stage primaryStage)
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
//		dialogReturnValue 		= JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit ?", "Exit", JOptionPane.YES_NO_OPTION);
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Offline Installation");
		String s = "Are you sure you want to Exit Installation ?";
		alert.setContentText(s);
		
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.get() == ButtonType.OK)){
			logger.info("Yes was pressed ");
			this.primaryStage.close();
		}else{
			if((result.get().equals(ButtonType.CANCEL))){
			logger.info("Cancel was pressed " );			
			}
		}
	}
}

