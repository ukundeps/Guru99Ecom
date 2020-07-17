package com.guru.page;

import java.sql.Savepoint;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.guru.base.Base;

public class UserInterfaceSortingPage extends Base {
	static int count = 1;
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	private WebElement mobileBtn;
	@FindBy(xpath = "//a[contains(text(),'TV')]")
	private WebElement tvBtn;
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/select[1]")
	private WebElement sortFilter;
	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button/span/span")
	private WebElement addtocartIphone;
	@FindBy(xpath = "//div[@class='cart-totals-wrapper']//tbody//tr[1]//td[2]//span[1]")
	private WebElement subtotalele;
	@FindBy(xpath = "//tr[2]//td[2]//span[1]")
	private WebElement discountele;
	@FindBy(xpath = "//strong//span[@class='price']")
	private WebElement grandtotaoele;

	public UserInterfaceSortingPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public void clickOn(String element) {
		switch (element) {
		case "Mobile": mobileBtn.click();break;
		case "TV":tvBtn.click();break;
		case "Sort Filter":	sortFilter.click();	break;
		case "Add to cart : IPHONE":addtocartIphone.click();break;
		default:break;
		}
	}

	public void sort_Element_By(String filter) {
		Select select = new Select(sortFilter);
		select.selectByVisibleText(filter);
	}

	public boolean verify_Elements_Are_Sorted_By(String filter) {
		List<WebElement> links = driver
				.findElement(By.xpath("//ul[@class=\"products-grid products-grid--max-4-col first last odd\"]"))
				.findElements(By.tagName("li"));
		Boolean flag = true;
		switch (filter) {
		case "Name":
			for (int i = 1; i < links.size() / 3; i++) {
				String xpaath = "//li[" + i + "]//div[1]//h2[1]//a[1]";
				String tempValue = driver.findElement(By.xpath(xpaath)).getText();
				int k = tempValue.compareTo(
						driver.findElement(By.xpath("//li[" + (i + 1) + "]//div[1]//h2[1]//a[1]")).getText());
				if (k > 0) {
					flag = false;
					return flag;
				}
			}
			return flag;
		case "Position":
			for (int i = 1; i < links.size() / 3; i++) {
				String xpaath = "#product-collection-image-" + count;
				String tempValue = driver.findElement(By.cssSelector(xpaath)).getText();
				int k = tempValue.compareTo(
						driver.findElement(By.cssSelector("#product-collection-image-" + (count + 1))).getText());
				if (k > 0) {
					flag = false;
					break;
				}
				count++;
			}
			count++;
			return flag;
		case "Price":
			List<WebElement> prices = driver.findElements(By.xpath("//span[ contains(@id,\"product-price\")]"));
			for (int i = 0; i < (links.size() / 3) - 1; i++) {
				int k = prices.get(i).getText().compareTo(prices.get(i + 1).getText());
				if (k > 0) {
					flag = false;
					break;
				}
			}
			return flag;
		default:
			return flag;
		}
	}

	@DataProvider(name = "Sorting_Filter")
	public Object[][] sorting_Options() {
		Object[][] data = { 
				{ "Mobile", "Name" },
			//	{ "Mobile", "Position" },
			//	{ "Mobile", "Price" },
			//	{ "TV", "Name" },
			//	{ "TV", "Position" }, 
			//	{ "TV", "Price" }

		};
		return data;
	}

	public void enterCouponCode(String coupon) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@name='coupon_code']")).sendKeys(coupon);
		driver.findElement(By.xpath("//form[@id='discount-coupon-form']//button[1]//span[1]//span[1]")).click();
	}

	public boolean verify_Coupon_Code_Applied() {
		float subtotal = Float.valueOf(subtotalele.getText().substring(1));
		float discount = Float.valueOf(discountele.getText().substring(2));
		float grandtotal = Float.valueOf(grandtotaoele.getText().substring(1));
		if (subtotal - discount == grandtotal)
			return true;
		else
			return false;
	}

}
