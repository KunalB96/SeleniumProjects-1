package TestNg;

import org.testng.annotations.Test;

import utility.WebBrowser;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class RediffDataTest {
	
	
	WebDriver driver;
	
	  @Test(dataProvider = "getData")
	  public void login(String uid, String pass) {
		  driver.findElement(By.id("login1")).sendKeys(uid);
			driver.findElement(By.id("password")).sendKeys(pass);
			driver.findElement(By.name("proceed")).click();
	  }
	  
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.findElement(By.id("login1")).clear();
		  driver.findElement(By.id("password")).clear();
	  }


	  @DataProvider
	  public String[][] getData() {
	   //1st 
		//  2nd
		  String [][] data = new String[3][2];
		  data[0][0] = "Kunal";
		  data[0][1] = "user011";
		  data[1][0] = "Kunal@";
		  data[1][1] = "user022";
		  data[2][0] = "Kunalb";
		  data[2][1] = "user034";
		  return data;
	  }
	  
	  
	  @BeforeClass
	  public void beforeClass() {
		  driver = WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
	  }
	  

	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

}
