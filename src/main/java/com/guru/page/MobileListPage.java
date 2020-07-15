package com.guru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.base.Base;

public class MobileListPage extends Base{
	
	@FindBy(xpath="//a[@href='http://live.demoguru99.com/index.php/mobile.html']")
	public WebElement Mobile;
	
	@FindBy(xpath="//span[contains(text(),'$100.00')]")
	public WebElement MobilePageValue;
	
	@FindBy(xpath="//h2[@class='product-name']//a[contains(text(),'Sony Xperia')]")
	public WebElement SonyXperiaMobile;
	
	@FindBy(xpath="//span[contains(text(),'$100')]")
	public WebElement ProductPageValue;
	
	//constructor
	public MobileListPage(){
		super();
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnMobile() {
		Mobile.click();
	}  
	public boolean MobileEnable() {
	 return Mobile.isEnabled();
	}
	public String getMobilePageValue() {
		return MobilePageValue.getText();
	}
	
	public void clickSonyXperiaMobile() {
		SonyXperiaMobile.click();
	}
	
	public String getProductPageValue() {
		return ProductPageValue.getText();
	}
	
}
