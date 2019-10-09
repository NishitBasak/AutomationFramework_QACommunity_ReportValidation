package qa.reportValidation.testScript.web;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import qa.reportValidation.helper.properties.PropertiesHelper;
import qa.reportValidation.helper.resource.ResourceHelper;
import qa.reportValidation.helper.wait.WaitHelper;

public class WebPageTask {

	private WebDriver driver;

	public WebPageTask(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Set specific folder path for keeping downloaded file
	 * 
	 * @return
	 */
	private ChromeOptions setChromeOptions() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", ResourceHelper.getResourcePath("downloadedFile"));
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		return options;
	}

	/**
	 * Set webdriver property
	 */
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("./driver/chromedriver.exe"));
		driver = new ChromeDriver(setChromeOptions());
		driver.manage().window().maximize();
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.setImplicitWait(20, TimeUnit.SECONDS);
		waitHelper.pagLoadTime(60, TimeUnit.SECONDS);
	}

	/**
	 * Log in to the site and download the default report
	 */
	public void defaultReportGeneration() {
//		Xpath repository:
		String xusername = "//input[@id='username']";
		String xpassword = "//input[@id='password']";
		String xlogin = "//input[@id='loginbtn']";
		String xexport = "//input[@id='id_export']";

		driver.get(PropertiesHelper.getProperties("url"));
		driver.findElement(By.xpath(xusername)).sendKeys(PropertiesHelper.getProperties("username"));
		driver.findElement(By.xpath(xpassword)).sendKeys(PropertiesHelper.getProperties("password"));
		driver.findElement(By.xpath(xlogin)).click();

		dropDownFormatSelection("Excel");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(xexport)).click();
	}

	/**
	 * Search with particular filter and download report for that
	 * 
	 * @param i
	 * @return
	 */
	public boolean specificReportGeneration(int i) {
//		Xpath repository:
		String xsearchField = "//input[@id='id_user-fullname']";
		String xdropBox = "//select[@id='id_user-fullname_op']";
		String xsearch = "//input[@id='id_submitgroupstandard_addfilter']";
		String xexport = "//input[@id='id_export']";
		String xrecorddata = "//span[@class='rb-record-count']";

		WebElement dropBox = driver.findElement(By.xpath(xdropBox));
		Select select = new Select(dropBox);
		select.selectByIndex(i);
		System.out.println("Search filter by: "+ PropertiesHelper.getProperties(i));
		if (i < 5) {
			driver.findElement(By.xpath(xsearchField)).clear();
			driver.findElement(By.xpath(xsearchField)).sendKeys(PropertiesHelper.getProperties("searchby"));
		}
		driver.findElement(By.xpath(xsearch)).click();
		String recordData = driver.findElement(By.xpath(xrecorddata)).getText().toString();
		if (recordData.equals("0 records shown")) {
			return false;
		} else {
			dropDownFormatSelection(PropertiesHelper.getProperties("extensionformat"));
			driver.findElement(By.xpath(xexport)).click();
			return true;
		}
	}

	/**
	 * Select file format drop down before downloading a file
	 * 
	 * @param fileFormat
	 */
	private void dropDownFormatSelection(String fileFormat) {
		String xdropdown = "//select[@id='id_format']";
		WebElement dropDown = driver.findElement(By.xpath(xdropdown));
		Select select = new Select(dropDown);
		select.selectByVisibleText(fileFormat);
	}

	/**
	 * Closing the browser
	 */
	public void close() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
