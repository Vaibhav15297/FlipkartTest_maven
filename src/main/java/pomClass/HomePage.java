package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends utilClass.Util1
{
	static WebDriver driver;
	
	@FindBy(xpath="//div[text()='vaibhav']")
	private WebElement ProfilePage;

	@FindBy(xpath="(//a[@class='_2kxeIr'])[1]")
	private WebElement myprofile;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
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
		
	}
}