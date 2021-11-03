package com.bankingProject.test_cases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankingProject.pageObject.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
        
	@Parameters("browser")
	@Test
	public void loginTest() throws IOException {
		
		
		
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		System.out.println(username);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			
			
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		
	}
}
