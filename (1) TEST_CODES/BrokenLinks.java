package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
        HttpURLConnection con=(HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("HEAD");
        con.connect();
        int responseCode=con.getResponseCode();
        System.out.println(responseCode);
        driver.quit();
    }
}
