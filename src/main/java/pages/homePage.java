package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    public WebDriver driver;
    public By createAcc = new By.ByLinkText("Create an Account");
    public By signIn = new By.ByLinkText("Sign In");

    public homePage(WebDriver driver){
        this.driver = driver;
    }
    //Click Create an Account
    public createAccPage clickCreateAcc(){
        driver.findElement(createAcc).click();
        return new createAccPage(driver);
    }
    //Click Sign In
    public signInPage clickSignIn(){
        driver.findElement(signIn).click();
        return new signInPage(driver);
    }
    // get url
    public String getUrlHome(){
        return driver.getCurrentUrl();
    }
}
