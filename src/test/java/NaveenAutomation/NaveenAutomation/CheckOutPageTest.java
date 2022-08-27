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

public class CheckOutPageTest extends DriverFactory {

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
	}

	@Test(priority = 1)
	public void orderPlacedTest() throws InterruptedException {
		checkOutPage.billingBtnClick();
		checkOutPage.deliveryBtnClick();
		checkOutPage.deliveryText();
		checkOutPage.deliveryMethodBtnClick();
		checkOutPage.paymentMethodTermsCheck();
		checkOutPage.payBtnClick();
		orderPlaced = checkOutPage.confirmOrder();
		String msg = orderPlaced.orderPlacedMessage();
		System.out.println("order is placed:" + msg);
		Assert.assertEquals(msg, "Your order has been placed!");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();

	}
}
