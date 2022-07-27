package utilClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.graph.ElementOrder.Type;

import dev.failsafe.internal.util.Durations;

public class Util1 
{
	public static WebElement explicitWait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement newElement=wait.until(ExpectedConditions.visibilityOf(element));
		return newElement;
				
	}
	
	
	
public static String getProperty(String key) throws IOException
{
	FileInputStream file=new FileInputStream("configuration\\config.properties");
	
	Properties p=new Properties();
	
	p.load(file); 
	
	String property=p.getProperty(key); 
	
	return property;
}
public static String getScreenShot(WebDriver driver,String sName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String path="Screenshot\\"+sName+".png";
	File dest=new File(path);
	FileHandler.copy(source, dest);
	return path;
	
	
}
}
