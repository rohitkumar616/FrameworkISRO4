package hardcodedTestScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKartcountOfIphone {

	public static void main(String[] args) {
		m1();
	}
	public static void m1()
	{
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&as-pos=1&as-type=HISTORY&as-backfill=on");
		driver.manage().window().maximize();
		int count =1, sum = 0;
		do
		{
			List<WebElement> lits = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			count++;
			sum = sum + lits.size();
		}
	
	}

}
