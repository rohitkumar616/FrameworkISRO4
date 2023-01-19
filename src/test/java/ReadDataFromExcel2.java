import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// Step 1 : convert physical file to java readable object
		FileInputStream fis = new FileInputStream("./src/test/java/resources/Acti.xlsx");

		// Step 2 : Open the excel workbook
		// Import Workbook from org.apache.poi.ss.usermodel
		// The below statement throws EncryptedDocumentException and IOException

		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		System.out.println(data);

		// close Workbook
		wb.close();

	}

}
