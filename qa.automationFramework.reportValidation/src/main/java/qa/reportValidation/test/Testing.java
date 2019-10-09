package qa.reportValidation.test;

import java.io.File;

import qa.reportValidation.helper.properties.PropertiesHelper;
import qa.reportValidation.helper.resource.ResourceHelper;
import qa.reportValidation.refference.FileRenameHelper;

public class Testing {

	public static void main(String[] args) {

		String username = "0 records shown";
		String username2 = "0 records shown";

//		System.out.println(ResourceHelper.getResourcePath("downloadedFile\\site_logs_by_day_of_week_report.xlsx"));

//		System.out.println(PropertiesHelper.getProperties("query"));
//		FileRenameHelper.renameFile("downloadedFile\\site_logs_by_day_of_week_report", ".xlsx");

		System.out.println(System.getProperty("user.dir") + "/extent_config.xml");
		System.out.println(ResourceHelper.getResourcePath("src\\main\\resources\\extent_config.xml"));

	}
}
