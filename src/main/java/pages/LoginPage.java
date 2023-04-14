package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;
    private String pageUrl;

    ElementHandle usernameInput;
    ElementHandle passwordInput;
    ElementHandle loginButton;

    public LoginPage(Page page, String pageUrl) {
        this.page = page;
        this.pageUrl = pageUrl;
        setupElements();
    }

    public void navigate() {
        page.navigate(pageUrl);
        setupElements();
    }

    private void setupElements() {
        usernameInput = page.querySelector("#user-name");
        passwordInput = page.querySelector("#password");
        loginButton = page.querySelector("#login-button");
    }

    public void enterUsername(String username) {
        usernameInput.fill(username);
    }

    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
