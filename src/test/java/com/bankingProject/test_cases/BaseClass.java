package com.bankingProject.test_cases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bankingProject.utilities.ReadConfig;

public class BaseClass {
	
	
	ReadConfig readConfig=new ReadConfig();
	
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUsename();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br){
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		
		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else if (br.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		
		logger=Logger.getLogger("BaseClass.java");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	@AfterClass
    public void tearDown(){
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNum() {
		String generatedString2=RandomStringUtils.randomNumeric(5);
		return generatedString2;
	}
	

}
