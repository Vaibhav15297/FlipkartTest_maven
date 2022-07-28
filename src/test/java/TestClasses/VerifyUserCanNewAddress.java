package TestClasses;

import java.io.IOException;

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
import pomClass.ProfilePage;


public class VerifyUserCanNewAddress 
{
	
static WebDriver driver;

HomePage hp;
ProfilePage pp;
//vaibhav
ExtentHtmlReporter extentReporter;
ExtentReports report;
ExtentTest test;



@BeforeClass
public void beforeClass() throws IOException
{
	extentReporter=BaseClass1.getHtmlReporter();
	report=BaseClass1.getReports();
	test=BaseClass1.getExtentTest("VerifyUserCanNewAddress");
	
	
	driver=BaseClass1.getDriver("chrome");
}
@BeforeMethod
public void beforeMethod()
{
	   hp=new HomePage(driver);
}
@Test
public void verifyUserCanGoToProfilePage() throws InterruptedException
{
	
    hp.moveToProfileName();
    hp.clickOnProfileText();
    hp.moveToProfileName();
    
     pp=new ProfilePage(driver);
    
    pp.getFullProfileName();
    
   
    
    Assert.assertTrue( pp.getFullProfileName());
}
@Test(priority=1)
public void veryUserCanChangeAddress() throws InterruptedException
{
	//int previousAddressCount=pp.saveAddressCount();
	//System.out.println(previousAddressCount);
	pp.clickManageAdress();
	int previousAddressCount=pp.saveAddressCount();
	System.out.println(previousAddressCount);
	pp.clickOnAddNewAddress();
	pp.fillAddressDetails();
	pp.fullMainAddress();
	pp.clickOnsaveAddress();
	Thread.sleep(1000);
	int currentAddressCount=pp.saveAddressCount();
	System.out.println(currentAddressCount);
	Assert.assertEquals(currentAddressCount,previousAddressCount + 1 );
	
	
}
@AfterMethod
public void aftermethod(ITestResult result) throws IOException
{
	if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS,result.getName() + " test passes");
	}
	else {
		String path = pp.getScreenShot(driver, result.getName());
		test.log(Status.FAIL, result.getName() + " test failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		//test.log(Status.FAIL, result.getName() + " test failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		//test.log(Status.FAIL, result.getName() + " test failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
	
	
}
@AfterClass
public void afterClass()
{
	report.flush();
	
}
	
	
	
}
