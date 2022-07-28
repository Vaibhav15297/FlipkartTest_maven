package TestClasses;

import java.io.IOException;

import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClass.BaseClass1;
import pomClass.HomePage;
import pomClass.LoginPage;
import pomClass.ProfilePage;

public class VerifyUserCanLogin 
{
       
	static WebDriver driver; 
       LoginPage lp;
       ExtentHtmlReporter extentReporter;
       ExtentReports report;
    	ExtentTest test;
    	
       
       @BeforeClass
       public void beforeClass() throws IOException
       {
    	   extentReporter=BaseClass1.getHtmlReporter();
    	   report=BaseClass1.getReports();
    	   test=BaseClass1.getExtentTest("VerifyUserCanLogin");
    	   
    	   driver=BaseClass1.getDriver("chrome");
       }
       @BeforeMethod 
       public void beforeMethod()
       {
    	    lp=new LoginPage(driver);
       }
       @Test()
       public void verifyUserCanLogin() throws IOException, InterruptedException
       {
    	   lp.enterEmail();
    	   lp.passWord();
    	   lp.ClickLoginBtn();
    	   
    	  // ProfilePage pp=new ProfilePage(driver);
    	   HomePage hp=new HomePage(driver); 
    	   
    	   String Exceptedresult="vaibhav";
    	   
    	   String result=hp.VerifyProfileName();
    	   
    	   Assert.assertEquals(Exceptedresult,result);
		
    	   
    	   
       }
       @AfterMethod
       public void afterMethod(ITestResult result) throws IOException
       {
    	   System.out.println("after method");
    	   if(result.getStatus() == ITestResult.SUCCESS)
   		{
   			test.log(Status.PASS, result.getName() + " test passed");
   		}
   		else {
   			
   			String path = lp.getScreenShot(driver, result.getName());
   			//test.log(Status.FAIL,result.getName() +"test failed",MediaEntityBuilder.createScreenCaptureFromPath(path));
   			test.log(Status.FAIL,result.getName()+"test failed");
   			MediaEntityBuilder.createScreenCaptureFromPath(path);
			
   	
   			//test.log(Status.FAIL, result.getName() + " test failed");
   			
   		}
       }
       @AfterClass
       public void afterclass()
       {
    	   System.out.println("after class");
    	   report.flush();
       }
}
