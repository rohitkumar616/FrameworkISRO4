package hardcodedTestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RemoveChromeAutomationMsg {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);
		driver.quit();
		
		System.out.println("hi");

	}

}
