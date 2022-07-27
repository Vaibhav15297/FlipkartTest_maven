package pomClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClass.Util1;

public class LoginPage extends utilClass.Util1
{
	WebDriver driver;
	
	//findElement
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	private WebElement EmailField;

	@FindBy(xpath="//input[@type='password']")
	private WebElement PasswordField;

	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement LoginBtn;
	
	//constructor
	public LoginPage(WebDriver driver)
	{ 
		PageFactory.initElements(driver,this); 
		this.driver=driver;
		
	}
	//public method
	public void enterEmail() throws IOException
	{
		EmailField.sendKeys(Util1.getProperty("username"));
	}
	public void passWord() throws IOException
	{
		PasswordField.sendKeys(Util1.getProperty("password"));
		
	}
	public void ClickLoginBtn()
	{
		LoginBtn.click();
	}
	
}
