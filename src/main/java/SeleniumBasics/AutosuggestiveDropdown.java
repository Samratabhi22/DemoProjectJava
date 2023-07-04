package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestiveDropdown {
	//when options are are present based on your typing

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
		 options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"} );
		 options.addArguments("--incognito");
		 DesiredCapabilities cap = new DesiredCapabilities();
		 cap.setCapability(ChromeOptions.CAPABILITY,options);
		 options.merge(cap);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.cssSelector("input[class='inputs ui-autocomplete-input']")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement element :elements)
		{
			if(element.getText().equalsIgnoreCase("India"))
			{
				element.click();
				break;
			}
		}
		
//String text=driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input valid']")).getText();
//		System.out.println(text);
		//driver.close();

	}

}
