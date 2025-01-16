package test.codes;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SslCertification {
    public static void main(String[] args) {
        ChromeOptions option=new ChromeOptions();
        option.setAcceptInsecureCerts(true);
//        Proxy proxy=new Proxy();
//        proxy.setHttpProxy("");
//        option.setCapability("proxy",proxy);
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
