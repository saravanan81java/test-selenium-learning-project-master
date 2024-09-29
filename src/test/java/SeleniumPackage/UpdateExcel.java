package SeleniumPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//latest code
public class UpdateExcel {

	public static void main(String[] args) throws IOException {
	    int i = 0;
	    HashMap<Integer, String> map = new  HashMap<Integer, String>();
		FileInputStream file = new FileInputStream("/Users/arunarumugam/Desktop/Automation/URLValidation.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		 Iterator < Row > rowIterator = sheet.iterator();
		    while (rowIterator.hasNext()) {
		        Row row = rowIterator.next();

		        //For each row, iterate through each columns
		        Iterator < Cell > cellIterator = row.cellIterator();
		        while (cellIterator.hasNext()) {

		            Cell cell = cellIterator.next();
		            
		            if(cell.getStringCellValue().contains("https")) {
		            
		            String URL = cell.getStringCellValue();
		      
		            map.put(++i, URL);
		          
		            }          
		        }
		    }
		        
		    file.close();
		    workbook.close();
		    
		    
		    
		    for(Map.Entry<Integer, String> entry: map.entrySet()) {
		    	
		    	  Integer key = entry.getKey();
		    	  System.out.println("Value of Key: "+key);
		    	  String value = entry.getValue();
		    	  System.out.println("Value of URL: "+value);
		    	  
		    	  
		    	  
		    	
		    }
		
	}

}
