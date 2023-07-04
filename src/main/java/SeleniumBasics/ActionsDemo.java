package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
	Actions act = new Actions(driver);
	WebElement element = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
	WebElement searchTextBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
	
	//moves to specific element and right click
	act.moveToElement(element).contextClick().build().perform();
	//writing hello in capital letters  and double click on text to highlight text
	act.moveToElement(searchTextBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	//drag and drop
	

	}

}
