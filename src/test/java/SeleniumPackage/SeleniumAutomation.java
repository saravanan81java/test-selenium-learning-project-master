package SeleniumPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAutomation {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/arunarumugam/eclipse-workspace/Com.Cucu.Selenium.POM/ExeDriver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
        try {
		
		// driver = new ChromeDriver();
		
		driver.navigate().to("https://www.google.com");
		//driver.navigate().back();
		//driver.navigate().forward();
		
		System.out.println(driver.getWindowHandle());
		
		
		assert driver.getWindowHandles().size() == 2;
	
	 //  int height = driver.manage().window().getSize().getHeight();
		
	
	 /*  
	   Dimension size = driver.manage().window().getSize();
	   int width = size.getWidth();
	   int height = size.getHeight();
	   
	   System.out.println("Width: "+width);
	   System.out.println("Height: "+height);
	   
	   Dimension dm = new Dimension(700,500);
	   driver.manage().window().setSize(dm);
	   */
	   
	   Point position = driver.manage().window().getPosition();
	   int x1 = position.getX();
	   int y1 = position.getY();
	   
	   System.out.println("X coordinates :"+x1);
	    System.out.println("Y Coordinates :"+y1);
	    
	    //driver.manage().window().maximize();
        driver.manage().window().fullscreen();
	    
	   // driver.manage().window().setPosition(new Point(20, 20));
	    
	    
	    //driver.manage().window().setSize(new Dimension(750, 300));
	   // int REheight=driver.manage().window().getPosition().getX();
	    //int REwidth=driver.manage().window().getPosition().getY();
	    //System.out.println("RESIZED height :"+REheight);
	    //System.out.println("Resized width  :"+REwidth);
	    
	  //  driver.manage().window().setPosition(new Point(2, 5));
	    File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrfile, new File("/Users/arunarumugam/Desktop/Screenshot/Arun.png"));
		//FluentWait<WebDriver> wait = null;
		
		//WebElement wait = new WebDriverWait(driver,3)
				//.until(ExpectedConditions.visibilityOfElementLocated(By.name("i")));
		//WebElement wb=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q"));
		driver.findElement(By.name("q")).sendKeys("UK"+Keys.ENTER);
		 Actions actionProvider = new Actions(driver);
		  Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
		System.out.println("Dreams to reality");
		
		
		/*
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("host:port");
		ChromeOptions options = new ChromeOptions();
		options.setCapability("proxy", proxy);
		
		WebDriver driver1 = new ChromeDriver(options);
		*/
		//Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
        }finally {
		
	  driver.quit();
		
        }
	}



}
