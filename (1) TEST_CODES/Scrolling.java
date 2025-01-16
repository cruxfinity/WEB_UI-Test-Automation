package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Scrolling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        //Thread.sleep(2000);
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
        //Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for (WebElement e : elements) {
            sum += Integer.parseInt(e.getText());
        }
        System.out.println("The sum of table data " + sum);
        String total=driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
        int totalAmount=Integer.parseInt(total);
        Assert.assertEquals(sum,totalAmount);
       driver.quit();

    }
}
