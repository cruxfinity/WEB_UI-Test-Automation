package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class InvokeMultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String>windowId=driver.getWindowHandles();
        Iterator<String>itr=windowId.iterator();
        String parentId=itr.next();
        String childId=itr.next();
        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com/");
        String course=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
        driver.switchTo().window(parentId);
        driver.findElement(By.cssSelector("input[name='name']:nth-child(2)")).sendKeys(course);
        Thread.sleep(2000);
        driver.quit();
    }
}
