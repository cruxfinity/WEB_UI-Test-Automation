package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Calendar2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String month = "6", date = "15", year = "2027";
        driver.findElement(By.cssSelector(".react-date-picker__calendar-button.react-date-picker__button")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElement(By.xpath("//div[@class='react-calendar__year-view__months']/child::button["+month+"]")).click();
        driver.findElement(By.xpath("//abbr[text()='15']")).click();
        
        Thread.sleep(2000);
        driver.quit();
    }
}
