package offlineinstaller.offlineinstaller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesLoader {
	private static Properties properties;
	public static String installerPath;
	final static Logger logger = Logger.getLogger(PropertiesLoaderTest.class);
	
	public static String getInstallerPath() {
		
		properties = new Properties();
		try {
			InputStream input = PropertiesLoaderTest.class.getClassLoader().getResourceAsStream("config.properties");
			properties.load(input);
			installerPath = properties.getProperty("installerPath");
			return installerPath;
		} catch (IOException  e) {
			e.printStackTrace();
		}
		return null;
	}

}
