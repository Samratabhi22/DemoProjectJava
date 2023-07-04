package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCertificatesHandling {

	public static void main(String[] args) {
		// this SSLCertificates might happen when you are working to your projects
		// internal to your organisation
		WebDriverManager.chromedriver().setup();
		// ChromeOptions class will set the behavoiur for your Chrome browser through
		// ChromeDriver
		// and that behavoiur options object reference you have to pass in
		// ChromeDriver(options)
		ChromeOptions options = new ChromeOptions();
		
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
