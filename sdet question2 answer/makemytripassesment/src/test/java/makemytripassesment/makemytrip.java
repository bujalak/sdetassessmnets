package makemytripassesment;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makemytrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.makemytrip.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement roundTripRadio = wait.until(ExpectedConditions.elementToBeClickable(By.id("round_trip_button1")));
        roundTripRadio.click();
        
        // Enter From and To locations
        WebElement fromLocation = driver.findElement(By.id("fromCity"));
        WebElement toLocation = driver.findElement(By.id("toCity"));
        
        fromLocation.sendKeys("HYD");
        toLocation.sendKeys("MAA");
        
        selectDate(driver, "DEPARTURE", "20"); 

        // Select return date
        selectDate(driver, "RETURN", "25"); 

	}
   

    private static void selectDate(WebDriver driver, String type, String day) {
      
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement datePicker = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datePickerContainer")));

       
        java.util.List<WebElement> cells =  datePicker.findElements(By.tagName("td"));

        for (WebElement cell : cells) {
            if (cell.getText().equals(day)) {
                cell.click();
                break;
            }
        }
    

    
    WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
    searchButton.click();
    

    driver.quit();


	}
}


