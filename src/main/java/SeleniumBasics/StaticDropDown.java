package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	Select	staticdropdown = new Select(element);
	staticdropdown.selectByIndex(3);
	System.out.println(staticdropdown.getFirstSelectedOption().getText());
	staticdropdown.selectByVisibleText("AED");
	System.out.println(staticdropdown.getFirstSelectedOption().getText());
	staticdropdown.selectByValue("INR");
	System.out.println(staticdropdown.getFirstSelectedOption().getText());

	}

}
