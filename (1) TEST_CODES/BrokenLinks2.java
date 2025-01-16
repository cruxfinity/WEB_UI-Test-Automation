package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks2 {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement>links=driver.findElements(By.cssSelector(".gf-li a"));
        SoftAssert sa=new SoftAssert();
        for (WebElement link:links)
        {
            String url=link.getAttribute("href");
            HttpURLConnection con=(HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            int responseCode=con.getResponseCode();
            sa.assertTrue(responseCode<400,"broken link "+link.getText()+" status code "+responseCode);
        }
        sa.assertAll();
        driver.quit();
    }
}