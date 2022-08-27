package com.qa.naveenautomation.utils;



	
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.commons.io.FileUtils;
	
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;

import com.qa.naveenautomation.factory.DriverFactory;

	

	public class Utils extends DriverFactory {
		public static final int PAGE_LOAD_WAIT=30;
		public static final int IMPLICIT_WAIT=10;

		public static void takeFailedTestScreenShot(String testCaseName) {
			
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			
			File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		
			try {
				FileUtils.copyFile(screenShotFile,
						new File("./FailedScreenShot\\" + "_" + testCaseName + "_" + timeStamp + ".jpeg"));
			} catch (IOException e) {
				System.out.println("Unable to save or take screen shot of failed test " + testCaseName);

			}

		}

}
