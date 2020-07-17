package com.guru.page.customer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.base.Base;

public class Customer_EditCustomer_Page extends Base{
	public Customer_EditCustomer_Page() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[id=\"customerGrid_filter_email\"]")
	private WebElement searchCustomerByemail;
	
	@FindBy(css="button[title=\"Search\"]")
	private WebElement searchCustomer;
	
	@FindBy(xpath="//td[contains(@class,'last')]//a")
	private WebElement emailResult;
	
	@FindBy(xpath="//div[@class=\"main-col-inner\"]/descendant::h3")
	private WebElement customerName;
	
	public void clickOn(String element) {
		switch (element) {
		case "SearchCustomer": searchCustomer.click();break;
		case "EmailResult": emailResult.click();break;
			default:break;
		}
		
	}
	
	public  String  getText(String text) {
		String outputText="";
		switch (text) {
		case "CustomerName": outputText=customerName.getText();break;
		
		default:break;
		}
		return outputText;
	}
	
	
	public  void searchAnclickOnCustomer(String email) throws InterruptedException {
	searchCustomerByemail.sendKeys(email);
	searchCustomer.click();
	//wait.until(ExpectedConditions.elementToBeClickable(emailResult));
	Thread.sleep(5000);
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", emailResult)	;
	}
	
	

}
