package SeleniumBasics;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilterRiceGreenKart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		//suppose it has 5 results(Brown rice,rice, chia rice,white rice)
		List<WebElement> filteredVeggies = veggies.stream().filter(veggie->veggie.getText().contains("Rice"))
		.collect(Collectors.toList());
		// filtering to get 1 results only with Rice 
		//suppose it is showing 5 results in veggies list and 1 result in  filteredVeggies , then something is wrong
		//both should be same 
		Assert.assertEquals(veggies.size(),filteredVeggies.size());
		//Assertion is passed because both size is equal  
		System.out.println("============Reached end=======");

	}

}
