package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class accPage {
    private static WebDriver driver;
    private By men = new By.ById("ui-id-5");
    private By tops = new By.ById("ui-id-17");
    private By jacket = new By.ById("ui-id-19");

    private By clickCartBtn = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]");
    private By checkoutBtn = new By.ByXPath("//*[@id=\"top-cart-btn-checkout\"]");



    public accPage(WebDriver driver) {
        this.driver = driver;
    }
    // set men
    public void setMen(){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(men));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(men)).perform();
    }
    // set tops
    public void setTops(){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(tops));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(tops)).perform();
    }
    // set jacket
    public productPage setJacket(){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(jacket));
        Actions action = new Actions(driver);
        action.click(driver.findElement(jacket)).perform();
        return new productPage(driver);
    }
    //Click Cart
    public void clickCart() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOfElementLocated(clickCartBtn));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(clickCartBtn)).click().perform();
    }
    //Click checkout
    public checkoutPage clickCheckout() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(checkoutBtn)).click().perform();
        return new checkoutPage(driver);
    }
    // get url
    public String getUrlAccount() {
        return driver.getCurrentUrl();
    }
}
