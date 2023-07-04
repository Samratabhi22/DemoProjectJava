package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowRootElementsSelectorsHub {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement frames	=driver.findElement(By.xpath("//iframe[@title]"));
		driver.switchTo().frame(frames);
		WebElement root=driver.findElement(By.cssSelector("div.jackPart"));//root node // shadow root 1
		WebElement shadowDom1 =getShadowDOM(root,driver );
		WebElement app=	shadowDom1.findElement(By.cssSelector("#app2"));
		WebElement shadowDom2 =getShadowDOM(app,driver );
		shadowDom2.findElement(By.cssSelector("")).sendKeys("Dominos");
		

	}
	public static WebElement getShadowDOM(WebElement element,WebDriver driver )
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement shadowDom1=(WebElement) js.executeScript("return arguments[0]", element);
		return shadowDom1;
	}

}
