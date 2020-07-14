package com.guru.test;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.AccountException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru.page.HomepagePage;
import com.guru.page.WishlistPage;

public class WishlistPageTest extends WishlistPage{
	WishlistPage wish;
	@BeforeClass
	public void setUp() {
		openBrowserAnConfigure();
		launchURL();
		wish = new WishlistPage();

	}

	@Test
	public void verifyToCreateAccount() {
	wish.CreateAccount();
	log.info("Account created");
	Assert.assertEquals(wish.getRegisterMsg(), "Thank you for registering with Main Website Store.");
	wish.sharewishlist();
	Assert.assertEquals(wish.getWishlistMsg(), "Your Wishlist has been shared.");
	log.info("Wishlist shared");
	}
	
	@AfterClass
	public void tearDown() {

		closeBrowserWindow();
	}
	
}
