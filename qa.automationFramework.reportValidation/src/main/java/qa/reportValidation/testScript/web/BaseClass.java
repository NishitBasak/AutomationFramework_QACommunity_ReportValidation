package qa.reportValidation.testScript.web;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.reportValidation.helper.properties.PropertiesHelper;

public class BaseClass {

	public static WebDriver driver;
	static int selectByValue = 0;

	static WebPageTask webPageTask = new WebPageTask(driver);
	static ReportValidation reportValidation = new ReportValidation();

	@BeforeTest
	private void setProperty() {
		webPageTask.setProperty();
	}

	@Test(priority = 1)
	public static void testCase1() {
		webPageTask.defaultReportGeneration();
		boolean result = reportValidation.excelCompare("default_report.xlsx");
		assertEquals(result, true);

	}

	@Test(priority = 2)
	public void testCase2() {
		boolean isRecordFound = webPageTask.specificReportGeneration(selectByValue);
		if (isRecordFound == true) {
			boolean result = reportValidation.excelCompare(PropertiesHelper.getProperties(selectByValue));
			assertEquals(result, true);
		} else
			System.out.println(
					"There are no records exist for this filter: " + (PropertiesHelper.getProperties(selectByValue)));

	}

	@Test(priority = 3)
	public void testCase3() {
		selectByValue++;
		boolean isRecordFound = webPageTask.specificReportGeneration(selectByValue);
		if (isRecordFound == true) {
			boolean result = reportValidation.excelCompare(PropertiesHelper.getProperties(selectByValue));
			assertEquals(result, true);
		} else
			System.out.println(
					"There are no records exist for this filter: " + (PropertiesHelper.getProperties(selectByValue)));

	}

	@Test(priority = 4)
	public void testCase4() {
		selectByValue++;
		boolean isRecordFound = webPageTask.specificReportGeneration(selectByValue);
		if (isRecordFound == true) {
			boolean result = reportValidation.excelCompare(PropertiesHelper.getProperties(selectByValue));
			assertEquals(result, true);
		} else
			System.out.println(
					"There are no records exist for this filter: " + (PropertiesHelper.getProperties(selectByValue)));
	}

	@Test(priority = 5)
	public void testCase5() {
		selectByValue++;
		boolean isRecordFound = webPageTask.specificReportGeneration(selectByValue);
		if (isRecordFound == true) {
			boolean result = reportValidation.excelCompare(PropertiesHelper.getProperties(selectByValue));
			assertEquals(result, true);
		} else
			System.out.println(
					"There are no records exist for this filter: " + (PropertiesHelper.getProperties(selectByValue)));
	}

	@Test(priority = 6)
	public void testCase6() {
		selectByValue++;
		boolean isRecordFound = webPageTask.specificReportGeneration(selectByValue);
		if (isRecordFound == true) {
			boolean result = reportValidation.excelCompare(PropertiesHelper.getProperties(selectByValue));
			assertEquals(result, true);
		} else
			System.out.println(
					"There are no records exist for this filter: " + (PropertiesHelper.getProperties(selectByValue)));
	}

	@Test(priority = 7)
	public void testCase7() {
		selectByValue++;
		boolean isRecordFound = webPageTask.specificReportGeneration(selectByValue);
		if (isRecordFound == true) {
			boolean result = reportValidation.excelCompare(PropertiesHelper.getProperties(selectByValue));
			assertEquals(result, true);
		} else
			System.out.println(
					"There are no records exist for this filter: " + (PropertiesHelper.getProperties(selectByValue)));
	}

	@Test(priority = 8)
	public void testCase8() {
		selectByValue++;
		boolean isRecordFound = webPageTask.specificReportGeneration(selectByValue);
		if (isRecordFound == true) {
			boolean result = reportValidation.excelCompare(PropertiesHelper.getProperties(selectByValue));
			assertEquals(result, true);
		} else
			System.out.println(
					"There are no records exist for this filter: " + (PropertiesHelper.getProperties(selectByValue)));
	}

	@AfterTest
	public void quit() {
		webPageTask.close();
	}

}
