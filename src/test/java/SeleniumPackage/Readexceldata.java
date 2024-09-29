package SeleniumPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Readexceldata {

	@Test
	public void readWriteExcel() throws IOException {
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFCell updateTestStatus = null;
		Boolean flag = false;
		WebDriver webDriver = null;
		HashMap map ;
		int j = 0;
		System.setProperty("webdriver.chrome.driver",
				"/Users/arunarumugam/eclipse-workspace/Com.Cucu.Selenium.POM/ExeDriver/chromedriver");

		try {
		    fis = new FileInputStream("/Users/arunarumugam/Desktop/Automation/URLValidation.xlsx");
			workbook = new XSSFWorkbook(fis);
			 sheet = workbook.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(0);
				 updateTestStatus = sheet.getRow(i).createCell(1);
				String testDataURL = cell.getStringCellValue();
				System.out.println("Tested url = " + testDataURL);
				webDriver = new ChromeDriver();
				webDriver.get(testDataURL);
				webDriver.manage().window().maximize();
				j=i;
				//map = new HashMap<String,String>();
				//map.put(testDataURL, value);
				//webDriver.findElement(By.cssSelector("button[class*='agree-button']")).click();
				// Thread.sleep(5000);
                /*
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement closeNewsLetterPopup = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ck-modal__close-btn")));
				if (closeNewsLetterPopup.isDisplayed()) {
					webDriver.findElement(By.cssSelector("button.ck-modal__close-btn")).click();
				}
				*/
				// Boolean spaFlag =
				// webDriver.findElement(By.cssSelector("__next")).isDisplayed();
				// Assert.assertTrue(webDriver.getPageSource().contains("__next"));
				
				//flag = webDriver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).isDisplayed();
				flag = webDriver.findElement(By.id("rk")).isDisplayed();
				//if (webDriver.findElement(By.id("__next")).isDisplayed()) {
				if(flag==true) {
					updateTestStatus = sheet.getRow(i).createCell(1);
					updateTestStatus.setCellValue("Page is SPA - Pass");
				} else {
					updateTestStatus = sheet.getRow(i).createCell(1);
					updateTestStatus.setCellValue("Page is WCS - Fail");
				}
				
				webDriver.quit();
			}
		/*	fis.close();
			FileOutputStream outputFile = new FileOutputStream(
					new File("src/test/resources/data/LiveContentTestData.xlsx"));
			workbook.write(outputFile);
			outputFile.close();
			System.out.println("Success !!!");
			*/

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
			webDriver.quit();
		}
		finally {
			
			if(flag==true) {
				updateTestStatus = sheet.getRow(j).createCell(1);
				updateTestStatus.setCellValue("Page is SPA - Pass");
				
			}else {
				updateTestStatus = sheet.getRow(j).createCell(1);
				updateTestStatus.setCellValue("Page is WCS - Fail");
			}
			
			fis.close();
			FileOutputStream outputFile = new FileOutputStream(
					new File("/Users/arunarumugam/Desktop/Automation/URLValidation.xlsx"));
			
			workbook.write(outputFile);
			outputFile.close();
			System.out.println("Success !!!");
			
		}

	}

}
