package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class GreenKart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> products = driver.findElements(By.cssSelector("h4,product-name"));
        String[] names = {"Cucumber", "Brocolli", "Beetroot"};
        List<String> items = Arrays.asList(names);

        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText().split("-")[0].trim();
            if (items.contains(name)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

            }
        }

        driver.quit();
    }
}
