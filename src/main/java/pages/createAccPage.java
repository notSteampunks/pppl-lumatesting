package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class createAccPage {
    public WebDriver driver;
    public By firstName = By.id("firstname");
    public By lastName = By.id("lastname");
    public By subscribe = By.id("is_subscribed");
    public By email = By.id("email_address");
    public By pass = By.id("password");
    public By confirmPass = By.id("password-confirmation");
    public By createAccBtn = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");

    public createAccPage(WebDriver driver) {
        this.driver = driver;
    }
    // set first name
    public void setFirstName(String strFirstName) {
        driver.findElement(firstName).sendKeys(strFirstName);
    }
    // set last name
    public void setLastName(String strLastName) {
        driver.findElement(lastName).sendKeys(strLastName);
    }
    // set subscribe
    public void clickSubscribe() {
        driver.findElement(subscribe).click();
    }
    // set email
    public void setEmail(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }
    // set password
    public void setPass(String strPassword) {
        driver.findElement(pass).sendKeys(strPassword);
    }
    // set confirm password
    public void setConfirmPass(String strConfirmPassword) {
        driver.findElement(confirmPass).sendKeys(strConfirmPassword);
    }
    // click create account
    public void clickCreateAccount() {
        driver.findElement(createAccBtn).click();
    }
}
