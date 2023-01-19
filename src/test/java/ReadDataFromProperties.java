import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromProperties {

	public static void main(String[] args) throws IOException {
		//Step 1: Convert physicalfile into java readable object
		FileInputStream fis = new FileInputStream("./src/test/java/resources/commanData.properties");
		
		//Step 2: Create an instance forProperties class
		//Properties class is available in java.util package
		Properties p =new Properties();
		
		//Step 3: Load all the key-value pairs to properties object
		p.load(fis); //IOException
		//java concept involved - Map interface - Hashtable
		
		//Step 4: Read Data
		String url = p.getProperty("url");
		long time = Long.parseLong(p.getProperty("timeouts"));
		
		System.out.println(url+"\t"+time);

	}

}
