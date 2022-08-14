package utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTable {

	public static List<String> getRowdata(WebDriver driver, By locator, int rowno)
	{
		
		List<String> data = new ArrayList<>();
		WebElement table =driver.findElement(locator);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		
		WebElement currrow = rows.get(rowno-1);
		List<WebElement> cells = currrow.findElements(By.tagName("td"));
		for(WebElement cell : cells)
		{
			data.add(cell.getText());
		}
		return data;
	}
	
	
	public static String getCellData(WebDriver driver, By locator, int rowno, int colno)
	{
		String data;
		WebElement table = driver.findElement(locator);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		WebElement currrow = rows.get(rowno-1);
		List<WebElement> cells =currrow.findElements(By.tagName("td"));
		data = cells.get(colno-1).getText();
		return data;
			
	}

}
