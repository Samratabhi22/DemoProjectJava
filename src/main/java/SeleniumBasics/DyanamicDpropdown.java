package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DyanamicDpropdown {

	public static void main(String[] args) throws InterruptedException {
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
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
		// driver.findElement(By.xpath("(//a[@value='BLR'])[1]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']"))
				.click();
		// //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		// //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));
		driver.findElement(By.xpath("//tr //td //input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));
		if (driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
			System.out.println("Its enabled");

		} else {
			Assert.assertTrue(false);
			System.out.println("Its Disabled");
		}

	}

}
