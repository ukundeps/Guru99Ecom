package com.guru.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.guru.base.Base;
import com.guru.page.ProductFunctionalityPage;

@Listeners(com.guru.listener.Listener.class)
public class ProductFunctionalityTest extends Base {
	Logger log = Logger.getLogger(ProductFunctionalityTest.class);
	ProductFunctionalityPage obj;

	@BeforeClass
	public void setUp() {
		openBrowserAnConfigure();
		launchURL();
		obj = new ProductFunctionalityPage();

	}
    @Test(description = "Verify that you cannot add more product in cart than the product available in store")
	public void verify_cart_functionality() {
		expllicitWait();
		obj.clickOnMobile();
		log.info("clicked on Mobile menu");
		obj.clickOnAddToCartBtn();
		log.info("clicked on Add to cart button for Sony Xperia mobile");
		obj.enterQuantity();
		log.info("changed quantity value to 1000");
		obj.clickOnUpdateBtn();
		log.info("clicked on Update button");
		Assert.assertEquals(obj.clickOnErrMsg().getText(), "The requested quantity for Sony Xperia is not available");
		log.info(
				"Verified error message as '* The maximum quantity allowed for purchase is 500.' but expected 'The requested quantity for Sony Xperia is not available'");
//		obj.clickOnEmptyCart();
//		Assert.assertEquals(obj.clickOnEmptyCartMsg().getText(), "SHOPPING CART IS EMPTY");

	}

	@Test(description = "Verify that you are able to compare two product")
	public void verify_two_product_comparison() {
		expllicitWait();
		obj.clickOnMobile();
		log.info("Clicked on Mobile menu");
		obj.clickOnAddToCompareBtn1();
		log.info("In the mobile products list, clicked on 'Add To Compare' for Sony Xperia");
		obj.clickOnAddToCompareBtn2();
		log.info("In the mobile products list, clicked on 'Add To Compare' Iphone");
		obj.clickOnCompareBtn();
		log.info("Clicked on compare button");
		obj.newPopupWindowHandle(getTitle());
		log.info("Popup window handled");
		Assert.assertEquals(obj.verifyPopUpWindow(), "COMPARE PRODUCTS");
		obj.clickOnCloseWindowBtn();
		log.info("Closed Popup window");

	}

	@AfterClass
	public void tearDown() {

		closeBrowserWindow();
	}

}
