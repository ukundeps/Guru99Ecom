package com.guru.page;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.guru.base.Base;

public class MyAccountPage extends Base {
	public MyAccountPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Mobile']")
	private WebElement mobile;
	
	@FindBy(css="a[title=\"Sony Xperia\"]")
	private WebElement sonyXperia;
	
	
	@FindBy(xpath="//h2[@class=\"product-name\"]/descendant::a[@title=\"IPhone\"]")
	private WebElement iphone;
	
	@FindBy(xpath="//h2[@class=\"product-name\"]/descendant::a[@title=\"Samsung Galaxy\"]")
	private WebElement samsung ;
	
	
	@FindBy(xpath = "//a[(text()='TV']")
	private WebElement tv;
	
	@FindBy(xpath="//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]")
	private WebElement addToCartSony;
	
	@FindBy(xpath="//li[2]//div[1]//div[3]//button[1]")
	private WebElement addToCartiphone;
	
	@FindBy(xpath="//li[3]//div[1]//div[3]//button[1]//span[1]//span[1]")
	private WebElement addToCartSamsung;
	
	@FindBy(css="a[data-target-element=\"#header-cart\"]")
	private WebElement cart;
	
	@FindBy(css="input[title=\"Qty\"]")
	private WebElement qty;
	
	@FindBy(xpath="//td[@class='product-cart-actions']//button[@name='update_cart_action']")
	private WebElement update;
	
	@FindBy(css="a[title=\"Remove This Item\"]")
	private WebElement deleteFromCart;
	
	@FindBy(css="button[title=\"Proceed to Checkout\"]")
	private WebElement proceedToCheckout;
	
	@FindBy(css="input[title=\"Ship to this address\"]")
	private WebElement shipToThisAddressRadio;
	
	@FindBy(css="button[onclick=\"billing.save()\"]")
	private WebElement continueBilling;
	
	@FindBy(css="button[onclick=\"shippingMethod.save()\"]")
	public WebElement continueShipping;
	
	@FindBy(css="input[id=\"p_method_checkmo\"]")
	public  WebElement moneyOrderRadio;
	
	@FindBy(css="button[onclick=\"payment.save()\"]")
	public  WebElement continuePayment;
	
	@FindBy(css="button[title=\"Place Order\"]")
	public  WebElement placeOrder;
	
	@FindBy(xpath="//div[@class=\"col-main\"]/descendant::h1")
	public  WebElement orderPlacedMsg;
	
	@FindBy(xpath="//div[@class=\"col-main\"]/descendant::p[1]")
	private WebElement orderId;
	
	@FindBy(xpath="//a[text()='My Orders']")
	private WebElement myOrders;
	

	@FindAll(@FindBy(xpath="//table[@id=\"my-orders-table\"]/descendant::tr/td[1]"))
	private List<WebElement> tablelOrderId;
	
	@FindBy(css="a[title=\"Next\"]")
	private WebElement next;
	
	@FindBy(xpath="//a[text()='Reorder']")
	private WebElement reorder;
	
	public void clickOn(String element) {
		switch (element) {
		case "Mobile": mobile.click();break;
		case "TV": tv.click();break;
		case "SonyXperia": sonyXperia.click();	break;
		case "Iphone": iphone.click();	break;
		case "Samsung": samsung.click();	break;
		case "AddToCart_Sony": addToCartSony.click();	break;
		case "AddToCart_Iphone": addToCartiphone.click();	break;
		case "AddToCart_Samsung": addToCartSamsung.click();	break;
		case "DeleteFromCart" : deleteFromCart.click(); break;
		case "Proceed":  proceedToCheckout.click();break;
		case "ShipToThisAddressRadio":  shipToThisAddressRadio.click();break;
		case "ContinueBilling":  continueBilling.click();break;
		case "ContinueShipping":  continueShipping.click();break;
		case "MoneyOrderRadio":  moneyOrderRadio.click();break;
		case "ContinuePayment" : continuePayment.click();break;
		case "PlaceOrder":  placeOrder.click();break;
		case "MyOrders":  myOrders.click();break;
		default:break;
		}
		
	}
	public void addToCartMobile(String product){
		switch(product) {
		case "Mobile_Sony": mobile.click();addToCartSony.click();break;
		case "Mobile_Iphone": mobile.click();addToCartiphone.click();break;
		case "Mobile_Samsung": mobile.click();addToCartSamsung.click();break;
		default:break;
		}
	
	}
	
	public  void changeQuantity(String quantity) {
		qty.clear();
		qty.sendKeys(quantity);
		update.click();
	}
	
	public  void deleteFromCart() {
	
	cart.click();
	deleteFromCart.click();
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alert=driver.switchTo().alert();
	alert.accept();
	

	}
	
	public  String  getText(String text) {
		String outputText="";
		switch (text) {
		case "OrderPlacedMessage": outputText=orderPlacedMsg.getText();break;
		case "OrderId": outputText=orderId.getText();break;
		default:break;
		}
		return outputText;
	}
	
	public  void searchOrder(String OrderId) throws InterruptedException {
		for (int i = 0; i < tablelOrderId.size(); i++) {
			if(tablelOrderId.get(i).getText().equals(OrderId)) {
				reorder.click();
				break;
			}else {
				next.click();
				Thread.sleep(5000);
				tablelOrderId=driver.findElements(By.xpath("//table[@id=\"my-orders-table\"]/descendant::tr/td[1]"));
				i=0;
			}
		}
		

	}
	
}
