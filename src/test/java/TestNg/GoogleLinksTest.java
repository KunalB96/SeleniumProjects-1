package TestNg;

import org.testng.annotations.Test;

import utility.WebBrowser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class GoogleLinksTest {
	WebDriver driver;
  @Test(priority=0, groups="top")
  public void gmail() {
	  driver.findElement(By.linkText("Gmail")).click();
	  assertEquals(driver.getTitle(), "Gmail: Free, Private & Secure Email | Google Workspace");
  }
  
  @Test(priority=1, groups="top")
  public void images() {
	  driver.findElement(By.linkText("Images")).click();
	  assertEquals(driver.getTitle(), "Google Images");
  }
  
  @Test(priority=2, groups="bottom")
  public void advertising() {
	  driver.findElement(By.linkText("Advertising")).click();
	  assertEquals(driver.getTitle(), "Get More Customers With Easy Online Advertising | Google Ads");
  }
  
  @Test(priority=3, groups="bottom")
  public void search() {
	  driver.findElement(By.partialLinkText("How Search")).click();
	  assertEquals(driver.getTitle(), "Google Search – Discover how Google Search works");
  }
  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  driver.navigate().back();
  }

  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
	  driver = WebBrowser.openBrowser("https://www.google.co.in");
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  driver.close();
  }
  
  @BeforeTest(alwaysRun=true)
  public void beforeTest()
  {
	  System.out.println("This runs at the begining of the test configuration - Google");
  }
  @AfterTest(alwaysRun=true)
  public void afterTest()
  {
	  System.out.println("This runs at the end of the test configuration - Google");
  }

}
