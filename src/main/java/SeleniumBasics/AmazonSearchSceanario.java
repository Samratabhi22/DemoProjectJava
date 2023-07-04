package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchSceanario {

	public static void main(String[]args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']")).sendKeys("Bats");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).sendKeys("Bats");
		
	}
}
