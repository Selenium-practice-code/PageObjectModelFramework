package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

import com.qa.utilities.ExcelReader;
import com.qa.utilities.ExtentManager;
import com.qa.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Page {

	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(Page.class);
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/com/qa/excel/testdata.xlsx");
	public static WebDriverWait wait;
	public static ExtentReports rep = ExtentManager.getInstance();
	public static String browser;
	public static ExtentTest test;
	public static WebElement dropdown;
	public static TopMenu menu;

	public Page() {

		// Create a Time Stamp for logs
		Date d = new Date();
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));

		// Configure the logger file
		PropertyConfigurator.configure("./src/test/resources/com/qa/properties/log4j.properties");

		// Initially the driver is Null
		if (driver == null) {

			// Initialize OR and Config Properties file
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/com/qa/properties/Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
				log.info("Load Config Properties File");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/com/qa/properties/OR.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				OR.load(fis);
				log.info("Load OR Properties File");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Jenkins Browser Filter Configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				// Pick the Browser filter from Jenkins
				browser = System.getenv("browser");

			} else {

				// if No filter select from Jenkins browser pick form Config Properties file
				browser = Config.getProperty("browser");
			}

			Config.setProperty("browser", browser);

			// Launching the Browsers using Config properties file
			if (Config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/test/resources/com/qa/executables/chromedriver");

				// Chrome Options
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);

				ChromeOptions options = new ChromeOptions();

				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				driver = new ChromeDriver(options);

				log.info("Chrome Browser Launched.");

			} else if (Config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/src/test/resources/com/qa/executables/geckodriver");

				driver = new FirefoxDriver();
				log.info("Firefox Browser Launched");

			} else if (Config.getProperty("browser").equals("safari")) {

				driver = new SafariDriver();
				log.info("Safari Browser Launched");
			}

			// Hit the URL
			driver.get(Config.getProperty("testSiteUrl"));
			log.info("Navigating to :--> " + (Config.getProperty("testSiteUrl")));

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

			// explicit wait
			wait = new WebDriverWait(driver, 5);

			menu = new TopMenu(driver);
		}
	}

	// Method for Click on Element
	public void click(String locator) {

		if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).click();
		}

		// Extent Report log
		test.log(LogStatus.INFO, "Clicking on :-> " + locator);

		// log4j logs
		log.info("Clicking on :-> " + locator);
	}

	// Method for type keyword
	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}

		// Extent Report log
		test.log(LogStatus.INFO, "Typing in :-> " + locator + " Enterd value as :-> " + value);

		// log4j logs
		log.info("Typing in :-> " + locator + " Enterd value as :-> " + value);
	}

	// Creating Keyword for DropDown
	public void select(String locator, String value, String type) {

		if (locator.endsWith("_CSS")) {

			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));

		} else if (locator.endsWith("_XPATH")) {

			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));

		} else if (locator.endsWith("_ID")) {

			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);

		// Generic Method DropDown
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;

		default:
			log.info("Please pass the correct values..");
			break;
		}

		test.log(LogStatus.INFO, "Selecting from dropdown :-> " + locator + " Value as :-> " + value);
		log.info("Selecting from dropdown :-> " + locator + " Value as :-> " + value);

	}

	// Checking The presence of Element
	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;
		}

	}

	// Creating Soft Assertion Method For
	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			// Capturing Screenshot
			Utilities.captureScreenshot();

			// Adding log in Reportng
			Reporter.log("<br>" + "Verification faliure :  " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src="
					+ Utilities.screenshotName + " height=100 width=1 00></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Reports
			test.log(LogStatus.FAIL, "Verification failed with exception : " + t.getMessage());
			// Add Screenshot in Extent Report
			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));
		}
	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {

			driver.quit();
		}

		log.info("Test successfully Executed !!!");

	}

}
