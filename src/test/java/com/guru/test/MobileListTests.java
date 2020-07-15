package com.guru.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.page.MobileListPage;

public class MobileListTests extends MobileListPage {

	MobileListPage mp;

	@BeforeClass
	public void setUp() {
		openBrowserAnConfigure();
		launchURL();
		mp = new MobileListPage();
		
	}

	@AfterClass
	public void tearDown() {
		closeBrowserWindow();
	}

	@Test(priority = 1)
	public void verifyMobilePageValue() {
		Assert.assertTrue(mp.MobileEnable(),"Mobile button not enable");
		
		mp.clickOnMobile();
		String MobilePgValue = mp.getMobilePageValue();
		System.out.println(MobilePgValue);
		log.info("Mobile page value get");
		
		mp.clickSonyXperiaMobile();
		String ProductPgValue=mp.getProductPageValue();
		System.out.println(ProductPgValue);
		log.info("Product page value get");
		
		Assert.assertEquals(MobilePgValue, ProductPgValue);
		log.info("Both are same values ");
	}

}
