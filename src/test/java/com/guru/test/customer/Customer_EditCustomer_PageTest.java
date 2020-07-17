package com.guru.test.customer;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru.page.AdminLoginPage;
import com.guru.page.customer.Customer_EditCustomer_Page;

public class Customer_EditCustomer_PageTest extends Customer_EditCustomer_Page {
	AdminLoginPage adminLogin;
	Customer_EditCustomer_Page customerEdit;

	@BeforeClass
	public void setUp() {
		openBrowserAnConfigure();
		launchAdminURL();
		adminLogin=new AdminLoginPage();
		customerEdit=new Customer_EditCustomer_Page(); 
		adminLogin.adminLogin();
		
	}
	
	@Test(description="To verify selected customer details in detailed page")
	public  void searchCustomerAndCompare_Detailes() throws InterruptedException {
		customerEdit.searchAnclickOnCustomer("ukundepriya@gmail.com");
		Assert.assertEquals(customerEdit.getText("CustomerName"), "Priya Sewakram Ukunde","Wrong Customer Details");
		
	}
	
	
	@AfterClass
	public void tearDown(){
		closeBrowserWindow();
	}

}
