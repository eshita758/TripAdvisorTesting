package holidayHomes;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
		//Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.navigate().to("https://www.tripadvisor.in/");
		//driver.get("https://www.tripadvisor.in/");
		driver.manage().window().maximize();
		//Thread.sleep(10000);
		WebElement searchBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Places to go')]")));
		searchBtn.click();
		searchBtn.sendKeys("Nairobi");
		Actions act=new Actions(driver);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Holiday Homes"))).click();
		
		act.scrollByAmount(0, 300).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Guests']"))).click();
		By addBtn=By.xpath("//button[@data-automation=\"increaseAdults\"]");
		
		wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
		driver.findElement(addBtn).click();
		
		driver.findElement(By.xpath("//button[@data-automation='applyGuests']")).click();
		
		driver.findElement(By.xpath("//div[@class='jwRbK VCdjs']//button[1]")).click();
		for(int i=0;i<4;i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Next month']//*[name()='svg']"))).click();
		}
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='3 December 2025']"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='8 December 2025']"))).click();
		//sorting
		driver.findElement(By.xpath("//span[normalize-space()='Tripadvisor Sort']")).click();
		driver.findElement(By.xpath("//span[text()='# of reviews']")).click();
		driver.findElement(By.xpath("(//button[@class='UikNM _G B- _S _W _T c G_ wSSLS wnNQG LbPqG'])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Elevator/Lift access')]")).click();
		driver.findElement(By.xpath("//span[text()='Apply']")).click();
		Thread.sleep(4000);
		
		List<WebElement> hotelNames=driver.findElements(By.tagName("h2"));
		List<WebElement> perDayCharge=driver.findElements(By.xpath("//*[@class=\"iCUJC b\"]"));
		List<WebElement> totalCharge=driver.findElements(By.xpath("//*[@class=\"MvXmI\"]"));
		
		for(int i=0;i<3;i++) {
			System.out.println(hotelNames.get(i).getText());
			System.out.println(perDayCharge.get(i).getText());
			String[] ch=totalCharge.get(i).getText().split("/");
			System.out.println(ch[0]);
		}
		Thread.sleep(2000);
		driver.navigate().to("https://www.tripadvisor.in/Cruises");
		WebElement searchBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Jgukv _T Gi']//div[1]//div[1]//button[1]")));
//		searchBox.sendKeys("Adventure Canada");
		searchBox.click();
		
//		Adventure Canada
		driver.findElement(By.xpath("//span[contains(text(),'American Cruise Lines')]")).click();
		driver.findElement(By.xpath("(//button[@class=\"EVXMG _G f k Q2 u _u w Cq Ra _S wSSLS mrjkJ oweiU\"])[2]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'American Star')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Search')]"))).click();
		//driver.quit();
		List<String> windowId=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowId.get(1));
		List<WebElement> languages=driver.findElements(By.xpath("(//*[@class='LojWi w S4'])[3]//li"));
		for(int i=1;i<languages.size();i++) {
			System.out.println(languages.get(i).getText());
		}
		String passenger=driver.findElement(By.xpath("//*[contains(text(),'Passengers:')]")).getText();
		System.out.println(passenger);
		String launched=driver.findElement(By.xpath("//*[contains(text(),'Launched:')]")).getText();
		System.out.println(launched);
	}

}
