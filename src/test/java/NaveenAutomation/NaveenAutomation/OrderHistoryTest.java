package NaveenAutomation.NaveenAutomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.naveenautomation.factory.DriverFactory;
import com.qa.naveenautomationopencart.pages.CheckOutPage;

import com.qa.naveenautomationopencart.pages.LoginPage;
import com.qa.naveenautomationopencart.pages.MyAccountPage;
import com.qa.naveenautomationopencart.pages.OrderPlacedPage;
import com.qa.naveenautomationopencart.pages.ProductInfoPage;
import com.qa.naveenautomationopencart.pages.ProductPage;
import com.qa.naveenautomationopencart.pages.ShoppingCartPage;

public class OrderHistoryTest extends DriverFactory {

	
	LoginPage loginPage;
	MyAccountPage accountPage;
	ProductPage productPage;
	ProductInfoPage productInfo;
	ShoppingCartPage shoppingCartPage;
	CheckOutPage checkOutPage;
	OrderPlacedPage orderPlaced;

	@BeforeMethod
	public void startBrowserSession() throws Throwable {
		init_driver();
		
		loginPage = new LoginPage();
		accountPage = new MyAccountPage();
		productPage = new ProductPage();
		accountPage = loginPage.login("gagan@gmail.com", "test123");
		productPage = accountPage.selectPhone();
		productInfo = productPage.selectProductPage();
		shoppingCartPage = new ShoppingCartPage();
		productInfo.addToCartBtn();
		shoppingCartPage = productInfo.shoppingCart();
		checkOutPage = new CheckOutPage();
		checkOutPage = shoppingCartPage.checkOutBtnClick();
		orderPlaced = new OrderPlacedPage();
		orderPlaced = checkOutPage.confirmOrder();
		//historyLink.click();
	}

	
	@Test(priority = 1)
	public void orderPlacedTest() throws InterruptedException {
		
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();

	}
}
	

