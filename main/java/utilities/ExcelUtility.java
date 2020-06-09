package utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	XSSFWorkbook xsfWb;
	XSSFSheet xsfSheet;

	/*
	 * ExcelUtility with excel path and sheetname creates and instance of XSSFWorkbook and XSSFSheet
	 * as the object of ExcelUtility is created
	 */
	public ExcelUtility(String excelFile, String sheetName) {
		 try {
			this.xsfWb= new XSSFWorkbook(excelFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 this.xsfSheet = xsfWb.getSheet(sheetName);
	}


	/*
	 * return the last row number in excel sheet
	 */
	public  int getRowCount() {
		int rowCount = xsfSheet.getPhysicalNumberOfRows();
		//System.out.println("Physical Number of Rows are "+rowCount);
		return rowCount;
	}
	

	/*
	 * return the last column number in excel sheet
	 */
	public int getColCount() {
		int colCount = xsfSheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("Physical Number of Collumns are "+colCount);
		return colCount;
	}


	/*
	 * returns the cell value of given row number and column number.
	 */
	public  String getCellStringData(int rowNum, int colNum)  {
		String cellData = xsfSheet.getRow(rowNum).getCell(colNum).getStringCellValue().toString();
		//System.out.println("Cell String data is "+ cellData);
		return cellData;
	}

	/*
	 * returns an arrayList  of array of Object to data provider
	 */
	public  ArrayList<Object[]> getTestdata () {
		ArrayList<Object[]> myData = new ArrayList<Object []>();
		int rowNum = getRowCount();


		for(int i = 1 ; i < rowNum; i++) {

			String httpRequestType = getCellStringData( i, 1);
			String restapiLink = getCellStringData( i, 2);

			Object [] objArr = {httpRequestType, restapiLink};
			myData.add(objArr);
		}
		return myData;
	}

	/*
	 * Accepts integer as Test Case Row data fromExcel
	 * First row as Key 
	 * TestcaseNum as value
	 * return HasMap
	 * example "Browser", "UserId", "Password" from excel first row will be Key
	 * for Test case 2: value will be "firefox" so on
	 * 
	 */
	public  Map<String, String> exlMapData (int exltestCaseNum){
		Map<String, String> mapData = new HashMap<String, String>();
		int colNum = getColCount();
		for(int i = 1 ; i < colNum; i++) {

			mapData.put(getCellStringData(0, i), getCellStringData( exltestCaseNum, i));

		}
		return mapData;
	}
}
