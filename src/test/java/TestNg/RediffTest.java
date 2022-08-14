package TestNg;

import org.testng.annotations.Test;

import utility.WebBrowser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class RediffTest {
	WebDriver driver;
	@Test
	public void invalidLogin() {
		driver.findElement(By.id("login1")).sendKeys("testuser");
		driver.findElement(By.id("password")).sendKeys("test@123");
		driver.findElement(By.name("proceed")).click();
		WebElement lableerror = driver.findElement(By.cssSelector("div#div_login_error>b"));
		String actualerror = lableerror.getText();
		assertEquals(actualerror,"Wrong username and password combination.");
	  }
	
  @Test
  public void validLogin() {
	  driver.findElement(By.id("login1")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("admin@123");
	driver.findElement(By.name("proceed")).click();
	 System.out.println("Done"); 
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Executing a Test");
  }
  @AfterMethod
  public void clearData() {
	  driver.findElement(By.id("login1")).clear();
  }
  @BeforeClass
  public void setUp() {
	  driver = WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
  }

  @AfterClass
  public void tearDown() {
	  driver.close();
  }
  
  @BeforeSuite
  public void beforeSuite()
  {
	  System.out.println("This runs before all test configurations");
  }
  @AfterSuite
  public void afterSuite()
  {
	  System.out.println("This runs at end of all test configurations");
  }
  
  @BeforeTest
  public void beforeTest()
  {
	  System.out.println("This runs at the begining of the test configuration");
  }
  @AfterTest
  public void afterTest()
  {
	  System.out.println("This runs at the end of the test configuration");
  }

}
