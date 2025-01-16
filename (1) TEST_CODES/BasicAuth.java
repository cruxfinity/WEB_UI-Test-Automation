package test.codes;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URI;
import java.util.function.Predicate;

public class BasicAuth {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        Predicate<URI> uriPredicate=uri -> uri.getHost().contains("httpbin.org");
       ((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo","bar"));
        driver.get("http://httpbin.org/basic-auth/foo/bar");
        Thread.sleep(2000);
        driver.quit();
    }
}
