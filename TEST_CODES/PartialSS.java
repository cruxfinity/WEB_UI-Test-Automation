package test.codes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class PartialSS {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement name=driver.findElement(By.cssSelector("input[name='name']:nth-child(2)"));
        name.sendKeys("hello world");
        File src=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/home/abinash/Downloads/ss.png"));
        driver.quit();
    }
}
