package com.generic.code;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.confiq.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class BaseLoginTest {
	
	protected static WebDriver driver;

	public static void getLogin() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(BaseConfig.getconfig("URL"));
		TakeAppScreenShot.captureScreenShot(driver, "URL Page Successful");
		System.out.println("Home Page Title : " + driver.getTitle());

		LoginPage login = new LoginPage(driver);

		login.getMyCookies().click();
		System.out.println("Page Title after Accept Cookies : " + driver.getTitle());
		System.out.println("Current Url :" + driver.getCurrentUrl());

		Highlighter.GetColor(driver, login.getSignInButton());
		login.getSignInButton().click();
		TakeAppScreenShot.captureScreenShot(driver, "SignIn Page Successful");
		System.out.println("Current Url After SignIn :" + driver.getCurrentUrl());
		System.out.println("Login Page Title :" + driver.getTitle());

		new Wait().getExplicitWait(driver, login.getEmail());
		Highlighter.GetColor(driver, login.getEmail(), "red");
		login.getEmail().sendKeys(BaseConfig.getconfig("Email"));
		TakeAppScreenShot.captureScreenShot(driver, "Email Successful");

		new Wait().getExplicitWait(driver, login.getPassword());
		Highlighter.GetColor(driver, login.getPassword(), "orange");
		login.getPassword().sendKeys(BaseConfig.getconfig("Password"));
		TakeAppScreenShot.captureScreenShot(driver, "Password Successful");

		new Wait().getExplicitWait(driver, login.getSignIn());
		Highlighter.GetColor(driver, login.getSignIn(), "yellow");
		login.getSignIn().click();
		TakeAppScreenShot.captureScreenShot(driver, "Login Successful");
		System.out.println("Current Url After Login :" + driver.getCurrentUrl());
		System.out.println("Page Title after LogIn :" + driver.getTitle());

		//driver.quit();

	}

}
