package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--incognito");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cap);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("[id='name']")).sendKeys("Abhishek");
		// handling alert with ok and cancle button
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		driver.switchTo().alert();

		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		// handliing alert with ok and cancle button
		driver.findElement(By.cssSelector("#name")).sendKeys("Abhi");
		driver.findElement(By.cssSelector("input#confirmbtn")).click();
		driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		driver.close();

	}

}
