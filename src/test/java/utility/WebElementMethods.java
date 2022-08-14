package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementMethods {

	  public static void enterText(WebDriver driver, By locator, String text)
	  {
		  try {
			  WebElement we = driver.findElement(locator);
			  if(we.isEnabled())
			  {
				  we.sendKeys(text);
			  }
			  else
				  System.out.println("Element is disabled");
		  }
		   catch (NoSuchElementException e) {
			   System.out.println("Unable to locate an element with given locator"+locator);
			   System.out.println(e.getMessage());
		   }
	  }
		  
		public static void clearText(WebDriver driver, By locator)
		{
			try {
				WebElement we = driver.findElement(locator);
				if(we.isEnabled())
				{
					we.clear();
				}
				else
					System.out.println("Element is disabled");
			}
			catch (NoSuchElementException e) {
				   System.out.println("Unable to locate an element with given locator"+locator);
				   System.out.println(e.getMessage());
			   }
		}
		
		
		public static void clickElement(WebDriver driver, By locator)
		{
			try {
				WebElement we = driver.findElement(locator);
				if(we.isEnabled())
				{
					we.click();
				}
				else
					System.out.println("Element is disabled");
			}
			catch (NoSuchElementException e) {
				   System.out.println("Unable to locate an element with given locator"+locator);
				   System.out.println(e.getMessage());
			   }
		}
		
		
		public static void  SelectCheckBox(WebDriver driver, By locator)
		{
			try {
				WebElement we = driver.findElement(locator);
				if(we.isEnabled() && !we.isSelected())
				{
					we.click();
				}
				else
					System.out.println("Element is disabled / Already Selected");
			}
			catch (NoSuchElementException e) {
				   System.out.println("Unable to locate an element with given locator"+locator);
				   System.out.println(e.getMessage());
			   }
		}
		
		
		
		public static void  SelectCheckBox(WebDriver driver, By locator, String value)
		{
			List<WebElement> checkboxes =driver.findElements(locator);
					if(checkboxes.size()>0)
					{
						for(WebElement ch : checkboxes)
						{
							if(ch.getAttribute("value").equals(value))
							{
								if(!ch.isSelected())
								{
									ch.click();
									break;
								}
							}
								
						}
					}
					else
					{
						System.out.println("Unable to locate an element with given locator"+locator);
					}
		}
		
		
		
		
		public static void  SelectRadio(WebDriver driver, By locator, String value)
		{
			List<WebElement> radio =driver.findElements(locator);
					if(radio.size()>0)
					{
						for(WebElement rb : radio)
						{
							if(rb.getAttribute("value").equals(value))
							{
								if(!rb.isSelected())
								{
									rb.click();
									break;
								}
							}
								
						}
					}
					else
					{
						System.out.println("Unable to locate an element with given locator"+locator);
					}
		}
		
		
		
		public static void  SelectDropDownByValue(WebDriver driver, By locator, String value)
		{
			try {
				boolean flag = false;
				WebElement we =driver.findElement(locator);
				Select DropDown = new Select(we);
				List<WebElement> options = DropDown.getOptions();
				for(WebElement op : options)
				{
					if(op.getAttribute("value").equals(value))
					{
						DropDown.selectByValue(value);
						flag = true;
					}
				}
				if(flag==true)
				{
					System.out.println("Option is Selected");
				}
				else
					System.out.println("Incorrect Option");
			}
				catch (NoSuchElementException e) {
					   System.out.println("Unable to locate an element with given locator"+locator);
					   System.out.println(e.getMessage());
				   }
		}
		
		
		
		
		public static void  SelectDropDownByText(WebDriver driver, By locator, String value)
		{
			try {
				boolean flag = false;
				WebElement we =driver.findElement(locator);
				Select DropDown = new Select(we);
				List<WebElement> options = DropDown.getOptions();
				for(WebElement op : options)
				{
					if(op.getText().equals(value))
					{
						DropDown.selectByVisibleText(value);
						flag = true;
					}
				}
				if(flag==true)
				{
					System.out.println("Option is Selected");
				}
				else
					System.out.println("Incorrect Option");
			}
				catch (NoSuchElementException e) {
					   System.out.println("Unable to locate an element with given locator"+locator);
					   System.out.println(e.getMessage());
				   }
		}
		
  }


