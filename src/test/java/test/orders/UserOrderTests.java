package test.orders;
import com.microsoft.playwright.*;
import static org.testng.Assert.assertEquals;
import java.util.List;
import org.testng.annotations.*;
import pages.*;
import constants.*;

public class UserOrderTests {

    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    TestData testData = new TestData();
    
    @BeforeMethod
    public void setUp() throws Exception {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void addProductToCartFromPDP() {
    	//Login Process
    	loginPage = new LoginPage(page, TestData.BASE_URL);
        loginPage.navigate();
        loginPage.enterUsername(TestData.USER);
        loginPage.enterPassword(TestData.PASSWORD);
        loginPage.clickLoginButton();
        //Product selection
        productPage = new ProductPage(page);
        productPage.clickSortByPriceHighToLow();
        String selectedproduct = productPage.addProduct();
        productPage.goToCart();
        //Assertion of the product in the cart
        cartPage = new CartPage(page);
        String productInCart = cartPage.getItemName();
        assertEquals(productInCart, selectedproduct);
    }
    
    @Test
    public void addProductToCartFromIndex() throws InterruptedException {
    	//Login Process
    	loginPage = new LoginPage(page, TestData.BASE_URL);
        loginPage.navigate();
        loginPage.enterUsername(TestData.USER);
        loginPage.enterPassword(TestData.PASSWORD);
        loginPage.clickLoginButton();
        //Product selection
        productPage = new ProductPage(page);
        productPage.clickSortByPriceHighToLow();
        List<String> productsSelected = productPage.selectFirst3Products();
        productPage.goToCart();
        //Assertion of the product in the cart
        cartPage = new CartPage(page);
        List<String> productsInCart = cartPage.getFirst3ProductsInCart();
        for(int i = 0; i <3; i++) {
        	assertEquals(productsSelected.get(i), productsInCart.get(i));
        }
    }
}
