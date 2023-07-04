package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCookies {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// to open the browser in fullscreen
		// driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		// to delete all the cookies
		driver.manage().deleteAllCookies();
		// to delete the specific cookie
		// driver.manage().deleteCookieNamed("asdf");
		// if you delete session id cookie your script should get logout

		// 1 .delete the session cookie
		// 2.make sure that secure login gets logout
		// 3.and he has to navigate to the Home Page
		// how to automate the above steps
		// driver.manage().deleteCookieNamed("sessionKey");
		// after deleting the above cookie
		// if you click on anything on your webpage it should bring back to the login
		// page

		// click on any link
		// then validate if you are on login page
		driver.get("https://www.google.com");

	}

}
