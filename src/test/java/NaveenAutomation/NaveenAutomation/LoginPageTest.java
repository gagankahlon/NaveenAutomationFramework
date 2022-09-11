package NaveenAutomation.NaveenAutomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.naveenautomation.factory.DriverFactory;

import com.qa.naveenautomationopencart.pages.LoginPage;
import com.qa.naveenautomationopencart.pages.MyAccountPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends DriverFactory {

	LoginPage loginPage;
	MyAccountPage accountPage;

	@BeforeMethod
	public void startBorwserSession() {
		init_driver();

		loginPage = new LoginPage();
	}

	@Test
	public void testing() {
		// testing imported git project
	}

	@Description("login Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void pagetitleTest() {
		String pageTitle = loginPage.getLoginPageTitle();
		System.out.println("title of the page:" + pageTitle);
		Assert.assertEquals(pageTitle, "Account Login");
	}

	@Test(priority = 2)
	public void loginAccountTest() {
		accountPage = loginPage.login("gagan@gmail.com", "test123");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();

	}

}
