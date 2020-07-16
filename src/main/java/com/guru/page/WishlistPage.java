package com.guru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.base.Base;

public class WishlistPage extends Base{

	public WishlistPage() {
		super();
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[@class='skip-link skip-account']")
WebElement Account;

@FindBy(xpath="//a[@title=\"My Account\"][1]")
WebElement Myaccount;

@FindBy(xpath="//a[@title=\'Create an Account\']")
WebElement createaccount;

@FindBy(id="firstname")
WebElement firstname;

@FindBy(id="lastname")
WebElement lastname;

@FindBy(id="email_address")
WebElement Email;

@FindBy(id="password")
WebElement Password;

@FindBy(id="confirmation")
WebElement ConfirmPass;

@FindBy(xpath="//button[@title=\"Register\"]")
WebElement Registerbtn;

@FindBy(xpath="//li[@class=\"success-msg\"]/descendant::span")
WebElement message;

@FindBy(xpath="//a[text()='TV']")
WebElement Tv;

@FindBy(xpath="//a[@title=\"LG LCD\"]/following-sibling::div[@class=\"product-info\"]/descendant::a[@class=\"link-wishlist\"]")
WebElement Lcd;

@FindBy(xpath="//button[@title=\"Share Wishlist\"]")
WebElement Wishlist;

@FindBy(id="email_address")
WebElement emailid;

@FindBy(id="message")
WebElement emailmsg;

@FindBy(xpath="//button[@title=\"Share Wishlist\"]")
WebElement sharewishlist;

@FindBy(xpath="//li[@class=\"success-msg\"]/descendant::span")
WebElement wishlistmsg;

public void CreateAccountAsUser() {
	Account.click();
	Actions action=new Actions(driver);
	action.moveToElement(Myaccount).click().build().perform();
	createaccount.click();
	firstname.sendKeys("Swati");
	lastname.sendKeys("Sharma");
	Email.sendKeys("swatisharma@gmail.com");
	Password.sendKeys("Test@123");
	ConfirmPass.sendKeys("Test@123");
	Registerbtn.click();

}

public void sharewishlist() {
	Tv.click();
	Lcd.click();
	Wishlist.click();
	emailid.sendKeys("singhritu@gmail.com");
	emailmsg.sendKeys("Hey sharing my whislist with you. Have a look.");
	sharewishlist.click();
}

public String getRegisterMsg() {
	return message.getText();

}

public String getWishlistMsg() {
	return wishlistmsg.getText();
}
}
