package com.guru.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static WebElement element;
	public static List<WebElement> elements;
	public static Set<String> allWindows;
	public static WebDriverWait wait;
	public static Actions action;
	public static Select select;
	public static Properties prop;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentLog, tempextentLog;

	public static Logger log;
	
	public Base() {
		log = Logger.getLogger("GURU99 ECOM");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\main\\resources\\Log4j.properties");
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectRepository.properties");
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			System.out.println("Object repository not found!!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}

	/**
	 * 
	 * This method will open browser window
	 * 
	 * @param browserName
	 */
	public static void openBrowserAnConfigure() {
		String browserName = prop.getProperty("BrowserName");
		long implicitWait = Integer.parseInt(prop.getProperty("ImplicitWaitDuration"));
		long pageLoadTimeout = Integer.parseInt(prop.getProperty("PageLoadTimeOutDuration"));

		switch (browserName) {
		case "chrome":
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability("download.prompt_for_download", "false");
			cap.setCapability("directory_upgrade", "true");
			cap.setCapability("plugins.plugins_disabled", "Chrome PDF Viewer");
			ChromeOptions options=new ChromeOptions();
			
			options.addArguments("--print-to-pdf");
			options.addArguments("--kiosk-printing");
			options.setCapability("cap", cap);
			WebDriverManager.chromedriver().version("2.40").setup();
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:

			log.error("Entered  Browser Name not matched!!");
			break;

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		log.info(browserName + " is opened and Configured!! ");

	}

	/**
	 * This method is used to provided nexplicit wait
	 */
	public static void expllicitWait() {
		long explicitWait = Integer.parseInt(prop.getProperty("ExplicitWaitDuration"));
		wait = new WebDriverWait(driver, explicitWait);
		wait.withTimeout(explicitWait, TimeUnit.SECONDS);
		log.info(explicitWait + "SECONDS" + " Explicit wait is applied!!");
	}

	/**
	 * This method will launch specified url on browser window
	 * 
	 * @param url
	 */
	public static void launchURL() {
		String baseURL = prop.getProperty("BaseURL");
		driver.get(baseURL);
		log.info(baseURL + " is launched!!");
	}
	
	public static void launchAdminURL() {
		String baseURL = prop.getProperty("AdminURL");
		driver.get(baseURL);
		log.info(baseURL + " is launched!!");
	}

	/**
	 * This method will closer Currently pointing Browser window by driver instance
	 **/



	public void closeBrowserWindow() {
		driver.close();
		log.info("Current browser window is Closed!!");
	}

	/**
	 * This method will closer all Browser windows opened by driver instance
	 */
	public static void closeAllBrowserWindows() {
		driver.quit();
		log.info("All browser windows are closed!!");
	}

	/**
	 * This method will navigate the webpage to back
	 */
	public static void navigateBack() {
		driver.navigate().back();
		log.info("Navigated Back!!");
	}

	/**
	 * This method will navigate the webpage to forward
	 */
	public static void navigateForward() {
		driver.navigate().forward();
		log.info("Navigated Forward!!");
	}

	/**
	 * This method will navigate the webpage to specific webpage
	 */
	public static void navigateTo(String url) {
		driver.navigate().to(url);
		;
		log.info("Navigated to Webpage :  " + url);
	}

	/**
	 * This method will navigate the webpage to back
	 */
	public static void refresh() {
		driver.navigate().refresh();
		log.info("Page Refreshed!!");
	}

	/**
	 * This method will return Title of currently pointed window
	 * 
	 * @return:Title of current Window
	 */
	public static String getTitle() {
		String title = driver.getTitle();
		log.info(title + "  :Returned Current Webpage Title!!");
		return title;
	}

	

	// This method will return path of Screenshot so that from this path captured
	// screenshot can be attached to Extent Report Automatically
	public static String screenshotforExtentReport(WebDriver driver, String tcName) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY hh-mm-ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);

		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\" + tcName
				+ " dated " + datetime + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(screenshotPath));
		} catch (IOException e) {
			log.info("Screenshot file not found!!");
			e.printStackTrace();
		}
		log.info("Screenshot taken Successfully!!");

		return screenshotPath;

	}

	/**
	 * This method will read the data from excel.
	 */
	@DataProvider
	public static Object[][] excelFileReading(String filepath) {
		Object[][] data = null;
		try {
			FileInputStream file = new FileInputStream(filepath);
			XSSFWorkbook book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			XSSFRow row = sheet.getRow(0);
			int columns = row.getLastCellNum();
			data = new Object[rows][columns];
			DataFormatter formatter = new DataFormatter();
			for (int i = 0; i < rows; i++) {
				row = sheet.getRow(i);

				for (int j = 0; j < columns; j++) {

					XSSFCell cell = row.getCell(j);

					data[i][j] = formatter.formatCellValue(cell);

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
}
