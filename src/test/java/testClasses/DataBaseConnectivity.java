package testClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataBaseConnectivity {

	public WebDriver driver;
	public Statement smt;
	public PreparedStatement preparedStmt;
	public Connection con;
	@Test
	public void setUP()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void setUpDatabaseConnection() throws ClassNotFoundException, SQLException
	{
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver LOaded");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium", "root", "avyukthi");
		System.out.println("connected to sql");
		 smt=con.createStatement();
	
	/*}
	@Test
	public void readFromDB() throws SQLException
	{*/
		ResultSet rs=smt.executeQuery("Select * from testusers");
		while(rs.next())
		{
		
			String userName=rs.getString("username");
			System.out.println(userName);
			driver.findElement(By.id("email")).sendKeys(userName);
			
			String password=rs.getString("password");
			System.out.println(password);
			driver.findElement(By.id("pass")).sendKeys(password);
			
		}
	}
	
	/*@Test
	public void writeToDB() throws SQLException
	{
		String query="insert into testusers(username, password) values(?,?)";
		preparedStmt=con.prepareStatement(query);
		preparedStmt.setString(1, "avyu");
		preparedStmt.setString(2, "kthi");
		System.out.println("written to DB");
		preparedStmt.executeUpdate();
		//preparedStmt.close();
	}*/
}
