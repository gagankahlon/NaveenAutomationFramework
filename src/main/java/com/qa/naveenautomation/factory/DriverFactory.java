package com.qa.naveenautomation.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;


import com.qa.naveenautomation.utils.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;
	public Properties prop;
	public static Logger logger;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEvents events;
	
	public  DriverFactory() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(
					"C:\\Users\\eramr\\eclipse-workspace\\NaveenAutomation\\src\\main\\java\\configuration\\configurationProperties");
			try {
				prop.load(ip);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}
	@BeforeClass
	public void loggerSetUp() {
		logger= Logger.getLogger(DriverFactory.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();

		logger.setLevel(Level.INFO);
	}
	
	public void init_driver() {
		

		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":
			driver = WebDriverManager.chromedriver().create();
						break;
		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "edge":
			driver = WebDriverManager.edgedriver().create();
			break;

		default:
			System.out.println(("Please pass the right broswer"));
			break;
		}
		e_driver = new EventFiringWebDriver(driver);
		events = new WebDriverEvents();
		e_driver.register(events);

		driver = e_driver;

		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Long.valueOf(prop.getProperty("base_time")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.valueOf(prop.getProperty("base_time")), TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(Long.valueOf(prop.getProperty("base_time")), TimeUnit.SECONDS);

	}

	
	
	public void quitBrowser() {
		driver.quit();
	}
}
