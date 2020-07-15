package com.guru.page;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.base.Base;

public class ShoppingCartPage extends Base {

	public ShoppingCartPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	private static WebElement mobile;

	@CacheLookup
	@FindBy(xpath = "//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]")
	private static WebElement addToCart;

	@CacheLookup
	@FindBy(xpath = "//input[@class='input-text qty']")
	private static WebElement quantity;

	@CacheLookup
	@FindBy(xpath = "//button[@class='button btn-update']//span//span")
	private static WebElement updateBtn;

	@CacheLookup
	@FindBy(xpath = "//p[@class='item-msg error']")
	private static WebElement errMsg;

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
	private static WebElement emptyCart;

	@CacheLookup
	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart is Empty')]")
	private static WebElement verifyEmptyCart;

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

	@CacheLookup
	@FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]")
	private static WebElement addToCompare;

	public static void clickOnAddToCompareBtn1() {
		addToCompare.click();
	}

	@CacheLookup
	@FindBy(xpath = "//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")
	private static WebElement addTocompare;

	public static void clickOnAddToCompareBtn2() {
		addTocompare.click();
	}

	@CacheLookup
	@FindBy(xpath = "//button[@class=\"button\"]//span[contains(text(),'Compare')]")
	private static WebElement compareBtn;

	public static void clickOnCompareBtn() {
		compareBtn.click();
	}

	@CacheLookup
	@FindBy(css = "#top")
	private static String window;

	public static void newPopupWindowHandle(String openWindowHandle) {
		// Switching to the new window
		Set<String> handles = driver.getWindowHandles();
		String originalWindow = driver.getWindowHandle();

		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {

			String newWindow = iterator.next();

			if (!originalWindow.equalsIgnoreCase(newWindow)) {

				driver.switchTo().window(newWindow);

			}

		}

	}

	@CacheLookup
	@FindBy(xpath = "//h1[contains(text(),'Compare Products')]")
	private static WebElement popupwindow;

	public static String verifyPopUpWindow() {
		return popupwindow.getText();

	}

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'Close Window')]")
	private static WebElement closeWindow;

	public static void clickOnCloseWindowBtn() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		closeWindow.click();

	}

}