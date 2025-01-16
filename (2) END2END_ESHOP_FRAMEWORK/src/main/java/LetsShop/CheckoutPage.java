package LetsShop;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponents {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".action__submit")
    WebElement submit;

    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    @FindBy(css = ".ta-results button:last-child")
    WebElement countrySelect;

    public void selectCountry(String countryName) {
        Actions a = new Actions(driver);
        a.sendKeys(country, "india").build().perform();
        countrySelect.click();
    }
    public ConfirmationPage submitOrder(){
        submit.click();
       return new ConfirmationPage(driver);
    }

}
