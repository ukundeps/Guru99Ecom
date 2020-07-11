package com.guru.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru.page.HomepagePage;

public class HomepagePageTest extends HomepagePage{
	
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
