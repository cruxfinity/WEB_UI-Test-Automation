package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CdpGeoLocation {
    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        DevTools devTools=driver.getDevTools();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.manage().window().maximize();
       devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(40), Optional.of(3), Optional.of(1)));
        //Map<String , Object> coordinates=new HashMap<>();
//        driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).getFirst().click();
        String title= driver.findElement(By.cssSelector(".default-ltr-cache-jmnaey")).getText();
        System.out.println(title);
        driver.quit();
    }
}
