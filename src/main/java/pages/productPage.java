package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productPage {
    private static WebDriver driver;

    private By jacket1 = new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/strong/a");
    private By jacket2 = new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[6]/div/div/strong/a");

    public productPage(WebDriver driver) {
        this.driver = driver;
    }
    public detailProductPage clickJacket1(){
        driver.findElement(jacket1).click();
        return new detailProductPage(driver);
    }
    public detailProductPage clickJacket2(){
        driver.findElement(jacket2).click();
        return new detailProductPage(driver);
    }
    public String getUrlProduct() {
        return driver.getCurrentUrl();
    }
}
