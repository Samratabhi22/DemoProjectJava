package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllLinksOfAWebPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
		//Get count and get the all links on webpage
		System.out.println(driver.findElements(By.tagName("a")).size());
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement link :links)
		{
			System.out.println(link.getText());
		}
		// get the all links on webpage on the footer section of webpage

	}

}
