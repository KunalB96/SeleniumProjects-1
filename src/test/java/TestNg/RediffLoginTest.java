package TestNg;

import org.testng.annotations.Test;

import utility.WebBrowser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class RediffLoginTest {
	WebDriver driver;
	@Parameters({"uid","pass"})
	@Test
	public void invalidLogin(String uid, String pass) {
		driver.findElement(By.id("login1")).sendKeys(uid);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.name("proceed")).click();
		WebElement lableerror = driver.findElement(By.cssSelector("div#div_login_error>b"));
		String actualerror = lableerror.getText();
		assertEquals(actualerror,"Wrong username and password combination.");
	  }
//	
//	@Parameters({"username","password"})
//  @Test
//  public void validLogin(String username, String password) {
//	  driver.findElement(By.id("login1")).sendKeys(username);
//	driver.findElement(By.id("password")).sendKeys(password);
//	driver.findElement(By.name("proceed")).click();
//	 System.out.println("Done"); 
//  }
  
  @AfterMethod
  public void clearData() {
	  driver.findElement(By.id("login1")).clear();
	  driver.findElement(By.id("password")).clear();
  }
  @BeforeClass
  public void setUp() {
	  driver = WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
  }

  @AfterClass
  public void tearDown() {
	  driver.close();
  }
  
}
