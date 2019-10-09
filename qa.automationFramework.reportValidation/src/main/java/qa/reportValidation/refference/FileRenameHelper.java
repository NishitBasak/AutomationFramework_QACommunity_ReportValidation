package qa.reportValidation.refference;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

import qa.reportValidation.helper.resource.ResourceHelper;
import qa.reportValidation.helper.wait.SleepWaitHelper;

public class FileRenameHelper {

	public static void main(String[] args) {
		renameFile("downloadedFile\\site_logs_by_day_of_week_report", ".xlsx");
	}

	public static void renameFile(String directory, String extension) {
		SleepWaitHelper.sleep(2000);
		File f1 = new File(ResourceHelper.getResourcePath(directory + extension));
		if (!f1.exists()) {
			return;
		}
		String s1 = directory + "_";
		String s2 = extension;
		int i = 1;
		String uniqueFileName = s1 + i + s2;
		while (fileExistenceCheck(uniqueFileName)) {
			i++;
			uniqueFileName = s1 + i + s2;
		}
		File f2 = new File(ResourceHelper.getResourcePath("refferenceFile\\" + uniqueFileName));
		try {
			f2.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Files.copy(f1, f2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		f1.delete();

	}

	private static boolean fileExistenceCheck(String fileName) {
		File file = new File(ResourceHelper.getResourcePath("refferenceFile\\" + fileName));
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

}
