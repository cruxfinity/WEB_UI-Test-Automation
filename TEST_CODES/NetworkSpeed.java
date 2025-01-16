package test.codes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.ConnectionType;

import java.util.Optional;

public class NetworkSpeed {
    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        DevTools devTools=driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false,3000,20000,10000, Optional.of(ConnectionType.ETHERNET),Optional.empty(),Optional.empty(),Optional.empty()));
        long startTime=System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
       long endTime=System.currentTimeMillis();
        driver.quit();
        System.out.println("Connection speed in milliseconds = "+(endTime-startTime));
    }
}
