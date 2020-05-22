package com.generic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.interactions.Actions;

import com.confiq.BaseConfig;
import com.page.object.model.SelectionPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;

public class LocationSelectionPage extends BaseLoginTest {

	public static void getproperty() throws Throwable {
		getLogin();

		// Verify web page title
		System.out.println("Page Title After Login : " + driver.getTitle());

		// Selection of Property Location
		SelectionPage sp = new SelectionPage(driver);
		Highlighter.GetColor(driver, sp.getLocation(), "green");
		sp.getLocation().sendKeys(BaseConfig.getconfig("Location"));

		Highlighter.GetColor(driver, sp.getSearch(), "blue");
		TakeAppScreenShot.captureScreenShot(driver, "Property Location");
		sp.getSearch().click();

		// Total number of properties
		int totalno = sp.getPropertyprices().size();
		System.out.println("total properties " + totalno);

		// Print all Property Prices and Sorted by Ascending,Descending order
		String[] prices;
		List<Integer> homeprice = new ArrayList<>();

		for (int i = 0; i < sp.getPropertyprices().size(); i++) {
			prices = sp.getPropertyprices().get(i).getText().split(" ");
			homeprice.add(Integer.parseInt(prices[0].replace("£", "").replace(",", "").trim()));
		}

		System.out.println("Property Prices List " + homeprice);
		Collections.sort(homeprice);
		System.out.println("Property Prices By ASC: " + homeprice);
		Collections.reverse(homeprice);
		System.out.println("Property Prices By Desc: " + homeprice);

		// Select 5th Property
		sp.getPropertyprices().get(4).click();

		// Verify Agent Logo and Contact information
		if (sp.getAgentlogo().isDisplayed()) {
			System.out.println("Agent Logo is Available");
		} else {
			System.out.println("Agent Logo is not Availabe");
		}
		System.out.println("Property Agent Name : " + sp.getAgentname().getText());
		System.out.println("Property Agent Ph Number : " + sp.getAgentphno().getText());
		TakeAppScreenShot.captureScreenShot(driver, "Property Agent Info ");

		//Verified Sign out page
		Actions signout = new Actions(driver);
		Highlighter.GetColor(driver, sp.getZooplabtn(), "green");
		signout.moveToElement(sp.getZooplabtn()).build().perform();

		Highlighter.GetColor(driver, sp.getSignoutbtn(), "blue");
		signout.moveToElement(sp.getSignoutbtn()).build().perform();

		sp.getSignoutbtn().click();
		System.out.println("Current Url after Signout :" + driver.getCurrentUrl());
		System.out.println("Page Title After Signout :" + driver.getTitle());

		TakeAppScreenShot.captureScreenShot(driver, "Sign Out Sccessful");
		
		//Close Browser
		driver.quit();
	}

}
