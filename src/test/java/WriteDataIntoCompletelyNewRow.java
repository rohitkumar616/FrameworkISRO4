import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoCompletelyNewRow {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/java/resources/Acti.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		
		//Creates new row by deleting older values
		Row r = sh.createRow(4);
		//Creates new cell by deleting older data into cell
		Cell c = r.createCell(0);
		//writes data into cell
		c.setCellValue("Hii");
		
		//Saves data into excel
		FileOutputStream fos = new FileOutputStream("./src/test/java/resources/Acti.xlsx");
		wb.write(fos);
		
		wb.close();
		
	}

}
