package holidayHomes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinearCodeProject {
         public static void main(String[] args) throws InterruptedException {
	
		// TODO Auto-generated method stub
		
		  WebDriver driver=new ChromeDriver();;
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			
		
		  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		   driver.get("https://www.tripadvisor.in/Cruises");
		   driver.manage().window().maximize();
		  
		
			WebElement searchBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Jgukv _T Gi']//div[1]//div[1]//button[1]")));
//			searchBox.sendKeys("Adventure Canada");
			searchBox.click();
			
//			Adventure Canada
			driver.findElement(By.xpath("//*[@id='menu-item-17391493']/span/div/span/span")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Search')]"))).click();
			Thread.sleep(3000);
			
			
		
         }
}
