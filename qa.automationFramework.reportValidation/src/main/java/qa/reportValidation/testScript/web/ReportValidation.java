package qa.reportValidation.testScript.web;

import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import qa.reportValidation.helper.fileNameFinder.LatestFileName;
import qa.reportValidation.helper.properties.PropertiesHelper;
import qa.reportValidation.helper.resource.ResourceHelper;

public class ReportValidation {

	/**
	 * Validating the value of downloaded excel sheet with the reference sheet
	 * 
	 * @param baseFile
	 * @return boolean
	 */
	public boolean excelCompare(String baseFile) {
		String basefileName = "";
		HashMap<String, Integer> downloadedFIleData;
		HashMap<String, Integer> baseFileData;
		if (baseFile.equals("default_report.xlsx")) {
			basefileName = "baseFile\\" + baseFile;
			downloadedFIleData = getSheetValue1(
					LatestFileName.latestFileName("downloadedFile\\site_logs_by_day_of_week_report", ".xlsx"));
			System.out.println("downloadedFIleData: " + downloadedFIleData);
			baseFileData = getSheetValue1(ResourceHelper.getResourcePath(basefileName));
			System.out.println("baseFileData: " + baseFileData);
		} else {
			basefileName = "baseFile\\" + baseFile + "_john_report.xlsx";
			downloadedFIleData = getSheetValue4(
					LatestFileName.latestFileName("downloadedFile\\site_logs_by_day_of_week_report", ".xlsx"));
			System.out.println("downloadedFIleData: " + downloadedFIleData);
			baseFileData = getSheetValue4(ResourceHelper.getResourcePath(basefileName));
			System.out.println("baseFileData: " + baseFileData);
		}

		if (baseFileData.equals(downloadedFIleData) == true)
			System.out.println("RESULT: Report Verified");
		else
			System.out.println("RESULT: Report Mismatched");
		
		return baseFileData.equals(downloadedFIleData);
	}

	/**
	 * Get all the value from excel sheet, starting from row no. 1
	 * 
	 * @param fileDirectory
	 * @return HashMap
	 */
	private static HashMap<String, Integer> getSheetValue1(String fileDirectory) {
		Fillo fillo = new Fillo();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		try {
			Connection connection = fillo.getConnection(fileDirectory);

			System.setProperty("ROW", "1");
			Recordset recordset = connection.executeQuery(PropertiesHelper.getProperties("query"));
			while (recordset.next()) {
				hashmap.put(recordset.getField(0).value().toString(), Integer.parseInt(recordset.getField(1).value()));
			}
		} catch (FilloException e) {
			e.printStackTrace();
		}
		return hashmap;

	}

	/**
	 * Get all the value from excel sheet, starting from row no. 4
	 * 
	 * @param fileDirectory
	 * @return HashMap
	 */
	private static HashMap<String, Integer> getSheetValue4(String fileDirectory) {
		Fillo fillo = new Fillo();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		try {
			Connection connection = fillo.getConnection(fileDirectory);

			System.setProperty("ROW", "4");
			Recordset recordset = connection.executeQuery(PropertiesHelper.getProperties("query"));
			while (recordset.next()) {
				hashmap.put(recordset.getField(0).value().toString(), Integer.parseInt(recordset.getField(1).value()));
			}
		} catch (FilloException e) {
			e.printStackTrace();
		}
		return hashmap;

	}
}
