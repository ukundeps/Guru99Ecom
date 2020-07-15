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
	public void verifyToSaveOrderAsPDF() {
	pdf.loginAsUser();
	log.info("Logined as User");
	Assert.assertEquals(pdf.getOrderStatus(), "Pending");
	pdf.printPdf();
	try {
		pdf.saveAsPdf();
	} catch (IllegalArgumentException | IllegalAccessException e) {
		
		e.printStackTrace();
	}
	log.info("PDF Saved");
	}
	
	@AfterClass
	public void tearDown() {

		closeBrowserWindow();
	}
}
