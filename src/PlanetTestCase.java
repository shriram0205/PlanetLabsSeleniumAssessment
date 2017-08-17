import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlanetTestCase {
	
	 
	 public void testcase() throws InterruptedException{
		 System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
		 //WebDriver driver = new FirefoxDriver();
		 WebDriver driver = new FirefoxDriver();
			//Creating the JavascriptExecutor interface object by Type casting	
			JavascriptExecutor js = (JavascriptExecutor)driver;		
    		
	        //Launching the Site.		
	        driver.get("https://www.planet.com/");			
				
	       Thread.sleep(2000L);
	       //finding the element with the text "Start Exploring"
	       WebElement button= driver.findElement(By.cssSelector(".pl-button.pl-secondary"));	
	       js.executeScript("arguments[0].click();", button); 
	       Thread.sleep(2000L);
	     //finding the element with the text "Getting Started"
	       WebElement button1= driver.findElement(By.cssSelector(".pl-button.pl-primary"));
	       js.executeScript("arguments[0].click();", button1); 
	     //finding the element with the text "3 month"
	       WebElement button2= driver.findElements(By.cssSelector(".interval")).get(0);
	       js.executeScript("arguments[0].click();", button2); 
	        Thread.sleep(2000L);
	      //finding the search box and sending the keys San Francisco CA"
	        driver.findElement(By.name("search")).sendKeys("San Francisco, CA");
	       (new WebDriverWait(driver, 10))
	                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pl-search-input-suggestion")));
	        
	        driver.findElement(By.xpath(".//*[@id='pl-root']/div/div[2]/div[2]/div[2]/div[1]")).click();
	        Thread.sleep(2000L);
	        //Hiding the two elements to display only the first three results
	        WebElement dropDownElement1 = driver.findElement(By.xpath(".//*[@id='pl-root']/div/div[2]/div[2]/div[1]/div[2]/div/div/div[4]"));
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", dropDownElement1);
	        WebElement dropDownElement2 = driver.findElement(By.xpath(".//*[@id='pl-root']/div/div[2]/div[2]/div[1]/div[2]/div/div/div[5]"));
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", dropDownElement2);
	       //Storing the entire search result in a list
	        List<WebElement> findElements1 = driver.findElements(By.cssSelector(".pl-sidebar-list-item"));
	        Thread.sleep(2000L);
	        //Stroing the result of the sublist to display the first three results on the console
	        List<WebElement> list = findElements1.subList(0, 3);
	        System.out.println(list.size());
	        for(WebElement element:list){
	        	System.out.println(element.getText());
	        	}
	        driver.close();
	    }   
	 
	
	public static void main(String[] args) throws InterruptedException {
		 
		PlanetTestCase test = new PlanetTestCase();
         test.testcase();
	}

}
