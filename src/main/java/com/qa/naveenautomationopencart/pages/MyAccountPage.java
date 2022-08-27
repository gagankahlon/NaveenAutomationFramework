package com.qa.naveenautomationopencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.naveenautomation.factory.DriverFactory;

public class MyAccountPage extends DriverFactory {
	public MyAccountPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h2")
	private WebElement header;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(6) > a")
	private WebElement phone;

	public String accountPageHeader() {
		return header.getText();

	}

	public ProductPage selectPhone() {
		phone.click();
		return new ProductPage();

	}
}
