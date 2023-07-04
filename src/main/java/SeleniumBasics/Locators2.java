package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Abhishek";
//		WebDriverManager.chromedriver().setup();
//		 ChromeOptions options = new ChromeOptions();
//		 options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"} );
//		WebDriver driver = new ChromeDriver(options);
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys(name);

		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.cssSelector(".signInBtn")).submit();
//		WebDriverWait wait = new WebDriverWait(driver , 5);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("p"))));
		Thread.sleep(4000);
		String sucessfulLogin = driver.findElement(By.tagName("p")).getText();
		System.out.println(sucessfulLogin);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div h2")).getText(), "Hello " + name + ",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
	}

	public static String getPassword(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("reset-pwd-btn"))));
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String paaswordText = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray = paaswordText.split("'");
		String password = passwordArray[1].split("'")[0];
		return password;

	}

}
