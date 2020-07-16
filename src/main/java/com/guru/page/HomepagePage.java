package com.guru.page;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru.base.Base;

public class HomepagePage extends Base {
	
	
	public HomepagePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	
}