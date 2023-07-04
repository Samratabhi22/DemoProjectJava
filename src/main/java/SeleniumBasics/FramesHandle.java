package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//WebElement element = driver.findElement(By.className("demo-frame"));
	//	driver.switchTo().frame(element);
		driver.switchTo().frame(0);
	WebElement source=	driver.findElement(By.id("draggable"));
	WebElement destination = driver.findElement(By.id("droppable"));
	
	
	Actions act = new Actions(driver);
	act.dragAndDrop(source, destination).build().perform();
	driver.switchTo().defaultContent();
		

	}

}
