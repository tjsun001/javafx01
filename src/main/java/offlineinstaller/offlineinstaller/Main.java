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

public class Main extends Application implements EventHandler<ActionEvent>{
	final static Logger logger = Logger.getLogger(Main.class);

	/**
	 * @param args
	 */
	Button btnStart;
	Button btnExit;
	Scene scene;
	Stage primaryStage;
	int dialogReturnValue;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		logger.info("this is start of start method");
		primaryStage.setTitle("Offline Installer");
		this.primaryStage = primaryStage;
		
		btnStart = new Button();
		btnStart.setText("Start");
		btnStart.setLayoutY(100);
		btnStart.setLayoutX(10);
		btnStart.setOnAction(this);
			
		btnExit = new Button();
		btnExit.setText("Exit");
		btnExit.setLayoutX(200);
		btnExit.setLayoutY(100);
		btnExit.setOnAction(this);
		
		Pane layout = new Pane();
		layout.getChildren().add(btnStart);
		layout.getChildren().add(btnExit);
		
		scene = new Scene(layout,400,200);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void handle(ActionEvent event) {
		
		String whichButton = ((Button)event.getSource()).getText();
		
		switch (whichButton) {
		case "Start":
			
			btnStart = new BtnStart(event);
		
			break;
			
		case "Exit":
			logger.info("Exit button was clicked");
			
			btnExit = new BtnExit(event,primaryStage);
			break;
		}

	}
}