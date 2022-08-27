package com.qa.naveenautomationopencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.naveenautomation.factory.DriverFactory;

public class ShoppingCartPage extends DriverFactory {

	public ShoppingCartPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='content']/div[3]/div[2]/a")
	private WebElement checkOutBtn;

	public CheckOutPage checkOutBtnClick() {

		checkOutBtn.click();
		return new CheckOutPage();
	}

}
