package com.guru.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.base.Base;

public class PurchaseProductPage extends Base {

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public PurchaseProductPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[4]//ul[1]//li[1]//a[1]")
	public WebElement MyAccount;

	@FindBy(css = "input[name='login[username]']")
	public WebElement EmailAddress;

	@FindBy(css = "input[name='login[password]']")
	public WebElement Password;

	@FindBy(css = "button[title='Login']")
	public WebElement LogIn;

	@FindBy(css = "div[id='closeBtn']")
	public WebElement popUp;

	@FindBy(xpath = "//li[8]//a[1]")
	public WebElement MyWishList;

	//// button[@onclick='addWItemToCart(45710);']
	@FindBy(css = "button[onclick='addAllWItemsToCart()']")
	public WebElement AddToCart;

	@FindBy(css = "button[title='Proceed to Checkout'] span span")
	public WebElement ProceedToCheckout;

	@FindBy(xpath = "//a[contains(text(),'TV')] ")
	private WebElement TV;

	@FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")
	public WebElement AddToWishlist;

	@FindBy(css = "input#postcode")
	public WebElement Zip;

	@FindBy(css = "select#country")
	public WebElement Country;

	@FindBy(css = "button[onclick='coShippingMethodForm.submit()']")
	public WebElement Estimate;

	@FindBy(css = "input#s_method_flatrate_flatrate")
	public WebElement FlatRate;

	@FindBy(css = "button[value='Update Total']")
	public WebElement UpdateTotal;

	@FindBy(css = "button[onclick='billing.save()']")
	public WebElement Continue;

	@FindBy(css = "button[onclick='shippingMethod.save()']")
	public WebElement ShippingMethodContinue;

	@FindBy(css = "input#p_method_checkmo")
	public WebElement CheckMoneyOrder;

	@FindBy(css = "button[onclick='payment.save()']")
	public WebElement payInfoContinue;

	@FindBy(css="button[onclick='review.save();']")
	public WebElement PlaceOrder;
	
	@FindBy(css="h2[class='sub-title']")
	public WebElement OrderMessage;
	
	public void clickMyAccount() {
		MyAccount.click();
	}

	public boolean isMyAccountClickable() {
		return MyAccount.isEnabled();
	}

	public void enterEmailID() {
		String email = prop.getProperty("email_Id");
		EmailAddress.sendKeys(email);

	}

	public void enterPassword() {
		String pass = prop.getProperty("password");
		Password.sendKeys(pass);
	}

	public void clickOnLogIn() {
		LogIn.click();
	}

	public boolean isLogInClickable() {
		return LogIn.isEnabled();
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}

	public void closePOPUP() {
		driver.switchTo().frame(popUp).close();
	}

	public boolean isClickableMyWishlist() {
		return MyWishList.isEnabled();
	}

	public void clickMyWishList() {
		MyWishList.click();
	}

	public void clickAddToCart() {
		// js.executeScript("srguments[0].click();",AddToCart);
		AddToCart.click();
	}

	public void clickProceedToCheckOut() {
		ProceedToCheckout.click();
	}

	public void click_On_TV() {
		TV.click();
	}

	public void click_On_Wishlist() {
		AddToWishlist.click();
	}

	public void enter_Zip_Code() {
		Zip.sendKeys("445203");
	}

	public void enter_Country() {
		Country.sendKeys("India");
	}

	public void click_On_Estimate() {
		Estimate.click();
	}

	public void select_FlatRate() {
		FlatRate.click();
	}

	public void click_UpdateTotal() {
		UpdateTotal.click();
	}

	public void click_Continue() {
		Continue.click();
	}

	public void click_ShippingMethod_Continue() {
		ShippingMethodContinue.click();
	}

	public void select_Check_MoneyOrder() {
		CheckMoneyOrder.click();
	}

	public void click_PAymentInfo_Continue() {
		payInfoContinue.click();
	}
	public void click_Place_Order() {
		PlaceOrder.click();
	} 
	public String getOrderMessage() {
		return OrderMessage.getText();
	}
	
}
