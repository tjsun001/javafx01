package offlineinstaller.offlineinstaller;
/**
 * 
 */

import org.apache.log4j.Logger;

/**
 * @author 584326
 *
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class Main extends Application implements EventHandler<ActionEvent>{
	final static Logger logger = Logger.getLogger(Main.class);

	/**
	 * @param args
	 */
	BtnStart btnStart;
	BtnExit btnExit;
	CheckBox checkBoxAutoRestart;
	Scene scene;
	Stage primaryStage;
	int dialogReturnValue;
	boolean autoRestartOption = false;
	boolean executionStatus;
	AutoRestart autoRestart;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		logger.info("this is start of start method");
		primaryStage.setTitle("Offline Installer");
		this.primaryStage = primaryStage;
		
		btnStart = new BtnStart();
		btnStart.setText("Start");
		btnStart.setLayoutX(10);
		btnStart.setLayoutY(60);
		btnStart.setOnAction(this);
			
		btnExit = new BtnExit();
		btnExit.setText("Exit");
		btnExit.setLayoutX(75);
		btnExit.setLayoutY(60);
		btnExit.setOnAction(this);
		
		checkBoxAutoRestart = new CheckBox("Auto Restart");
		checkBoxAutoRestart.setLayoutX(10);
		checkBoxAutoRestart.setLayoutY(120);
		
		Pane layout = new Pane();
		layout.getChildren().add(btnStart);
		layout.getChildren().add(btnExit);
		layout.getChildren().add(checkBoxAutoRestart);
		
		scene = new Scene(layout,400,200);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void handle(ActionEvent event) {
		
		String whichButton = ((Button)event.getSource()).getText();
		
		switch (whichButton) {
		case "Start":
			
			
			btnStart = new BtnStart(event);		
			executionStatus = btnStart.getExecutionStatus();
			
			if (executionStatus) {
//				checkAutoRestart();
			}			
		
			break;
			
		case "Exit":
			logger.info("Exit button was clicked");
			
			btnExit = new BtnExit(event,primaryStage);
			break;
		}
		

	}
	public void checkAutoRestart() {
		if (checkBoxAutoRestart.isSelected()) {
			autoRestartOption = true;
			autoRestart = new AutoRestart(autoRestartOption);
			autoRestart.restart();
		}
		else {
			autoRestartOption = false;
		}
		logger.info("Auto Restart = " + autoRestartOption );
		
	}
}