package test.codes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class CdpCommandTest {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        DevTools devTools=driver.getDevTools();
        devTools.createSession();
        Map<String,Object> deviceMetrics=new HashMap();
        deviceMetrics.put("width",600);
        deviceMetrics.put("height",1000);
        deviceMetrics.put("deviceScaleFactor",50);
        deviceMetrics.put("mobile",true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMetrics);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        Thread.sleep(2000);
        driver.quit();
    }
}
