package com.qa.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	// Creating Method for ExtentReport, it gives the instance of ExtentReport
	public static ExtentReports getInstance() {

		if (extent == null) {

			extent = new ExtentReports(System.getProperty("user.dir") + "/target/surefire-reports/html/extent.html",
					true, DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(
					System.getProperty("user.dir") + "/src/test/resources/com/qa/extentconfig/ReportsConfig.xml"));

		}

		return extent;

	}
}
