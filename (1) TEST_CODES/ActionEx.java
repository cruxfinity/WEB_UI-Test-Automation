package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionEx {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
        a.moveToElement(driver.findElement(By.xpath("//div/input[@aria-label='Search Amazon.in']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(move).contextClick().build().perform();
        Thread.sleep(2000);
        driver.quit();
    }
}
