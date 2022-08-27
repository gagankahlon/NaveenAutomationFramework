package NaveenAutomation.NaveenAutomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.naveenautomation.factory.DriverFactory;
import com.qa.naveenautomationopencart.pages.CheckOutPage;

import com.qa.naveenautomationopencart.pages.LoginPage;
import com.qa.naveenautomationopencart.pages.MyAccountPage;
import com.qa.naveenautomationopencart.pages.ProductInfoPage;
import com.qa.naveenautomationopencart.pages.ProductPage;
import com.qa.naveenautomationopencart.pages.ShoppingCartPage;

public class ProductInfoPageTest extends DriverFactory {


	
	LoginPage loginPage;
	MyAccountPage accountPage;
	ProductPage productPage;
	ProductInfoPage productInfo;
	ShoppingCartPage shoppingCartPage;
	CheckOutPage checkOutPage;

		@BeforeMethod
		public void startBorwserSession() throws Throwable {
			init_driver();
			
			loginPage =new LoginPage();
			accountPage=new MyAccountPage();
			productPage=new ProductPage();
			accountPage=	loginPage.login("gagan@gmail.com", "test123");
			productPage=accountPage.selectPhone();
			productInfo=productPage.selectProductPage();
			shoppingCartPage = new ShoppingCartPage();
			checkOutPage=new CheckOutPage();
			}

		@Test(priority =1)
		public void  selectedProductNameTest() {
			String name=productInfo.selectedProductName();
			System.out.println("Product name:"+name);
			Assert.assertEquals(name, "HTC Touch HD");
		}
		
		@Test(priority=2)
		public void shoppingCartPageTest() throws InterruptedException {
			
			productInfo.addToCartBtn();
			
			shoppingCartPage=productInfo.shoppingCart();
			
						
		}
		

		@AfterMethod
		public void quitBrowserSession() {
			quitBrowser();
			
		}
		
		
	
}
