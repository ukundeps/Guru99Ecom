package com.guru.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru.base.Base;
import com.guru.page.UserInterfaceSortingPage;

public class UserInterfaceSortingTest extends Base{
	UserInterfaceSortingPage pageObj;
	
	@BeforeClass
	public void initMethod() {
		openBrowserAnConfigure();
		launchURL();
		pageObj=new UserInterfaceSortingPage();
	}

	@Test(dataProvider = "Sorting_Filter", dataProviderClass = UserInterfaceSortingPage.class)
	public void to_Verify_Element_Sorted_By(String product,String filter) {
		pageObj.clickOn(product);
		pageObj.clickOn("Sort Filter");
		pageObj.sort_Element_By(filter);
		Assert.assertTrue(pageObj.verify_Elements_Are_Sorted_By(filter),"Elements not sorted properly");
	}
	
	@Test
	public void to_Verify_Discount_Coupon_Works_Correctly() {
		pageObj.clickOn("Mobile");
		pageObj.clickOn("Add to cart : IPHONE");
		pageObj.enterCouponCode("GURU50");
		Assert.assertTrue(pageObj.verify_Coupon_Code_Applied(),"Coupon code cannot Applied correctly");
	}
	
	
	@AfterClass
	public void tearDown() {
		closeBrowserWindow();
	}

}
