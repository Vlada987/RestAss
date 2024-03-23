package utility;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProvide {
	
String path=System.getProperty("user.dir")+"\\Book 4.xlsx";
String path2=System.getProperty("user.dir")+"\\Book 6.xlsx";
excelGet xl=new excelGet(path);
excelGet xl2=new excelGet(path2); 

@DataProvider(name="allData")
public String[][] getUnandPass() throws IOException {
	
int rowCount=xl.getRowCount("Sheet1");
int cellCount=xl.getCellCount("Sheet1", 1);
String [][] data = new String [rowCount][cellCount];
for(int a=1;a<=rowCount;a++) {
	for(int b=0;b<cellCount;b++) {
	data[a-1][b]=xl.getCelldata("Sheet1", a, b);			
}
}
return data;	
}	
	

@DataProvider (name="userNames")
public String[] getUserNames() throws IOException {

	
int rowCount= xl.getRowCount("Sheet1");
String [] userNames=new String[rowCount];
for(int a=1;a<=rowCount;a++) {
userNames[a-1]=xl.getCelldata("Sheet1",a , 0);
}
return userNames;
	
}

@DataProvider(name="CreateUserAuth")
public String [][] getData2 () throws IOException{
	
int rowCount=xl2.getRowCount("Sheet1");
int colCount=xl2.getCellCount("Sheet1", 1);
String[][]data=new String [rowCount][colCount];
for(int a=1;a<=rowCount;a++) {
	for(int b=0;b<colCount;b++) {
	data[a-1][b]=xl2.getCelldata("Sheet1", a, b);		
	}
}
return data;	
	

}







}
