package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndtoEndDemoSpicejet {

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
		driver.findElement(By.cssSelector("input[class='inputs ui-autocomplete-input']")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase("India")) {
				element.click();
				break;
			}
		}
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
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElements(By.xpath("//div[contains(@class,'home-Discount')] //input")).size());
		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(4000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i = 1;
		while (i < 3) {
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
			i++;
		}
//			for(int j=0;j<2;j++)
//			{
//				driver.findElement(By.cssSelector("#hrefIncChd")).click();
//			}
		int k = 0;
		while (k < 1) {
			driver.findElement(By.cssSelector("#hrefIncInf")).click();
			k++;
		}

		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult, 1 Infant");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select staticdropdown = new Select(element);
//			staticdropdown.selectByIndex(3);
//			System.out.println(staticdropdown.getFirstSelectedOption().getText());
//			staticdropdown.selectByVisibleText("AED");
//			System.out.println(staticdropdown.getFirstSelectedOption().getText());
		staticdropdown.selectByValue("INR");
		System.out.println(staticdropdown.getFirstSelectedOption().getText());

		System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));
		// driver.findElement(By.xpath("//tr //td
		// //input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));
		if (driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
			System.out.println("Its Disabled");

		} else {
			Assert.assertTrue(false);
			System.out.println("Its Enabled");
		}
		System.out.println("Before clicking search button  " + driver.getCurrentUrl());
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).submit();
		System.out.println("After clicking search button  " + driver.getCurrentUrl());

		driver.close();

	}

}
