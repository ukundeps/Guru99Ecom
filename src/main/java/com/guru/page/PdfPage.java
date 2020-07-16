package com.guru.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.base.Base;

public class PdfPage extends Base {
	@FindBy(xpath="//a[@class=\'skip-link skip-account\']")
	WebElement Account;

	@FindBy(xpath="//a[@title=\"My Account\"][1]")
	WebElement Myaccount;

	@FindBy(xpath="//input[@title=\"Email Address\"]")
	WebElement email;
	
	@FindBy(xpath="//input[@title=\"Password\"]")
	WebElement password;
	
	@FindBy(xpath="//button[@title=\"Login\"]")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[text()=\"My Orders\"]")
	WebElement orders;
	
	@FindBy(xpath="//a[text()=\"View Order\"]")
	WebElement viewOrder;
	
	@FindBy(xpath="//a[text()='Print Order']")
	WebElement printOrder;
	
	@FindBy(xpath="//tr[@class=\"first odd\"]/td[@class=\"status\"]")
	WebElement status;
	
	public PdfPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void login() {
		Account.click();
		Actions action=new Actions(driver);
		action.moveToElement(Myaccount).click().build().perform();
		email.sendKeys("dikshashakate@gmail.com");
		password.sendKeys("test@123");
		loginbtn.click();
	}
	
	public void printPdf() {
		orders.click();
		viewOrder.click();
		printOrder.click();
	}
	
	public String getOrderStatus() {
		return status.getText();
	}
	
	public void saveAsPdf() throws IllegalArgumentException, IllegalAccessException {
		try {
			Thread.sleep(10000);
			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(10000);
			
			String fileName = "SaveOrder" + System.currentTimeMillis();
			for (int i = 0; i < fileName.length(); i++) {
				String letter = Character.toString(fileName.charAt(i));
				String code = "VK_" + letter.toUpperCase();
				Field f = KeyEvent.class.getField(code);
				int keyEvent = f.getInt(null);
				robo.keyPress(keyEvent);
				robo.keyRelease(keyEvent);
			}
			robo.keyPress(KeyEvent.VK_ENTER);
			
			
			
			
			
		} catch (InterruptedException | AWTException | NoSuchFieldException | SecurityException e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
		

	}
	
	
}
