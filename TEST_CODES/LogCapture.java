package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class LogCapture {
    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.xpath("//a[text()='Shop']")).click();
        LogEntries entry= driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs= entry.getAll();
        for (LogEntry e:logs)
        {
            System.out.println(e.getMessage());
        }
        driver.quit();
    }
}
