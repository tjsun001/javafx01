package offlineinstaller.offlineinstaller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesLoader {
	private static Properties properties;
	public static String installerPath;
	public static String autoRestartPath;
	final static Logger logger = Logger.getLogger(PropertiesLoader.class);
	static InputStream input = PropertiesLoader.class.getClassLoader().getResourceAsStream("config.properties");
	
	public static String getInstallerPath() {
		
		properties = new Properties();
		try {
			properties.load(input);
			installerPath = properties.getProperty("installerPath");
			autoRestartPath = properties.getProperty("autoRestartPath");
			return installerPath;
		} catch (IOException  e) {
			e.printStackTrace();
		}
		return null;
	}
public static String getAutoRestartPath() {
		
		return autoRestartPath;
	}
}
