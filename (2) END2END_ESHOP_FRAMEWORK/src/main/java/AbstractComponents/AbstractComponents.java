package AbstractComponents;

import LetsShop.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {
    WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;
    @FindBy(css="button[routerlink$='/dashboard/myorders']")
    WebElement orderHeader;


    public void waitForElementToAppear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

    }
    public void waitForElementToDisappear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    public CartPage goToCartPage()
    {
        cartHeader.click();
        CartPage cartPage=new CartPage(driver);
        return cartPage;
    }
    public OrderPage goToOrderPage(){
        orderHeader.click();
        OrderPage orderPage=new OrderPage(driver);
        return orderPage;
    }
}