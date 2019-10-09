package qa.reportValidation.refference;

import java.io.File;

import qa.reportValidation.helper.resource.ResourceHelper;
import qa.reportValidation.helper.wait.SleepWaitHelper;

public class FileRename {
	public static void main(String[] args) {
		  renameFile("downloadedFile\\site_logs_by_day_of_week_report", ".xlsx"); 
		  }
		  
		 

		public static void renameFile(String directory, String extension) {
			SleepWaitHelper.sleep(2000);
			File f1 = new File(ResourceHelper.getResourcePath(directory + extension));
			System.out.println("F1:"+f1.getName());
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
			File f2 = new File(ResourceHelper.getResourcePath(uniqueFileName));
			System.out.println("F2:"+f2.getName());
			boolean b = f1.renameTo(f2);
			System.out.println("???????????????"+b);
			System.out.println(f1.exists()+"F3:"+f1.getName());
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
