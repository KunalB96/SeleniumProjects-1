package TestNg;

import org.testng.annotations.Test;

import utility.WebBrowser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class AmazonTest {
	WebDriver driver;
	@Parameters("product")
  @Test
  public void search(@Optional("shoes")String product) {
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  assertTrue(driver.getTitle().contains(product),"Title does not match");
  }
  
  @Parameters("criteria")
  @Test(priority=0,dependsOnMethods = "search")
  public void sort(@Optional("Price: Low to High")String criteria) {
	  driver.findElement(By.className("a-dropdown-label")).click();
	  
	  List<WebElement> sortoptions = driver.findElements(By.cssSelector("a.a-dropdown-link"));
      for(WebElement option : sortoptions)
      {
      	if(option.getText().equals(criteria))
      	{
      		option.click();
      		break;
      	}
      }
  }
  
  
  @Parameters("filteroption")
  @Test(priority=1,dependsOnMethods = "search")
  public void filter(@Optional("Campus")String filteroption) {
	WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated
      		(RelativeLocator.with(By.tagName("input"))
      		.toLeftOf(By.xpath("//span[text()='"+filteroption+"']"))));
      WebElement checkbox = driver.findElement(RelativeLocator.with(By.tagName("input"))
      		.toLeftOf(By.xpath("//span[text()='"+filteroption+"']")));
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].click()", checkbox);
  }
 
  @BeforeClass
  public void beforeClass() {
	  driver = WebBrowser.openBrowser("https://www.amazon.in/");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();	  
  }

}
