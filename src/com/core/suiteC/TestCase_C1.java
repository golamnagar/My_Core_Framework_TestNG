package com.core.suiteC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import webStore_DataProvider.Data_Provider;

import com.core.suiteB.TestSuiteBase;
import com.core.util.TestUtil;

public class TestCase_C1 extends TestSuiteBase{
	
	public static WebDriver driver;
	
	
	
	// Runmode of test case in a suite
			@BeforeTest
			public void checkTestSkip(){
				
				if(!TestUtil.isTestCaseRunnable(suiteCxls,this.getClass().getSimpleName())){
					APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
					throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
				}
						}
			
  @Test(priority =1, dataProvider="RegisterData")
 
		 public void testcaseC1(
					String name,
					String email, String pass, String conpass
					 ) throws Exception{ 

APP_LOGS.debug(" Executing TestCase_C1");
APP_LOGS.debug(name +" -- "+email+"--"+pass+ "--"+conpass);

 driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.get("http://webloadmpstore.com");
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
long currentTime = System.currentTimeMillis();
driver.findElement(By.linkText("LOGIN")).click();
driver.findElement(By.linkText("Register")).click();
driver.findElement(By.name("name")).clear();
driver.findElement(By.name("name")).sendKeys(name);
driver.findElement(By.name("email")).clear();
driver.findElement(By.name("email")).sendKeys(email);
driver.findElement(By.name("phone")).clear();
driver.findElement(By.name("phone")).sendKeys("1234567890");
driver.findElement(By.name("login")).clear();
driver.findElement(By.name("login")).sendKeys("QA"+ currentTime);
Thread.sleep(2000);
driver.findElement(By.name("password")).clear();
driver.findElement(By.name("password")).sendKeys(pass);
driver.findElement(By.name("password2")).clear();
driver.findElement(By.name("password2")).sendKeys(conpass);
driver.findElement(By.name("loginAfterRegistration")).click();
driver.findElement(By.name("Submit")).click();
Thread.sleep(2000);
driver.findElement(By.linkText("LOGOUT")).click();
driver.navigate().refresh();
Thread.sleep(2000);
driver.quit();
  
  
  }
  
  @DataProvider(name="RegisterData")
	
	public Object[][] getTestData(){

	return TestUtil.getData(suiteCxls, this.getClass().getSimpleName()) ;
	}
  
}
