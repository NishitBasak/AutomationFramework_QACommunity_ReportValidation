package qa.reportValidation.helper.reporting;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import qa.reportValidation.helper.resource.ResourceHelper;

public class AventExtentReport_Listeners extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {
		htmlReporter = new ExtentHtmlReporter(
				ResourceHelper.getResourcePath("test-result\\Report.html"));// directory of the generated report

		htmlReporter.loadXMLConfig(ResourceHelper.getResourcePath("src\\main\\resources\\extent_config.xml"));

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "SVINDK00069");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "NISHIT");
		htmlReporter.config().setDocumentTitle("Automation Framework"); // Title of report
		htmlReporter.config().setReportName("Report Validation"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
																							// information to the report
																							// with GREEN color
																							// highlighted
	}

	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information
		logger.log(Status.FAIL, tr.getThrowable()); // to the report with GREEN
	}
	public void onTestSkipped(ITestResult tr) {

		logger = extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}