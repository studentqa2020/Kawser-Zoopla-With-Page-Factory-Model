package com.page.object.model;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectionPage {

	public SelectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//*[@id='search-input-location']")
	private WebElement location;
	public WebElement getLocation() {
		return location;
	}

	@FindBy(xpath = "//*[@id='search-submit']")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}

	@FindBy(xpath = "//*[@class='listing-results-price text-price']")
	private List<WebElement> propertyprices;

	public List<WebElement> getPropertyprices() {
		return propertyprices;
	}
	@FindBy(xpath = "//*[@class='js-lazy-loaded']")
	private WebElement agentlogo;

	public WebElement getAgentlogo() {
		return agentlogo;
	}

	@FindBy(xpath = "(//*[@class='ui-agent__name'])[1]")
	private WebElement agentname;

	public WebElement getAgentname() {
		return agentname;
	}

	@FindBy(xpath = "(//*[@class='ui-link'])[4]")
	private WebElement agentphno;

	public WebElement getAgentphno() {
		return agentphno;
	}

	@FindBy(xpath = "//*[@id='header-account-panel__signed-in-link']")
	private WebElement zooplabtn;

	public WebElement getZooplabtn() {
		return zooplabtn;
	}

	@FindBy(xpath = "(//*[@class='ui-header-account-panel-description'])[5]")
	private WebElement signoutbtn;

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}

}
