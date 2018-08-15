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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
	Label lblStatus;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		logger.info("this is start of start method");
		primaryStage.setTitle("Offline Installer");
		
		this.primaryStage = primaryStage;
		
		txtFieldWSUSHome = new TextField();
		txtFieldWSUSHome.setText("Please Enter path to WSUSHome  exp:(c:\\Users\\Administrator\\Downloads\\wsus)");
		txtFieldWSUSHome.setPrefColumnCount(35);
		
		txtFieldWSUSHome.setLayoutX(60);
		txtFieldWSUSHome.setLayoutY(200);
		txtFieldWSUSHome.setOnAction(this);
		txtFieldWSUSHome.setPrefColumnCount(35);
		
 		
		btnStart = new BtnStart();
		btnStart.setText("Start");
		btnStart.setLayoutX(150);
		btnStart.setLayoutY(250);
		btnStart.setOnAction(this);
			
		btnExit = new BtnExit();
		btnExit.setText("Exit");
		btnExit.setLayoutX(215);
		btnExit.setLayoutY(250);
		btnExit.setOnAction(this);
		
		checkBoxAutoRestart = new CheckBox("Auto Restart");
		checkBoxAutoRestart.setLayoutX(275);
		checkBoxAutoRestart.setLayoutY(250);
		
		Image image = new Image(new File("FPS_logo_2018.png").toURI().toString());
		ImageView imageView = new ImageView(image);
	
		imageView.setLayoutX(175);
		imageView.setLayoutY(30);
		imageView.setFitHeight(150);
		imageView.setFitWidth(150);
		
		Image image_BAH = new Image(new File("booz allen logo_black.png").toURI().toString());
		ImageView imageView_BAH = new ImageView(image_BAH);
		imageView_BAH.setLayoutX(300);
		imageView_BAH.setLayoutY(370);
		
		lblStatus = new Label();
		lblStatus.setLayoutX(150);
		lblStatus.setLayoutY(350);
				
		Pane layout = new Pane();
		layout.getChildren().add(btnStart);
		layout.getChildren().add(btnExit);
		layout.getChildren().add(checkBoxAutoRestart);
		layout.getChildren().add(txtFieldWSUSHome);
		layout.getChildren().add(imageView);
		layout.getChildren().add(lblStatus);
		layout.getChildren().add(imageView_BAH);
		
		scene = new Scene(layout,500,400);
		
		primaryStage.getIcons().add(image);
		primaryStage.setTitle("OfflineInstaller");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void handle(ActionEvent event) {
		
		String whichButton = ((Button)event.getSource()).getText();
		
		switch (whichButton) {
		case "Start":
			
			
			wsusHomePath = txtFieldWSUSHome.getText() ;
			logger.info("Eentered WSUS Home Path = " + wsusHomePath);
			if (wsusHomePath == null || wsusHomePath.isEmpty()) {
				txtFieldWSUSHome.setText("Please enter path to WSUS home directory");
				break;
			}else {
				
				pathDoesExist = checkWSUSHomePath(wsusHomePath); 
				if (pathDoesExist) {
					btnStart = new BtnStart(event, wsusHomePath);													
				}else {
					txtFieldWSUSHome.setText("Invalid Path;Please enter a valid path to WSUS home directory");
					break;
				}
			}	
			executionStatus = btnStart.getExecutionStatus();
			
			if (executionStatus) {
					lblStatus.setText("Installer Executed Successfully");
					logger.info("Offline Installer Executed Successfully");
					checkAutoRestart();
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
		if (file.exists()) {
			return true;
		}else{
			return false;
			}
		}
}
