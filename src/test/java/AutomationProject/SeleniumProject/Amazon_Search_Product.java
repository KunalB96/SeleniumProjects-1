package AutomationProject.SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_Search_Product {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
		//Create object of driver
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();

		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wrist watch");
		 driver.findElement(By.id("nav-search-submit-button")).click();
		 
		 
		 
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated
		(RelativeLocator.with(By.tagName("input"))
			   .toLeftOf(By.xpath("//*[@id=\"p_n_feature_seven_browse-bin/1480900031\"]/span/a/span"))));
			  WebElement checkbox = driver.findElement(RelativeLocator.with(By.tagName("input"))
			    .toLeftOf(By.xpath("//*[@id=\"p_n_feature_seven_browse-bin/1480900031\"]/span/a/span")));
			      JavascriptExecutor js = (JavascriptExecutor) driver;
			      js.executeScript("arguments[0].click()", checkbox);
			      
		    // To Select Material Leather
			      WebDriverWait  wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
				    wait2.until(ExpectedConditions.visibilityOfElementLocated
					(RelativeLocator.with(By.tagName("input"))
						   .toLeftOf(By.cssSelector("#p_n_material_browse\\/1480907031 > span > a > span"))));
						  WebElement checkbox2 = driver.findElement(RelativeLocator.with(By.tagName("input"))
						    .toLeftOf(By.cssSelector("#p_n_material_browse\\/1480907031 > span > a > span")));
						      JavascriptExecutor js2 = (JavascriptExecutor) driver;
						      js2.executeScript("arguments[0].click()", checkbox2);	    
						      
						      
						   
		// To Select 'Titan' Brand		
			driver.findElement(By.xpath("//*[@id=\"brandsRefinements\"]/ul/li[8]/span/div/a/span")).click();			      
		 WebDriverWait  wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait3.until(ExpectedConditions.visibilityOfElementLocated
		(RelativeLocator.with(By.tagName("input"))
		.toLeftOf(By.xpath("//*[@id=\"p_89/Titan\"]/span/a/span"))));
		 WebElement checkbox3 = driver.findElement(RelativeLocator.with(By.tagName("input"))
		.toLeftOf(By.xpath("//*[@id=\"p_89/Titan\"]/span/a/span")));
		  JavascriptExecutor js3 = (JavascriptExecutor) driver;
		 js3.executeScript("arguments[0].click()", checkbox3);	
		 
		 
	 // To Select Discount: "25% Off or more"
		
		 WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
					(By.xpath("//*[@id=\"p_n_pct-off-with-tax/2665400031\"]/span/a/span")));
			driver.findElement(By.xpath("//*[@id=\"p_n_pct-off-with-tax/2665400031\"]/span/a/span")).click();
			
				  
	}

}
