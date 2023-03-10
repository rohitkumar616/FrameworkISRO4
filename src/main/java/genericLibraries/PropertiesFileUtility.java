package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reuseable relted to actions performed on properties file.
 * 
 * @author SHALINI
 * @param path
 *
 */
public class PropertiesFileUtility {
	private Properties property;

	public void propertyFileInitialization(String path) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to fetch the data from properties file.
	 * 
	 * @param key
	 * @return
	 */
	public String fetchProperty(String key) {
		return property.getProperty(key);
	}

	/**
	 * This method is used to modify properties file.
	 * 
	 * @param path
	 * @param value
	 * @param key
	 * @param message
	 */
	public void modifyPropertiesFile(String path, String value, String key, String message) {
		property.put(key, value);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			property.store(fos, message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
