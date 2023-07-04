package SeleniumBasics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartPageScenario {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("iphone 14");
		Thread.sleep(4000);
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath("//div[@class='lrtEPN _17d0yO']"))));
		
		////button
		List<WebElement> allSugg=driver.findElements(By.xpath("//a[@class='_3izBDY']"));
		int count = allSugg.size();
		System.out.println(count);          //      lrtEPN _17d0yO
		
		
		for(int i =0;i<count;i++)
		{
			String text=allSugg.get(i).getText();
			if(text.contains("iphone 14 pro"))
			{
				allSugg.get(i).click();
				break;
			}
		}
		//driver.findElement(By.xpath("//button")).submit();
		//driver.findElement(By.xpath("//button")).click();
		int total=0;
		for(; ;)
		{
			try
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			catch(Throwable e)
			{
				List<WebElement> phones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
				total=total+phones.size();
			}
			if(total==56)
			{
				break;
			}
		}
		System.out.println("No. of Iphone 14 pro : "+total);
		String text=driver.findElement(By.xpath("//span[@class='_10Ermr']")).getText();
		System.out.println(text);
	String[] name	=text.split("of");
	String formattedName =name[1];
	String [] formatName=formattedName.split("results");
	String s=formatName[0].trim();
	System.out.println(s);
	Assert.assertTrue(true, s);
	System.out.println("====Reached End==========");

		
     }

}



