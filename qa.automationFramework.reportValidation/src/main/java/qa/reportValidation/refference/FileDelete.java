package qa.reportValidation.refference;

import java.io.File;

import qa.reportValidation.helper.resource.ResourceHelper;
import qa.reportValidation.helper.wait.SleepWaitHelper;

public class FileDelete {

	public static void deleteFile(String directory, String extension) {
		SleepWaitHelper.sleep(2000);
		File f1 = new File(ResourceHelper.getResourcePath(directory + extension));
		if (!f1.exists()) {
			return;
		}
		renameFile(directory,extension);
	}
	
	private static void renameFile(String directory, String extension) {
		SleepWaitHelper.sleep(2000);
		File f1 = new File(ResourceHelper.getResourcePath(directory + extension));
		String s1 = directory + "_";
		String s2 = extension;
		int i = 1;
		String uniqueFileName = s1 + i + s2;
		while (fileExistenceCheck(uniqueFileName)) {
			i++;
			uniqueFileName = s1 + i + s2;
		}
		File f2 = new File(ResourceHelper.getResourcePath(uniqueFileName));
		boolean b = f1.renameTo(f2);
		System.out.println(b);
	}

	private static boolean fileExistenceCheck(String fileName) {
		File file = new File(ResourceHelper.getResourcePath(fileName));
		if (file.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
}
