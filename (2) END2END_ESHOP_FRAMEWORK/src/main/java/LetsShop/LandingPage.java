package LetsShop;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //WebElement userEmail=driver.findElement(By.id("userEmail"));

    //Page-factory
    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement password;

    @FindBy(id="login")
    WebElement submit;

    public ProductCatalogue loginApplication(String email, String pass){
        userEmail.sendKeys(email);
        password.sendKeys(pass);
        submit.click();
        ProductCatalogue productCatalogue=new ProductCatalogue(driver);
        return productCatalogue;
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

}
