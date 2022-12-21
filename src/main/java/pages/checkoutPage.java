package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkoutPage {
    private static WebDriver driver;

    private By textboxCompany = By.name("company");
    private By textboxAddress = By.name("street[0]");
    private By textboxCity = By.name("city");
    private By dropdownState = By.name("region_id");
    private By textboxZip = By.name("postcode");
    private By dropdownCountry = By.name("country_id");
    private By textboxPhone = By.name("telephone");
    private By radiobtnMethods = By.name("ko_unique_3");
    private By nextBtn = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");

    private By paymentAddress = By.className("billing-address-details");

    private By placeOrderbtn = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button");

    public checkoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCompany(String strCompany) {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(textboxCompany));
        driver.findElement(textboxCompany).sendKeys(strCompany);
    }
    public void setAddress(String strAddress) {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(textboxAddress));
        driver.findElement(textboxAddress).sendKeys(strAddress);
    }
    public void setCity(String strCity) {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(textboxCity));
        driver.findElement(textboxCity).sendKeys(strCity);
    }
    public void setState() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(dropdownState));
        Select state = new Select(driver.findElement(dropdownState));
        state.selectByVisibleText("Ohio");
    }
    public void setZip(String strZip) {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(textboxZip));
        driver.findElement(textboxZip).sendKeys(strZip);
    }
    public void setCountry() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(dropdownCountry));
        Select country = new Select(driver.findElement(dropdownCountry));
        country.selectByVisibleText("United States");
    }
    public void setPhone(String strPhone) {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(textboxPhone));
        driver.findElement(textboxPhone).sendKeys(strPhone);
    }
    public void setMethod(){
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(radiobtnMethods));
        driver.findElement(radiobtnMethods).click();
    }
    public void clickNext() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(nextBtn));
        driver.findElement(nextBtn).click();
    }
    public void clickPlaceOrder(){
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(placeOrderbtn));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(placeOrderbtn)).click();
    }

    public String checkAddress(){
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(paymentAddress));
        String expectedAddress = driver.findElement(paymentAddress).getText();
        return expectedAddress;
    }

    public String getUrlCheckout() {
        return driver.getCurrentUrl();
    }
}
