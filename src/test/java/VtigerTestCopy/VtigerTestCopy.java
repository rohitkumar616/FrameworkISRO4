package VtigerTestCopy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;

public class VtigerTestCopy {
	public static void main(String[] args) {
		PropertiesFileUtility property = new PropertiesFileUtility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility javaUtil = new JavaUtility();
		WebDriverUtility web = new WebDriverUtility();

		property.propertyFileInitialization(IConstantPath.PROPERTY_FILEPATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		long time = Long.parseLong(property.fetchProperty("timeouts"));
		WebDriver driver = web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), time);

		String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();
		if (title.contains("vtiger"))
			System.out.println("Login Page Displayed");
		else
			System.out.println("Login Page is Not Displayed");

		driver.findElement(By.name("user_name")).sendKeys(property.fetchProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(property.fetchProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		String homePageText = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		if (homePageText.contains("Home"))
			System.out.println("Home Page is Displayed");
		else
			System.out.println("Home Page is Not Displayed");
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		String createOrg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (createOrg.contains("Creating New Organization"))
			System.out.println("Pass");
		else
			System.out.println("Fail");

	}

}
