package com.guru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.guru.base.Base;

public class LoginPage extends Base{
	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='label'][contains(text(),'Account')]")
	private WebElement account;
	
	@FindBy(css = "a[title=\"Log In\"]")
	private WebElement login;
	
	@FindBy(css = "input[title=\"Email Address\"]")
	private WebElement email;
	
	@FindBy(css = "input[title=\"Password\"]")
	private WebElement pass;
	
	@FindBy(css = "button[title=\"Login\"]")
	private WebElement loginButton;
	

	public void clickOn(String element) {
		switch (element) {
		case "Account": account.click();break;
		case "Login": login.click();break;
		case "LoginButton": loginButton.click();	break;
		default:break;
		}
	}
	
	public  void enterEmailPass() {
		email.sendKeys(prop.getProperty("email_Id"));
		pass.sendKeys(prop.getProperty("password"));
		
	}
	
	public  void userLogin() {
		account.click();
		login.click();
		enterEmailPass();
		loginButton.click();

	}
	
	
	

}
