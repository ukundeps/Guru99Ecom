package com.guru.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru.page.AdminLoginPage;

public class AdminLoginPageTest extends AdminLoginPage {
	AdminLoginPage adminLogin;

	@BeforeClass
	public void initMethod() {
		openBrowserAnConfigure();
		launchAdminURL();
		adminLogin = new AdminLoginPage();

	}

	@Test(description="To verify admin login is successfull")
	public void adminLogin() {
		adminLogin.enterEmailPass();
		adminLogin.clickOn("LoginButton");
		adminLogin.clickOn("Close");
		Assert.assertEquals(getTitle(), "Manage Customers / Customers / Magento Admin","Unsuccessful Admin Login");
	}
}
