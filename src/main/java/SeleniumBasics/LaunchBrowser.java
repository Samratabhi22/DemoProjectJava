package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) 
	{
		//WebDriverManager.firefoxdriver().setup(); 
	//	WebDriverManager.chromedriver().setup();
	WebDriverManager.edgedriver().setup();
				
	 //  WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com");
		String title=driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
		

	}

}
