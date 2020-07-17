package com.guru.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.guru.base.Base;

public class Listener extends Base implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Execution Started : " + result.getName());
		extentLog = extent.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Execution Successed : " + result.getName());
		extentLog.log(Status.PASS, "Passed TestCase: " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Execution Failed : " + result.getName());

		extentLog.log(Status.FAIL, "Failed TestCase: " + result.getName());
		String failedTCScreenshotPath = screenshotforExtentReport(driver, result.getName());
		try {
			extentLog.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(failedTCScreenshotPath).build());
		} catch (IOException e) {
			System.out.println("File not not found");
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Execution Skipped : " + result.getName());
		extentLog.log(Status.PASS, "Skipped  TestCase: " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	//@BeforeTest
	@Override
	public void onStart(ITestContext context) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/" + "ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project", "Guru99Ecom");
		tempextentLog=extent.createTest("Bhushan Test");
		tempextentLog.log(Status.PASS, "Bhushan");
	}

	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("remove testlog");
		extent.removeTest(tempextentLog);
		extent.flush();
	}

}
