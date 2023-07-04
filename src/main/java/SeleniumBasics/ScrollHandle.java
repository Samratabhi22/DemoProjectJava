package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//how to scrooll to the page
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		//first make the focus inside the table and than scroll 
		//for creating the focus of dom to the table we have used document.querySelector('.tableFixHead') 
		//.className===> is nothing but css selector
		//document.querySelector('.tableFixHead').scrollTop=150
		
		//how to scroll to the component
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=150");
		
		//how to handle table grids 
		//   ccssSelector for td4--->  .tableFixHead td:nth-child(4)
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<values.size();i++)
		{
			//now adding all the valuesin table of td4 we have to convert all the string into integer
			//and then compare with total
			//System.out.println(Integer.parseInt(values.get(i).getText()));//just for verification whether integer is printing or not
			sum=sum+Integer.parseInt(values.get(i).getText());
			
			
		}
		System.out.println(sum);//actual 
	int total=	Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
	//driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
	//System.out.println(total);//expected
		Assert.assertEquals(sum, total);
		

	}

}
