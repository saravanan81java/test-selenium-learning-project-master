package SeleniumPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tableautomate {
	static WebDriver driver ;
	public static void main(String[] args) {
		
		try {
		System.setProperty("webdriver.chrome.driver","/Users/arunarumugam/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		 List<String> ls = new ArrayList<String>();
		driver.manage().window().maximize();
		for(int i=1;i<=4;i++) {
			String selector = "div > div:nth-child(1) > table > tbody > tr:nth-child("+i+") > th";
			//TableValues = driver.findElements(By.cssSelector("div > div:nth-child(1) > table > tbody > tr:nth-child("+i+") > th"));                                                                   
			String s= driver.findElement(By.cssSelector(selector)).getText();                                                                     
			System.out.println("div > div:nth-child(1) > table > tbody > tr:nth-child("+i+") > th");
		    ls.add(s);   
		}
		
		System.out.println("List Size: "+ls.size());
		
		String footerValue=driver.findElement(By.cssSelector(" div > div:nth-child(1) > table > tfoot > tr > td")).getText();
		String FooterValue = footerValue.substring(0, 1);
		System.out.println("Footer Value: "+footerValue.substring(0, 1));
		
		if(FooterValue.equalsIgnoreCase("4")) {
			System.out.println("No. of cloumn value matched with Total");
		}
		}finally {
			driver.quit();
		}
		
	
	}

}
