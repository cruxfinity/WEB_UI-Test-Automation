package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandlex {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows= driver.getWindowHandles();
        Iterator<String>itr=windows.iterator();
        String parentId=itr.next();
        String childId=itr.next();
        driver.switchTo().window(childId);
        String emailid=driver.findElement(By.cssSelector("a[href='mailto:mentor@rahulshettyacademy.com']")).getText();
        System.out.println(emailid);
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailid);
        Thread.sleep(2000);
        driver.quit();
    }
}
