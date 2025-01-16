package test.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.Request;
import org.openqa.selenium.devtools.v126.network.model.Response;

import java.time.Duration;
import java.util.Optional;

public class NetworkLog {
    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        DevTools devTools=driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        devTools.addListener(Network.requestWillBeSent(),requestWillBeSent ->
        {
           Request req= requestWillBeSent.getRequest();
            System.out.println(req.getUrl());
        });



        devTools.addListener(Network.responseReceived(),response->{
            Response res=response.getResponse();
            System.out.println(res.getUrl());
            System.out.println(res.getStatus());
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.name("Library")).click();
        driver.quit();
    }
}
