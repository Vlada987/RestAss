package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelGet {
	
public FileInputStream fi;
public XSSFWorkbook workbook;
public XSSFSheet sheet;
public XSSFRow row;
public XSSFCell cell;
String path;

public excelGet(String path) {
	this.path=path;
}
public int getRowCount(String sheetName) throws IOException  {
	
fi=new FileInputStream(path);
workbook=new XSSFWorkbook(fi);
sheet=workbook.getSheet(sheetName);
int rowCount=sheet.getLastRowNum();
workbook.close();
fi.close();
return rowCount;
}

public int getCellCount(String sheetName,int rownum) throws IOException {
	
fi=new FileInputStream(path);
workbook=new XSSFWorkbook(fi);
sheet=workbook.getSheet(sheetName);	
row=sheet.getRow(rownum);
int cellCount=row.getLastCellNum();
workbook.close();
fi.close();
return cellCount;	
	
}

public String getCelldata(String sheetName,int rownum,int colnum) throws IOException {
	
fi=new FileInputStream(path);
workbook=new XSSFWorkbook(fi);
sheet=workbook.getSheet(sheetName);	
row=sheet.getRow(rownum);	
cell=row.getCell(colnum);
DataFormatter dataF=new DataFormatter();
String data = dataF.formatCellValue(cell);
workbook.close();
fi.close();
return data;

}



}
