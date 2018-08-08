package offlineinstaller.offlineinstaller;
/**
 * 
 */

import java.io.File;

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
import javafx.scene.control.TextField;

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
	TextField txtFieldWSUSHome ;
	String wsusHomePath ;
	boolean pathDoesExist;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		logger.info("this is start of start method");
		primaryStage.setTitle("Offline Installer");
		this.primaryStage = primaryStage;
		
		txtFieldWSUSHome = new TextField();
		txtFieldWSUSHome.setText("Enter WSUSHome    exampe:(c:\\Users\\Administrator\\Downloads\\wsus)");
		txtFieldWSUSHome.setPrefColumnCount(35);
		
		txtFieldWSUSHome.setLayoutX(10);
		txtFieldWSUSHome.setLayoutY(25);
		txtFieldWSUSHome.setOnAction(this);
		
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
		layout.getChildren().add(txtFieldWSUSHome);
		
		scene = new Scene(layout,400,200);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void handle(ActionEvent event) {
		
		String whichButton = ((Button)event.getSource()).getText();
		
		switch (whichButton) {
		case "Start":
			
			
			wsusHomePath = txtFieldWSUSHome.getText() ;
			if (wsusHomePath == null || wsusHomePath.isEmpty()) {
				txtFieldWSUSHome.setText("Please enter path to WSUS home directory");
				break;
			}else {
				
				pathDoesExist = checkWSUSHomePath(wsusHomePath); 
				if (pathDoesExist) {
					btnStart = new BtnStart(event, wsusHomePath);													
				}else {
					txtFieldWSUSHome.setText("Please enter a valid path to WSUS home directory");
					break;
				}
			}	
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
	public boolean checkWSUSHomePath(String wsusHomePath) {
		
		File file = new File(wsusHomePath);
//		File file = new File("C:\\Users\\Administrator\\Downloads\\wsus\\cmd\\DoUpdate.cmd");
		if (file.exists()) {
			return true;
		}else{
			return false;
			}
		}
}
