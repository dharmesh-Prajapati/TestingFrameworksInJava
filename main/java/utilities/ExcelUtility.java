package utilities;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	XSSFWorkbook xsfWb;
	XSSFSheet xsfSheet;

	
	public ExcelUtility(String excelFile, String sheetName) {
		 try {
			this.xsfWb= new XSSFWorkbook(excelFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 this.xsfSheet = xsfWb.getSheet(sheetName);
	}


	public  int getRowCount() {
		int rowCount = xsfSheet.getPhysicalNumberOfRows();
		//System.out.println("Physical Number of Rows are "+rowCount);
		return rowCount;
	}

	public int getColCount() {
		int colCount = xsfSheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("Physical Number of Collumns are "+colCount);
		return colCount;
	}


	public  String getCellStringData(int rowNum, int colNum)  {
		String cellData = xsfSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println("Cell String data is "+ cellData);
		return cellData;
	}

	public  ArrayList<Object[]> getTestdata () {
		ArrayList<Object[]> myData = new ArrayList<Object []>();
		int rowNum = getRowCount();


		for(int i = 2 ; i < rowNum; i++) {

			String httpRequestType = getCellStringData( i, 0);
			String restapiLink = getCellStringData( i, 1);

			Object [] objArr = {httpRequestType, restapiLink};
			myData.add(objArr);

		}

		return myData;
	}

}
