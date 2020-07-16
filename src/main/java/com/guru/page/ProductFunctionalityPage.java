package com.guru.page;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.guru.base.Base;

public class ProductFunctionalityPage extends Base {
	public ProductFunctionalityPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	static String originalWindow;
	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	private static WebElement mobile;
	@FindBy(xpath = "//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]")
	private static WebElement addToCart;
	@FindBy(xpath = "//input[@class='input-text qty']")
	private static WebElement quantity;
	@FindBy(xpath = "//button[@class='button btn-update']//span//span")
	private static WebElement updateBtn;
	@FindBy(xpath = "//p[@class='item-msg error']")
	private static WebElement errMsg;
	@FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
	private static WebElement emptyCart;
	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart is Empty')]")
	private static WebElement verifyEmptyCart;

	@FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]")
	private static WebElement addToCompare;
	@FindBy(xpath = "//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")
	private static WebElement addTocompare;
	@FindBy(xpath = "//button[@class=\"button\"]//span[contains(text(),'Compare')]")
	private static WebElement compareBtn;
	@FindBy(xpath = "//h1[contains(text(),'Compare Products')]")
	private static WebElement popupwindow;
	@FindBy(css = "#top")
	private static String window;
	@FindBy(xpath = "//span[contains(text(),'Close Window')]")
	private static WebElement closeWindow;

	public static void clickOnMobile() {
		mobile.click();
	}

	public static void clickOnAddToCartBtn() {
		addToCart.click();
	}

	public static void enterQuantity() {
		quantity.sendKeys("1000");
	}

	public static void clickOnUpdateBtn() {
		updateBtn.click();
	}

	public static WebElement clickOnErrMsg() {
		errMsg.getText();
		return errMsg;
	}

	public static void clickOnEmptyCart() {
		emptyCart.click();
	}

	public static WebElement clickOnEmptyCartMsg() {
		verifyEmptyCart.getText();
		return verifyEmptyCart;
	}

	public static void clickOnAddToCompareBtn1() {
		addToCompare.click();
	}

	public static void clickOnAddToCompareBtn2() {
		addTocompare.click();
	}

	public static void clickOnCompareBtn() {
		compareBtn.click();
	}

	public static void newPopupWindowHandle(String openWindowHandle) {
		// Switching to the new popup window
		Set<String> handles = driver.getWindowHandles();
		originalWindow = driver.getWindowHandle();

		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {

			String newWindow = iterator.next();
			
			if (!originalWindow.equalsIgnoreCase(newWindow)) {

				driver.switchTo().window(newWindow);
			}
		}
	}

	public static String verifyPopUpWindow() {
		String text= popupwindow.getText();	
		return text;
	}

	public static void clickOnCloseWindowBtn() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		closeWindow.click();
		driver.switchTo().window(originalWindow);

	}

}