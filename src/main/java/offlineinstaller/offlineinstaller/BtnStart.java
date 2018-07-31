package offlineinstaller.offlineinstaller;
import java.io.IOException;

import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BtnStart extends Button implements EventHandler<ActionEvent> {
	
	public BtnStart(ActionEvent event)
	{
		handle(event);
	}

	final static Logger logger = Logger.getLogger(BtnStart.class);
	private int dialogReturnValue;
	private String path;
	public void handle(ActionEvent event) {
			
			logger.info("Start button was clicked");
			dialogReturnValue = JOptionPane.showConfirmDialog(null, "Are you sure you want to Start ?", "Start", JOptionPane.YES_NO_OPTION);
			if (dialogReturnValue == 0) {
				logger.info("Yes was pressed " + dialogReturnValue);
				Runtime runtime = Runtime.getRuntime();
				try {
					path = PropertiesLoaderTest.getInstallerPath();
					String teststring = "runas /noprofile /user:BAHCND52190DT administrator ping";
					Runtime.getRuntime().exec(teststring);
//					runtime.exec(new String[] {path}); 
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			if (dialogReturnValue == 1) {
				logger.info("No was pressed " + dialogReturnValue);
			}
		}
	}
