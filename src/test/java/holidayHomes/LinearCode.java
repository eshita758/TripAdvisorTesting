package holidayHomes;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinearCode {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://www.tripadvisor.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement searchBtn=driver.findElement(By.xpath("//input[contains(@placeholder,'Places to go')]"));
		searchBtn.click();
		searchBtn.sendKeys("Nairobi");
		Actions act=new Actions(driver);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Holiday Homes")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Guests']"))).click();
		By addBtn=By.xpath("//button[@data-automation=\"increaseAdults\"]");
		wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
		driver.findElement(addBtn).click();
		driver.findElement(By.xpath("//button[@data-automation=\"applyGuests\"]")).click();
		act.scrollByAmount(0, 300).perform();
		driver.findElement(By.xpath("//div[@class='jwRbK VCdjs']//button[1]")).click();
		for(int i=0;i<4;i++) {
			driver.findElement(By.xpath("//button[@aria-label='Next month']//*[name()='svg']")).click();
		}
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[@aria-label='3 December 2025']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='8 December 2025']")).click();
		//sorting
		driver.findElement(By.xpath("//span[normalize-space()='Tripadvisor Sort']")).click();
		driver.findElement(By.xpath("//span[text()='# of reviews']")).click();
		driver.findElement(By.xpath("(//span[@class='biGQs _P XWJSj Wb'][normalize-space()='Show all'])[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Elevator/Lift access')]")).click();
		driver.findElement(By.xpath("//span[text()='Apply']")).click();
		//driver.quit();
	}

}
