package SeleniumBasics;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4NewFeatures {

	public static void main(String[] args) throws IOException {
		// Invoking multiple windows / Tabs from Selenium using one driver instance
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB).get("https://rahulshettyacademy.com");
		String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']"))
				.get(1).getText();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
//		WebElement nameEditBox = driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']"));
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
//		 nameEditBox.click();
//		 nameEditBox.sendKeys(courseName);
		//WebElement name=driver.findElement(By.cssSelector("[name='name']"));

		nameEditBox.sendKeys(courseName);
//		driver.switchTo().newWindow(WindowType.TAB);
//
//		Set<String> handles=driver.getWindowHandles();
//
//		Iterator<String> it=handles.iterator();
//
//		String parentWindowId = it.next();
//
//		String childWindow =it.next();
//
//		driver.switchTo().window(childWindow);
//
//		driver.get("https://rahulshettyacademy.com/");
//
//		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
//
//		.get(1).getText();
//
//		driver.switchTo().window(parentWindowId);
//
//		WebElement name=driver.findElement(By.cssSelector("[name='name']"));
//
//		name.sendKeys(courseName);
//		
		
		
		//Screenshot  of WebElement

		File file=nameEditBox.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("logo.png"));
		
		//GEt Height & Width  WebElement

		System.out.println(nameEditBox.getRect().getDimension().getHeight());

		System.out.println(nameEditBox.getRect().getDimension().getWidth());
		driver.quit();
		

	}

}
