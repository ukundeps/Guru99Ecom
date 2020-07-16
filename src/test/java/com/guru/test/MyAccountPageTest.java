package com.guru.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru.page.LoginPage;
import com.guru.page.MyAccountPage;


public class MyAccountPageTest extends MyAccountPage {
	LoginPage login;
	MyAccountPage myaccount;

	@BeforeClass
	public void initMethod() {
		openBrowserAnConfigure();
		launchURL();
		myaccount = new MyAccountPage();
		login = new LoginPage();
		 
	}
	
	//@Test(description="To verify user can place order successfully and note order Id")
	public  void placeOrder( ) throws InterruptedException {
		login.userLogin();
		//myaccount.deleteFromCart();
		myaccount.addToCartMobile("Mobile_Sony");
		myaccount.changeQuantity("1");
		myaccount.clickOn("Proceed");
		myaccount.clickOn("ShipToThisAddressRadio");
		myaccount.clickOn("ContinueBilling");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300);");
		wait.until(ExpectedConditions.elementToBeClickable(myaccount.continueShipping));
		myaccount.clickOn("ContinueShipping");
		wait.until(ExpectedConditions.elementToBeClickable(myaccount.moneyOrderRadio));
		myaccount.clickOn("MoneyOrderRadio");
		myaccount.clickOn("ContinuePayment");
		js.executeScript("window.scrollBy(0,100);");
		wait.until(ExpectedConditions.elementToBeClickable(myaccount.placeOrder));
		myaccount.clickOn("PlaceOrder");
		Thread.sleep(5000);
		Assert.assertEquals(myaccount.getText("OrderPlacedMessage"), "YOUR ORDER HAS BEEN RECEIVED.","Wrong order placed message");
		System.out.println("Order Id: "+myaccount.getText("OrderId"));
	}
	
	@Test(description="To verify user can change quantity of already placed order and reorder it")
	public  void   reorder() throws InterruptedException {
		login.userLogin();
		myaccount.clickOn("MyOrders");
		myaccount.searchOrder("100012596");
		myaccount.changeQuantity("10");
		myaccount.clickOn("Proceed");
		myaccount.clickOn("ShipToThisAddressRadio");
		myaccount.clickOn("ContinueBilling");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300);");
		wait.until(ExpectedConditions.elementToBeClickable(myaccount.continueShipping));
		myaccount.clickOn("ContinueShipping");
		wait.until(ExpectedConditions.elementToBeClickable(myaccount.moneyOrderRadio));
		myaccount.clickOn("MoneyOrderRadio");
		myaccount.clickOn("ContinuePayment");
		js.executeScript("window.scrollBy(0,100);");
		wait.until(ExpectedConditions.elementToBeClickable(myaccount.placeOrder));
		myaccount.clickOn("PlaceOrder");
		Thread.sleep(5000);
		Assert.assertEquals(myaccount.getText("OrderPlacedMessage"), "YOUR ORDER HAS BEEN RECEIVED.","Wrong order placed message");
		System.out.println("Order Id: "+myaccount.getText("OrderId"));
		
		
	}

}
