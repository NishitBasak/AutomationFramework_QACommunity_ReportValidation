package qa.reportValidation.helper.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import qa.reportValidation.helper.resource.ResourceHelper;

public class PropertiesHelper {

	/**
	 * Return particular value with respect to a particular keyword from properties
	 * file Method overloaded with String type input parameter
	 * 
	 * @param keyword
	 * @return String
	 */
	public static String getProperties(String keyword) {

		String propPath = ResourceHelper.getResourcePath("src\\main\\resources\\configuration.properties");
		File file = new File(propPath);

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(keyword);
	}

	/**
	 * Return particular value with respect to a particular keyword from properties
	 * file Method overloaded with int type input parameter
	 * 
	 * @param keyword
	 * @return String
	 */
	public static String getProperties(int keyword) {

		String propPath = ResourceHelper.getResourcePath("src\\main\\resources\\configuration.properties");
		File file = new File(propPath);

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(Integer.toString(keyword));
	}

}
