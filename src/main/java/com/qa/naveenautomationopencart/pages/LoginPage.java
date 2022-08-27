package com.qa.naveenautomationopencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.naveenautomation.factory.DriverFactory;

public class LoginPage extends DriverFactory {

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement inputEmailField;

	@FindBy(id = "input-password")
	private WebElement enterPasswordField;

	@FindBy(css = "input[type='submit']")
	private WebElement submitBtn;

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterEmail(String email) {
		inputEmailField.sendKeys(email);
	}

	public void enterPassword(String password) {
		enterPasswordField.sendKeys(password);
	}

	public MyAccountPage clickSubmitBtn() {
		submitBtn.submit();
		return new MyAccountPage();
	}

	public MyAccountPage login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		return clickSubmitBtn();
	}

}
