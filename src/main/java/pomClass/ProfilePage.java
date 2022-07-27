package pomClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends utilClass.Util1 
{
	static WebDriver driver;
/*	
@FindBy(xpath="//div[text()='vaibhav']")
private WebElement ProfilePage;

@FindBy(xpath="(//a[@class='_2kxeIr'])[1]")
private WebElement myprofile;*/

@FindBy(xpath="//div[text()='vaibhav kothewar']")
private WebElement profilefullname;

@FindBy(xpath="//div[text()='Manage Addresses']")
private WebElement manageAddress;

@FindBy(xpath="//div[@class='_1QhEVk']")
private WebElement AddNewAddress;

@FindBy(xpath="//div[@class='_1lRtwc _1Jqgld']/input")
private List<WebElement> addressDetails;

@FindBy(xpath="//textarea")
private WebElement address;

@FindBy(xpath="//button[text()='Save']")
private WebElement saveAddress;

@FindBy(xpath="//div[@class='_1CeZIA']")
private List<WebElement>saveAddressCount;




public ProfilePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	this.driver=driver;
	
}/*
public String VerifyProfileName() throws InterruptedException
{
	Thread.sleep(2000);
	String result=ProfilePage.getText();
	return result;
}	
public void moveToProfileName() throws InterruptedException
{
	Thread.sleep(3000);
	Actions act=new Actions(driver);
	act.moveToElement(ProfilePage).perform();
	

}
public void clickOnProfileText()
{
	//Actions ac=new Actions(driver);
	//WebElement element= explicitWait(driver, myprofile);
	myprofile.click();
	//ac.moveByOffset(1000, 1000).contextClick();
	
}*/
public boolean getFullProfileName()
{
	WebElement element1=explicitWait(driver,profilefullname);
	String fullname=profilefullname.getText();
	System.out.println(fullname);
	
	if(fullname.contains("Vaibhav Kothewar"))
	{
		return true;
	}
	else
	{
		return false;
	}
}
public void clickManageAdress()
{
	manageAddress.click();	
}
public void clickOnAddNewAddress()
{
	AddNewAddress.click();
}
public void fillAddressDetails()
{
	String[] k={"vaibhav","7588764425","441222","sindewahi"};
	
	for(int i=0;i<4;i++)
	{
		addressDetails.get(i).sendKeys(k[i]);
	}
	
	
}
public void fullMainAddress()
{
	address.sendKeys("Gujari chowk near bustop chandrapur ");
}
public void clickOnsaveAddress()
{
	saveAddress.click();
}
public int saveAddressCount()
{
	return saveAddressCount.size();
}



	

	
	
	





}
