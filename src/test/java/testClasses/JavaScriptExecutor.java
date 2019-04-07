package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement logIn=driver.findElement(By.xpath("//input[@value='Log In']"));
		//drawBorder(logIn, driver);
		getTitleByJS(driver);
		//clickElementByJs(logIn, driver);
		//generateAlert(driver, "this is an alert");
			
	}
public static void drawBorder(WebElement element, WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].style.border='3px solid red'", element);
}

public static void generateAlert(WebDriver driver, String message)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("alert('"+message+"')");
}

public static void clickElementByJs(WebElement element, WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",element);
}

public static String getTitleByJS(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	String title=js.executeScript("return document.title;").toString();
	return title;
}
}
