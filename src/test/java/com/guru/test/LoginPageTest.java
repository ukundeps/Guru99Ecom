package com.guru.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru.page.LoginPage;

public class LoginPageTest extends LoginPage {

	LoginPage login;

	@BeforeClass
	public void initMethod() {
		openBrowserAnConfigure();
		launchURL();
		login = new LoginPage();
	}

	@Test(description = "To verify user is able to login successfuly")
	public void userlogin() {
		extentLog = extent.createTest("verify_UserLogin");
		login.clickOn("Account");
		login.clickOn("Login");
		login.enterEmailPass();
		login.clickOn("LoginButton");
		Assert.assertEquals(getTitle(), "My Account0", "Unsuccsessful User login");

	}

	@AfterClass
	public void tearDown() {
		closeBrowserWindow();
	}

}
