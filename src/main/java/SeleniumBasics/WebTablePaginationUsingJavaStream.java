package SeleniumBasics;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePaginationUsingJavaStream {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on column
		driver.findElement(By.xpath("//tr/th/span[text()='Veg/fruit name']")).click();
		//capture text all webelements into list
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelemnts into new(original) list
		List<String> originalList = veggies.stream().map(s->s.getText()).collect(Collectors.toList());
		//use sorting to sort in the original list of step 3 -->sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		//compare original list with sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		//here both will be same
		List<String> price ;
		do
		{
			List<WebElement> veggiesPage = driver.findElements(By.xpath("//tr/td[1]"));
		price= veggiesPage.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}while(price.size()<1);

	}
	//now my citeria is to get the price of all vegetables
	//scan the veggies column name  and get the text ----> Beans

	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
	

}
