package pages;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class mainTest {
    private static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setUp() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterAll
    static void afterAll() {

    }

    @Test
    @Order(1)
    public void testHomePage() {
        homePage homes = new homePage(driver);

        String url = homes.getUrlHome();
        assertEquals("https://magento.softwaretestingboard.com/", url);
    }

    @Test
    @Order(2)
    public void testCreateAccount() {
        homePage home = new homePage(driver);
        home.clickCreateAcc();

        createAccPage create = new createAccPage(driver);
        create.setFirstName("Bruce");
        create.setLastName("Wayne");
        create.clickSubscribe();
        create.setEmail("bruce@gmail.com");
        create.setPass("BruceWayne619");
        create.setConfirmPass("BruceWayne619");
        create.clickCreateAccount();
        accPage success = new accPage(driver);
        String url = success.getUrlAccount();
        assertEquals("https://magento.softwaretestingboard.com/customer/account/", url);
    }

//    @Test
//    public void testSignIn() {
//        homePage home = new homePage(driver);
//        home.clickSignIn();
//
//        signInPage signIn = new signInPage(driver);
//        signIn.setEmail("bruce@gmail.com");
//        signIn.setPass("BruceWayne619");
//        signIn.clickSignIn();
//        accPage success = new accPage(driver);
//        String url = success.getUrlAccount();
//        assertEquals("https://magento.softwaretestingboard.com/", url);
//    }

    @Test
    @Order(3)
    public void testChooseProduct() {
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("bruce@gmail.com");
        signIn.setPass("BruceWayne619");
        signIn.clickSignIn();

        accPage product = new accPage(driver);
        product.setMen();
        product.setTops();
        product.setJacket();

        productPage productPage = new productPage(driver);
        String url = productPage.getUrlProduct();
        assertEquals("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html", url);
    }

    @Test
    @Order(4)
    public void testSelectTwoProduct() {

        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("bruce@gmail.com");
        signIn.setPass("BruceWayne619");
        signIn.clickSignIn();

        accPage product = new accPage(driver);
        product.setMen();
        product.setTops();
        product.setJacket();

        productPage productPage = new productPage(driver);
        productPage.clickJacket1();

        detailProductPage detail = new detailProductPage(driver);
        detail.selectSize("M");
        detail.selectColor1("Black");
        detail.setQty("2");
        detail.clickAddToCart();
        detail.clickBackProduct();

        productPage.clickJacket2();
        detail.selectSize("L");
        detail.selectColor2("Blue");
        detail.setQty("2");
        detail.clickAddToCart();

        assertEquals("4", detail.getCart());
    }

    @Test
    @Order(5)
    public void testCheckout() {
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("bruce@gmail.com");
        signIn.setPass("BruceWayne619");
        signIn.clickSignIn();

        accPage cart = new accPage(driver);
        cart.setMen();
        cart.setTops();
        cart.setJacket();
        cart.clickCart();
        cart.clickCheckout();

        checkoutPage checkout = new checkoutPage(driver);
        String url = checkout.getUrlCheckout();
        assertEquals("https://magento.softwaretestingboard.com/checkout/", url);
    }

    @Test
    @Order(7)
    public void testShipping() {
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("bruce@gmail.com");
        signIn.setPass("BruceWayne619");
        signIn.clickSignIn();

        accPage cart = new accPage(driver);
        cart.setMen();
        cart.setTops();
        cart.setJacket();
        cart.clickCart();
        cart.clickCheckout();

        checkoutPage checkout = new checkoutPage(driver);
        checkout.setCompany("Wayne Enterprises");
        checkout.setAddress("123 Gotham City");
        checkout.setCity("Gotham City");
        checkout.setState();
        checkout.setZip("12345");
        checkout.setCountry();
        checkout.setPhone("1234567890");
        checkout.setMethod();
        checkout.clickNext();

        checkout.clickPlaceOrder();
    }
    @Test
    @Order(8)
    public void testCheckShipping() {
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("bruce@gmail.com");
        signIn.setPass("BruceWayne619");
        signIn.clickSignIn();

        accPage cart = new accPage(driver);
        cart.setMen();
        cart.setTops();
        cart.setJacket();
        cart.clickCart();
        cart.clickCheckout();

        checkoutPage checkout = new checkoutPage(driver);
        checkout.setCompany("Wayne Enterprises");
        checkout.setAddress("123 Gotham City");
        checkout.setCity("Gotham City");
        checkout.setState();
        checkout.setZip("12345");
        checkout.setCountry();
        checkout.setPhone("1234567890");
        checkout.setMethod();
        checkout.clickNext();

        String actualAddress = "Bruce Wayne\n" +
                "123 Gotham City\n" +
                "Gotham City, Ohio 12345\n" +
                "United States\n" +
                "1234567890";

        assertEquals(actualAddress, checkout.checkAddress());

    }

    // tambahan 1
    @Test
    public void testLogout() {
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("bruce@gmail.com");
        signIn.setPass("BruceWayne619");
        signIn.clickSignIn();

        accPage cart = new accPage(driver);
        cart.setMen();
        cart.setTops();
        cart.setJacket();

        logoutPage logout = new logoutPage(driver);
        logout.clickMenu();
        logout.clickLogout();
        String url = logout.getUrlLogout();
        assertEquals("https://magento.softwaretestingboard.com/customer/account/logoutSuccess/", url);
    }
    // tambahan 2
    @Test
    public void testSearch(){
        searchPage search = new searchPage(driver);
        search.setSearch("Jacket");
        search.clickSearch();

        String url = search.getUrlSearch();
        assertEquals("https://magento.softwaretestingboard.com/catalogsearch/result/?q=Jacket", url);
    }

}