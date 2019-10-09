package qa.reportValidation.helper.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Itestlistener implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " test case started...");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the testcase PASSED is :" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of the testcase FAILED is :" + result.getName());
		System.out.println("Error Message: " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of the testcase SKIPPED is :" + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}
	
}
