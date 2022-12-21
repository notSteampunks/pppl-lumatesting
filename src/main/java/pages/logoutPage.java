package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logoutPage {
    private static WebDriver driver;
    private By menu = new By.ByXPath("//button[@class = \"action switch\"]");
    private By logout = new By.ByClassName("authorization-link");


    public logoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickMenu() {
        driver.findElement(menu).click();
    }
    public void clickLogout() {
        driver.findElement(logout).click();
    }
    public String getUrlLogout() {
        return driver.getCurrentUrl();
    }
}
