package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxesHandle {

	public static void main(String[] args) {
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
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	System.out.println(driver.findElements(By.xpath("//div[contains(@class,'home-Discount')] //input")).size());
	

	}

}
