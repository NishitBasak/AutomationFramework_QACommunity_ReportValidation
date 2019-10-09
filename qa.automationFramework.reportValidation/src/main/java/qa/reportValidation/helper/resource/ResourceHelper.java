package qa.reportValidation.helper.resource;

public class ResourceHelper {

	/**
	 * Return absolute path of a file
	 * 
	 * @param path
	 * @return String
	 */
	public static String getResourcePath(String path) {
		String basePath = System.getProperty("user.dir");
		return basePath + "\\" + path;
	}
}
