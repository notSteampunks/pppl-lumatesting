package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchPage {
    private static WebDriver driver;
    private By search = new By.ById("search");
    private By searchBtn = new By.ById("search_mini_form");
    private By searchResult = new By.ByClassName("category-products");

    public searchPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setSearch(String query) {
        driver.findElement(search).sendKeys(query);
    }
    public void clickSearch() {
        driver.findElement(searchBtn).submit();
    }
    public String getUrlSearch() {
        return driver.getCurrentUrl();
    }
}
