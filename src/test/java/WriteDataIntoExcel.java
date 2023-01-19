import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/java/resources/Acti.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(3);
		//Creates new cell by deleting older data in the cell
		Cell c = r.createCell(1);
		//Writes data into the cell
		c.setCellValue("Hi");
		
		//Saves data into excel
		FileOutputStream fos = new FileOutputStream("./src/test/java/resources/Acti.xlsx");
		wb.write(fos);
		wb.close();
		

	}

}
