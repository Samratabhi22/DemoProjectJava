package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
		 options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"} );
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	String text=	driver.findElement(By.xpath("//header/div/button[text()='Login']")).getText();
	System.out.println(text);
	String texst=	driver.findElement(By.xpath("//header/div/button/following-sibling::button[text()='Login']/parent::div/button[text()='Practice']")).getText();
	System.out.println(texst);
	driver.close();
		

	}

}
