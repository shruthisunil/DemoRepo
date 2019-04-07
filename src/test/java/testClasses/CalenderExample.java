package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderExample {
public static WebDriver	driver;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
	WebDriver	driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
	WebElement date=	driver.findElement(By.xpath("//div[@id='flightSearchContainer']/div[@class='picker-first2']/button[1]"));
	if(date.isDisplayed())
	{
		System.out.println("ITs displayed");
	}
		String dateVal="3-12-2019";
		selectDateByJS(driver,date,dateVal);
		Thread.sleep(10000);
		driver.quit();
	}
	
	public static void selectDateByJS(WebDriver driver,WebElement element, String date)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',"+date+");",element);
	}

}
