package qa.reportValidation.helper.fileNameFinder;

import java.io.File;

import qa.reportValidation.helper.resource.ResourceHelper;
import qa.reportValidation.helper.wait.SleepWaitHelper;

public class LatestFileName {

	/**
	 * Check for last downloaded file and return the filename
	 * 
	 * @param directory
	 * @param extension
	 * @return String
	 */
	public static String latestFileName(String directory, String extension) {
		SleepWaitHelper.sleep(2000);
		String s1 = directory + " (";
		String s2 = ")" + extension;
		int i = 1;
		String uniqueFileName = directory + extension;
		String fileName = "";

		while (fileExistenceCheck(uniqueFileName)) {
			fileName = uniqueFileName;
			uniqueFileName = s1 + i + s2;
			i++;
		}
		return fileName;
	}

	/**
	 * Check the existence of a particular file
	 * 
	 * @param fileName
	 * @return boolean
	 */
	private static boolean fileExistenceCheck(String fileName) {
		File file = new File(ResourceHelper.getResourcePath(fileName));
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
}
