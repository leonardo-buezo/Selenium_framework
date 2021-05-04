package com.webTestingFramework;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    By userNameInput = By.cssSelector("input[data-auto='username']");
    By passwordInput = By.cssSelector("input[data-auto='password']");
    By signInButton = By.cssSelector("button[data-auto='login']");
    private String offerPageUrl = "/offer-page";

    public LoginPage() { super(); }

    public void loginUser(String user, String pass) throws InterruptedException {
        type(user, userNameInput);
        type(pass, passwordInput);
        forcedWait(2);
        click(signInButton);
        forcedWait(15);
        Assert.assertTrue("/offer-page did not loaded.", getUrl().contains(offerPageUrl));
    }
}
