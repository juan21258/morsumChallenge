package test.orders;
import com.microsoft.playwright.*;
import org.testng.annotations.*;
import pages.*;

public class UserOrderTests {

    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() throws Exception {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @AfterClass
    public void tearDown() throws Exception {
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void addProductToCartFromPDP() {
    	//Login Process
    	loginPage = new LoginPage(page, "https://www.saucedemo.com/");
        loginPage.navigate();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        
    }
}
