package com.guru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.base.Base;

public class AdminLoginPage extends Base {
	public AdminLoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[id=\"username\"]")
	private WebElement username;
	
	@FindBy(css="input[name=\"login[password]\"]")
	private WebElement pass;
	
	@FindBy(css="input[title=\"Login\"]")
	private WebElement loginButton;
	
	@FindBy(css="a[title=\"close\"]")
	private WebElement closePopUp;
	
	public void clickOn(String element) {
		switch (element) {
		case "LoginButton": loginButton.click();	break;
		case "Close": closePopUp.click();break;
		default:break;
		}
	}
	
	public  void enterEmailPass() {
		username.sendKeys(prop.getProperty("userId"));
		pass.sendKeys(prop.getProperty("pass"));
		
	}
	
	public  void adminLogin() {
		enterEmailPass();
		loginButton.click();
		closePopUp.click();

	}
	
	
}
