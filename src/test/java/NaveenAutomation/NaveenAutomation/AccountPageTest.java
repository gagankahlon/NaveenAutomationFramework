package NaveenAutomation.NaveenAutomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.naveenautomation.factory.DriverFactory;

import com.qa.naveenautomationopencart.pages.LoginPage;
import com.qa.naveenautomationopencart.pages.MyAccountPage;
import com.qa.naveenautomationopencart.pages.ProductInfoPage;
import com.qa.naveenautomationopencart.pages.ProductPage;

public class AccountPageTest extends DriverFactory {

	
	LoginPage loginPage;
	MyAccountPage accountPage;
	ProductPage productPage;
	ProductInfoPage productInfo;

	@BeforeMethod
	public void startBorwserSession() {
		init_driver();
		 
		loginPage = new LoginPage();
		accountPage = new MyAccountPage();
		productPage = new ProductPage();
		accountPage = loginPage.login("gagan@gmail.com", "test123");
	}

	@Test(priority = 1)
	public void accountPageHeaderTest() {
		String pageHeader = accountPage.accountPageHeader();
		System.out.println("header of the page:" + pageHeader);
		Assert.assertEquals(pageHeader, "My Account");

	}

	

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();

	}

}
