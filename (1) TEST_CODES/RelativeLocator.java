package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import java.time.Duration;

public class RelativeLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditbox= driver.findElement(By.cssSelector("input[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText());
        WebElement dob=driver.findElement(By.cssSelector("label[for='dateofBirth']"));

        WebElement icecream= driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(icecream)).click();

        WebElement radio = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
        driver.findElement(with(By.tagName("input")).below(dob)).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
