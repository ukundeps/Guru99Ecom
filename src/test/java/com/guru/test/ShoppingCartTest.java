package com.guru.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.guru.page.ShoppingCartPage;

public class ShoppingCartTest extends ShoppingCartPage {

	ShoppingCartPage cart;

	@BeforeMethod
	public void setUp() {
		openBrowserAnConfigure();
		launchURL();
		cart = new ShoppingCartPage();

	}

	@Test(description = "Verify that you cannot add more product in cart than the product available in store")
	public void verify_cart_functionality() {
		extentLog = extent.createTest("Verify_cart_functionality");
		expllicitWait();
		clickOnMobile();
		expllicitWait();
		clickOnAddToCartBtn();
		enterQuantity();
		clickOnUpdateBtn();
		Assert.assertEquals(clickOnErrMsg().getText(), "* The maximum quantity allowed for purchase is 500.");
		clickOnEmptyCart();
		Assert.assertEquals(clickOnEmptyCartMsg().getText(), "SHOPPING CART IS EMPTY");
		log.info("successfully verified that you cannot add more product in cart than the product available in store");

	}

	@Test(description = "Verify that you are able to compare two product")
	public void verify_two_product_comparison() {
		extentLog = extent.createTest("verify_two_product_comparison");
		expllicitWait();
		clickOnMobile();
		expllicitWait();
		clickOnAddToCompareBtn1();
		expllicitWait();
		clickOnAddToCompareBtn2();
		expllicitWait();
		clickOnCompareBtn();
		expllicitWait();
		newPopupWindowHandle(getTitle());
		expllicitWait();
		Assert.assertEquals(verifyPopUpWindow(), "COMPARE PRODUCTS");
		clickOnCloseWindowBtn();
		log.info("Successfully verified that you are able to compare two product");

	}

	@AfterMethod
	public void tearDown() {

		closeBrowserWindow();
	}
}
