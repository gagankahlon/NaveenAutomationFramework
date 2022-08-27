package com.qa.naveenautomationopencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.naveenautomation.factory.DriverFactory;

public class CheckOutPage extends DriverFactory {

	public CheckOutPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "button-payment-address")
	private WebElement billingContinueBtn;

	@FindBy(css = "#button-shipping-address")
	private WebElement deliveryContinueBtn;

	@FindBy(xpath = "//textarea[@name='comment']")
	private WebElement deliveryMethodText;

	@FindBy(xpath = "//*[@id='button-shipping-method']")
	private WebElement deliveryMethodBtn;

	@FindBy(css = "#collapse-payment-method > div > div.buttons > div > input[type=checkbox]:nth-child(2)")
	private WebElement paymentMethodTerms;

	@FindBy(css = "#button-payment-method")
	private WebElement paymentMethodBtn;

	@FindBy(css = "#button-confirm")
	private WebElement confirmBtn;

	public void billingBtnClick() {
		billingContinueBtn.click();
	}

	public void deliveryBtnClick() {
		deliveryContinueBtn.click();
	}

	public void deliveryText() {
		deliveryMethodText.sendKeys("My first order");
	}

	public void deliveryMethodBtnClick() {
		deliveryMethodBtn.click();

	}

	public void paymentMethodTermsCheck() {
		paymentMethodTerms.click();
	}

	public void payBtnClick() {
		paymentMethodBtn.click();
	}

	public OrderPlacedPage confirmOrder() {
		confirmBtn.click();
		return new OrderPlacedPage();
	}

}
