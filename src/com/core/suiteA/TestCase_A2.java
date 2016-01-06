package com.core.suiteA;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.suiteB.TestSuiteBase;
import com.core.util.TestUtil;

public class TestCase_A2 extends TestSuiteBase {
	// Runmode of test case in a suite
			@BeforeTest
			public void checkTestSkip(){
				
				if(!TestUtil.isTestCaseRunnable(suiteAxls,this.getClass().getSimpleName())){
					APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
					throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
				}
			}
			
	@Test
	
	public void testCaseA2(){
		
		System.out.println("testcaseA2");
	}

}
