package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signInPage {
    private static WebDriver driver;
    private By email = new By.ById("email");
    private By password = new By.ById("pass");
    private By signInBtn = new By.ById("send2");

    public signInPage(WebDriver driver) {
        this.driver = driver;
    }
    // set email
    public void setEmail(String query) {
        driver.findElement(email).sendKeys(query);
    }
    // set password
    public void setPass(String query) {
        driver.findElement(password).sendKeys(query);
    }
    // click sign in
    public accPage clickSignIn() {
        driver.findElement(signInBtn).submit();
        return new accPage(driver);
    }
}
