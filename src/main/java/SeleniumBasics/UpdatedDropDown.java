package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--incognito");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cap);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElements(By.xpath("//div[contains(@class,'home-Discount')] //input")).size());

		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(4000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i = 1;
		while (i < 3) {
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
			i++;
		}
//		for(int j=0;j<2;j++)
//		{
//			driver.findElement(By.cssSelector("#hrefIncChd")).click();
//		}
		int k = 0;
		while (k < 1) {
			driver.findElement(By.cssSelector("#hrefIncInf")).click();
			k++;
		}

		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult, 1 Infant");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.close();

	}
}
