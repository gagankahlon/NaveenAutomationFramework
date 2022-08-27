package com.qa.naveenautomationopencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.naveenautomation.factory.DriverFactory;

public class OrderPlacedPage extends DriverFactory {

	public OrderPlacedPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div#content h1")
	private WebElement orderPlaced;

	@FindBy(xpath = "//*[@id='content']/p[2]/a[2]")
	private WebElement historyLink;

	public String orderPlacedMessage() throws InterruptedException {
		Thread.sleep(1000);
		return orderPlaced.getText();

	}

	public OrderHistoryPage historyLinkClick() {
		historyLink.click();
		return new OrderHistoryPage();
	}
}
