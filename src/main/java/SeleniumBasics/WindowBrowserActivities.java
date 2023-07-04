package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowBrowserActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
		 options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"} );
		 options.addArguments("--incognito");
		 DesiredCapabilities cap = new DesiredCapabilities();
		 cap.setCapability(ChromeOptions.CAPABILITY,options);
		 options.merge(cap);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://google.com");//it waits for the elements for the webpage to be loaded fully
		//there is in built wait mechanism inside it
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");//it doesnot wait for elements to be loaded
		//it directly start performing actions on webpage
		driver.navigate().back();
		driver.navigate().forward();
		driver.close();
	}

}
