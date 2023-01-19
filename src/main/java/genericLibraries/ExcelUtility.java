package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private Workbook workbook;
	private DataFormatter df;
	private Sheet sheet;

	/**
	 * This method initializes excel workbook
	 * 
	 * @param path
	 */

	public void excelInitialization(String path) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to fetch single data from excel
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String readDatafromExcel(String sheetName, int rowNum, int cellNum) {
		df = new DataFormatter();
		sheet.getWorkbook().getSheet(sheetName);
		return df.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
	}
	public Map<String,String> readDataFromExcel(String expectedTestName, String sheetName) {
		sheet = workbook.getSheet(sheetName);
		Map<String,String> map = new HashMap<>();
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			if(df.formatCellValue(sheet.getRow(i).getCell(1)).contains(expectedTestName)) {
				for (int j = i; j < sheet.getLastRowNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(j).getCell(2));
					String value = df.formatCellValue(sheet.getRow(j).getCell(3));
					map.put(key, value);
					if (df.formatCellValue(sheet.getRow(i).getCell(2)).equals("####"))
						break;					
				}
				break;
			}
		}
		return map;
	}

	/**
	 * This Method is used to write data in to excel.
	 * 
	 * @param data
	 * @param cellNum
	 * @param rownum
	 * @param path
	 * @param sheetName 
	 */

	public void setDataToExcel(String data, int cellNum, int rownum, String path, String sheetName) {
		sheet.getWorkbook().getSheet(sheetName);
		Cell cell = sheet.getRow(rownum).createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
