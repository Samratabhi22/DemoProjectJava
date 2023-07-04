package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Abhishek");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulacademy");
		driver.findElement(By.cssSelector(".signInBtn")).submit();

		String errormessage = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errormessage);

		driver.findElement(By.linkText("Forgot your password?")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("reset-pwd-btn"))));
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Abhi");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abhi@gmail.com");
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[contains(@placeholder,'mail')]")).sendKeys("abhiksingh@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9874563210");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String text = driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(text);
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Abhishek Kumar");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.cssSelector("input[id*='boxTwo']")).click();
		driver.findElement(By.cssSelector("button.submit")).submit();
		String sucessfulLogin = driver.findElement(By.tagName("p")).getText();
		System.out.println(sucessfulLogin);
		driver.close();

	}

}
