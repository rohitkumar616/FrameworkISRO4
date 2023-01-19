import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDatatoPropertiesFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/java/resources/Acti.xlsx");
		Properties p = new Properties();
		p.load(fis);
		
		//Write data into properties file
		p.put("username","Srivalli");
		
		//Save data in properties file
		FileOutputStream fos = new FileOutputStream("./src/test/java/resources/Acti.xlsx");
		p.store(fos,"Username Modified");
		
		System.out.println("hi");

	}

}
