import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScriptForActitime {

	public static void main(String[] args) throws InterruptedException, IOException {
			FileInputStream fis =new FileInputStream("./src/test/java/resources/commanData.properties");
			Properties p = new Properties();
			p.load(fis);
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(p.getProperty("url1"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(p.getProperty("timeouts"))));
			
			driver.findElement(By.id("username")).sendKeys(p.getProperty("user"));
			driver.findElement(By.name("pwd")).sendKeys("password");
			driver.findElement(By.id("loginButton")).click();
			Thread.sleep(3000);
			if(driver.getTitle().contains("Enter"))
				System.out.println("Pass");
			else
				System.out.println("Fail");
			
			driver.quit();
			

	}

}
