package com.guru.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru.page.PdfPage;
import com.guru.page.WishlistPage;

public class PdfPageTest extends PdfPage{
	PdfPage pdf;
	@BeforeClass
	public void setUp() {
		openBrowserAnConfigure();
		launchURL();
		pdf = new PdfPage();

	}

	@Test
	public void verifyToCreateAccount() {
	pdf.login();
	log.info("Logined as User");
	Assert.assertEquals(pdf.getOrderStatus(), "Pending");
	pdf.printPdf();
	try {
		pdf.savepdf();
	} catch (IllegalArgumentException | IllegalAccessException e) {
		
		e.printStackTrace();
	}
	log.info("PDF saved");
	}
	
	@AfterClass
	public void tearDown() {

		closeBrowserWindow();
	}
}
