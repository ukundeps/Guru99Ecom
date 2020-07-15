package com.guru.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.guru.page.HomepagePage;

public class HomepagePageTest extends HomepagePage {
	HomepagePage home;

	@BeforeClass
	public void setUp() {
		openBrowserAnConfigure();
		launchURL();
		home = new HomepagePage();

	}

	@AfterClass
	public void tearDown() {

		closeBrowserWindow();
	}

	@Test
	public void verify_Homepage_Title() {
		extentLog = extent.createTest("Verify_Homepage_Title");

		if (getTitle().equals("Home page")) {
			Assert.assertTrue(true);
			log.info("TC: verify_Homepage_Title : PASSED");
		} else {
			Assert.assertTrue(false);
			log.info("TC: verify_Homepage_Title: FAILED");
		}
	}
}
