package SeleniumBasics;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllLinksOnFooterSectionOfWebPage {

	public static void main(String[] args) throws InterruptedException {
		// 1 //Get the links of footer elements
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
		WebElement element = driver.findElement(By.cssSelector("#navFooter"));// limiting webdriver scope to footer
																				// section
		System.out.println(element.findElements(By.tagName("a")).size());
		System.out.println("============ Complete Footer Section ======================");
		List<WebElement> footerElements = element.findElements(By.tagName("a"));
		System.out.println(footerElements.size());
		for (WebElement footerElement : footerElements) {// print all the links in footer section
			System.out.println(footerElement.getText());
		}
		System.out.println("================== left column of footer=====================");
		// 2 limiting the scope to left column of footer
		WebElement columnElement = element
				.findElement(By.cssSelector("div.navFooterLinkCol.navAccessibility:nth-child(1)"));
		List<WebElement> columnElementLinks = columnElement.findElements(By.tagName("a"));
		System.out.println(columnElementLinks.size());
		for (WebElement columnElementLink : columnElementLinks) {
			System.out.println(columnElementLink.getText());
		}
		System.out.println("=======================================");
		// 3 check whether all the links are working or not means pages are opening or
		// not upon clicking on the links
		for (int i = 0; i < columnElementLinks.size(); i++) {
			// press contol keys from keyboard and click on everylink
			String clickOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnElementLinks.get(i).sendKeys(clickOnTab);
			// Thread.sleep(7000);
			// this for loops opens all the tabs in the window

		}

		Set<String> s = driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			// this while loop iterates over all the open windows including the parent
			// window
			driver.switchTo().window(it.next());
			// switch to that window and get the title
			System.out.println(driver.getTitle());
			System.out.println("=======================================");
		}

	}

}
