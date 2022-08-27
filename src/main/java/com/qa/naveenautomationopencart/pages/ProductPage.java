package com.qa.naveenautomationopencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.naveenautomation.factory.DriverFactory;

public class ProductPage extends DriverFactory {

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content > div:nth-child(3) > div:nth-child(1) > div > div:nth-child(2) > div.caption > h4 > a")
	private WebElement selectProduct;

	public ProductInfoPage selectProductPage() throws InterruptedException {

		selectProduct.click();
		return new ProductInfoPage();

	}

}
