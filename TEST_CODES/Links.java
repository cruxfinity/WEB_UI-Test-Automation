package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class LinkCount {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println("Number of links in footer section =" + footerDriver.findElements(By.tagName("a")).size());
        WebElement columnDriver = footerDriver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
        System.out.println("Links present in the 1st column " + columnDriver.findElements(By.tagName("a")).size());
        String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {

            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
        }
        Set<String> windowId = driver.getWindowHandles();
        for (String string : windowId) {
            driver.switchTo().window(string);
            System.out.println(driver.getTitle());
        }


        driver.quit();

    }
}
