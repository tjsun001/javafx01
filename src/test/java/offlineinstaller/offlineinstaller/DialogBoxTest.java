package offlineinstaller.offlineinstaller;

//import java.util.Optional;

import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DialogBoxTest extends Application implements EventHandler<ActionEvent>{
	final static Logger logger = Logger.getLogger(DialogBoxTest.class);
	Button btnAlertTest;
	Stage primaryStage;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("JavaFX DialogBox Test");
				
//		Alert alert = new Alert(AlertType.CONFIRMATION);
//		alert.setTitle("Offline Installation");
//		String s = "Are you sure you want to Start Installation ?";
//		alert.setContentText(s);
//		
//		Optional<ButtonType> result = alert.showAndWait();
//		if ((result.get() == ButtonType.OK)){
//			logger.info("Yes was pressed ");
//		}else { if((result.get().equals(ButtonType.CANCEL))){
//			logger.info("Cancel was pressed " );			
//		}
//		}
	}

	@Override
	public void handle(ActionEvent event) {
		
	}

}
