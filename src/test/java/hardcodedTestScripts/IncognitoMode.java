package hardcodedTestScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoMode {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.yatra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(3000);
		driver.quit();
		System.out.println("hi");

	}

}
