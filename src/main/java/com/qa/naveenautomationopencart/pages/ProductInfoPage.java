package com.qa.naveenautomationopencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.naveenautomation.factory.DriverFactory;

public class ProductInfoPage extends DriverFactory {

	public ProductInfoPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	private WebElement productName;

	@FindBy(css = "#input-quantity")
	private WebElement selectQuantity;

	@FindBy(xpath = "//*[@id='button-cart']")
	private WebElement addToCart;

	@FindBy(xpath = "//*[@id='product-product']/div[1]/a[2]")
	private WebElement shoppingCartBtn;

	public String selectedProductName() {
		return productName.getText();

	}

	public void addToCartBtn() {

		addToCart.click();
	}

	public ShoppingCartPage shoppingCart() throws InterruptedException {

		shoppingCartBtn.click();
		return new ShoppingCartPage();
	}

}
