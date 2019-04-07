package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderExampleUsingLoops {

	public static void main(String[] args) {
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
		
		String date1 ="31-March-2019";
		String dateArr[]=date1.split("-");
		String day=dateArr[0];
		String month=dateArr[1];
		String year=dateArr[2];
		//-- here tr and td values are variables at the time of execution, we can pass any values to this (//table[@class='ui-datepicker-calendar'])[1]//tr[2]//td[3]
String BeforeXpath="(//table[@class='ui-datepicker-calendar'])[1]//tr[";
String afterXpath="]//td[";

final int totalWeekDays=7;
boolean flag=false;
for(int rowNum=2; rowNum<=7;rowNum++)
{
	for(int colNum=1; colNum<=totalWeekDays;colNum++)
	{
		String DateVal=driver.findElement(By.xpath(BeforeXpath+rowNum+afterXpath+colNum+"]")).getText();
				System.out.println(DateVal);
				if(DateVal.equals(day))
				{
					driver.findElement(By.xpath(BeforeXpath+rowNum+afterXpath+colNum+"]")).click();
					flag=true;
					break;
				}
	}
	if(flag)
	{
		break;
	}
}
	}
}
