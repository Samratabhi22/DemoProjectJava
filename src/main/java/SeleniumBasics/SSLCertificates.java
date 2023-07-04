package SeleniumBasics;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificates {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();

		// ChromeOptions options = new ChromeOptions();

		// Add the WebDriver proxy capability.

		Proxy proxy = new Proxy();

		proxy.setHttpProxy("myhttpproxy:3337");

		options.setCapability("proxy", proxy);
		// Add extension
		options.addExtensions(new File("/path/to/extension.crx"));

		// Set download directory or path

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/directory/path");

		options.setExperimentalOption("prefs", prefs);

		// Block popups --->like Know your location
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		// to run testscripts in incognito tab

		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--incognito");

		// to run testscripts without "Chrome is automated by test software"
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cap);

		// FirefoxOptions options1 = new FirefoxOptions();

		// options1.setAcceptInsecureCerts(true);

		// EdgeOptions options2 = new EdgeOptions();

		options.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());

	}

}
