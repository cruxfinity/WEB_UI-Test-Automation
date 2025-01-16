package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Framesx {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://jqueryui.com/droppable/");
        WebElement element = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(element);
        driver.findElement(By.id("draggable")).click();

        Actions a=new Actions(driver);
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement destination =driver.findElement(By.id("droppable"));
        a.dragAndDrop(source,destination).build().perform();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
