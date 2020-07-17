package com.guru.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {

		System.out.println("Trying to accept alert");
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Alert accepted");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert is Dismissed");

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Trying to dismiss alert");

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Trying to refresh page");

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Page is  Refreshed");

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {

		System.out.println(" Trying to Execute Script : " + script);
	}

	@Override
	public void afterScript(String script, WebDriver driver) {

		System.out.println(" Script Executed : " + script);
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
System.out.println("Trying to swicth to window : "+windowName);
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Swicthed to window: "+windowName);

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		System.out.println("Trying to get Screenshot");
		

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		System.out.println("Screenshot Captured : "+screenshot);

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
	System.out.println("Trying to get text of element: "+element.toString());

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("Got Text : "+text);

	}


}
