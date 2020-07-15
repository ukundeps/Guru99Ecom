package com.guru.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru.page.PurchaseProductPage;

public class PurchaseProductTests extends PurchaseProductPage {
	PurchaseProductPage pp;

	@BeforeClass
	public void setUp() {
		openBrowserAnConfigure();
		launchURL();
		pp = new PurchaseProductPage();
	}

	// @AfterClass
	// private void tearDown() {
	// closeBrowserWindow();
	// }

	@Test(priority = 1)
	public void verify_LogIn_User() {
		Assert.assertTrue(pp.isMyAccountClickable(), "My account Not clickable");
		pp.clickMyAccount();
		log.info("Click on MyAccount link");
		pp.enterEmailID();
		log.info("Enter Email Address");
		pp.enterPassword();
		log.info("Password entered");
		Assert.assertTrue(pp.isLogInClickable(), "LogIn but is not clickable");
		pp.clickOnLogIn();
		log.info("Click on LogIn button");
	}

	// @Test(priority = 2)
	// public void verify_Add_Product_To_Wishlist() {
	// pp.click_On_TV();
	// pp.click_On_Wishlist();
	// }

	@Test(priority = 2)
	public void verify_Place_Order_Generated() throws InterruptedException {
		// pp.closePOPUP();

		pp.scrollDown();

		Assert.assertTrue(pp.isClickableMyWishlist(), "My wishlish is not clickable");
		pp.clickMyWishList();
		log.info("Click on My wishlist");
		pp.click_On_TV();
		log.info("Click on TV");
		pp.click_On_Wishlist();
		log.info("Added to Wishlist");

		Thread.sleep(3000);
		pp.clickAddToCart();
		log.info("Click on Add to cart");
		pp.enter_Country();
		log.info("Country selected");
		pp.enter_Zip_Code();
		log.info("Zip code enter");
		pp.click_On_Estimate();
		log.info("Estimate done");
		pp.select_FlatRate();
		log.info("Flat rate selected");
		pp.click_UpdateTotal();
		log.info("Click on Update Total");
		pp.clickProceedToCheckOut();
		log.info("Click on Proceed to checkout");
		pp.click_Continue();
		log.info("Continue");
		pp.scrollDown();
		log.info("Scroll down page");
		Thread.sleep(3000);
		pp.click_ShippingMethod_Continue();
		log.info("Continue Shipping method");
		Thread.sleep(3000);
		pp.select_Check_MoneyOrder();
		log.info("Check money order selected");
		Thread.sleep(5000);
		pp.click_PAymentInfo_Continue();
		log.info("PAyment Info continue");
		
//		
		Thread.sleep(5000);
		pp.scrollDown();
		pp.click_Place_Order();
		log.info("order Placed ");
String actual=pp.getOrderMessage();
System.out.println(actual);
		
		Assert.assertEquals(actual, "THANK YOU FOR YOUR PURCHASE!", "Order msg not display");
		System.out.println("Order placed successfully");
		log.info("Order placed successfully");
	}

}
