package SeleniumPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Readcell {

	public static void main(String[] args) throws IOException {
		FileInputStream file = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFCell cell1 = null;

		System.setProperty("webdriver.chrome.driver",
				"/Users/arunarumugam/eclipse-workspace/Com.Cucu.Selenium.POM/ExeDriver/chromedriver");

		try {
			 file = new FileInputStream("/Users/arunarumugam/Desktop/Automation/URLValidation.xlsx");
			 workbook = new XSSFWorkbook(file);

			 sheet = workbook.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(0);
				String URLvalue = cell.getStringCellValue();
				System.out.println(cell.getStringCellValue());
				cell1 = sheet.getRow(i).createCell(1);

				WebDriver driver = new ChromeDriver();
				driver.get(URLvalue);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.id("value")).click();
				

				driver.quit();
				

			}
		/*	file.close();

			FileOutputStream outFile = new FileOutputStream(
					new File("/Users/arunarumugam/Desktop/Automation/URLValidation.xlsx"));
			workbook.write(outFile);
			outFile.close();

			System.out.println("Success");
			*/

		} catch (Exception e) {

		}finally {
			
			
			cell1.setCellValue("pass");
			
			file.close();

			FileOutputStream outFile = new FileOutputStream(
					new File("/Users/arunarumugam/Desktop/Automation/URLValidation.xlsx"));
			workbook.write(outFile);
			outFile.close();

			System.out.println("Success");
			
		}

	}

}
