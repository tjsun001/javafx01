package offlineinstaller.offlineinstaller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import javafx.scene.control.Button;

public class BtnReviewLog extends Button {
	final static Logger logger = Logger.getLogger(BtnReviewLog.class);
	ProcessBuilder processBuilder;
	final List<String> commands = new ArrayList<String>();
	Process process;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public void reviewLog() {

	logger.info("ReviewLog button was clicked");
		try {
			commands.add("cmd.exe ");
			commands.add("/C");
			commands.add("%windir%\\system32\\notepad.exe c:/temp/offline_install.log");
			
			processBuilder = new ProcessBuilder(commands);
			process = processBuilder.start();
											
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
