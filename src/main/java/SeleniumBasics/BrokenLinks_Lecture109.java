package SeleniumBasics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks_Lecture109 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		//Write a script so that your selenium script should scan all the links and tell which are the links that are broken or not working
		//BrokenLinks == Broken URL
		//broken link is nothing but url that is tied with that link is not working or  404 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//you can actually tell without clicking on the link on the browser 
		//it is times consuming supose 100 links ==it will take 30 minutes for that 
		//so to avoid such  on network tab on Developer tools
		//200 , 300 ---sucessfl
		//400 ---> unsucessfull - broken
		
		
		//step1--> is to get all urls tied to that link using selenium getAttrribute() method
		//step 2--> java methods to call all URLS an get you the status code
		//if status code is 400 or greater than 400 then that url is not working ---> link that tied to that url is broken
		
		//             a[href*="soapui"]
		SoftAssert asert = new SoftAssert();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> allLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link :allLinks)
		{
			String	url=link.getAttribute("href");//working link 
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			asert.assertTrue(responseCode<400, "The link with text "+link.getText()+" is broken with code "+responseCode);
			
		}
		asert.assertAll();
		
		
		
		
		
		
	//String	url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");//working link
//		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
//		conn.setRequestMethod("HEAD");
//		conn.connect();
//		int responseCode = conn.getResponseCode();
//		System.out.println(responseCode);
	

	}

}
