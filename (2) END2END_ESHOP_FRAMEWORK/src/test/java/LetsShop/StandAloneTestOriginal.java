package LetsShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTestOriginal {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/client");

        driver.findElement(By.id("userEmail")).sendKeys("abinash@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Abinash@2506");
        driver.findElement(By.id("login")).click();

        String productName="ZARA COAT 3";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));


        List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

       List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));
       boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
        Assert.assertTrue(match);

        driver.findElement(By.cssSelector(".subtotal button")).click();
        Actions a=new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        driver.findElement(By.cssSelector(".ta-results button:last-child")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();

       String confirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
       Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));

        driver.quit();

    }
}
