package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
      //https://www.path2usa.com/travel-companion
		//July 2 2023		
       //org.openqa.selenium.ElementClickInterceptedException
		//
		driver.findElement(By.cssSelector("#departure")).click();
		//first select date than month and than year
		Thread.sleep(3000);
		List<WebElement> Alldates = driver.findElements(By.cssSelector("#departure"));
		int daysCount=Alldates.size();
		for(int i=0;i<daysCount;i++)
		{
			String text=Alldates.get(i).getText();
			if(text.equalsIgnoreCase("2"))
			{
				Alldates.get(i).click();
				break;
			}
		}
		

	

}
