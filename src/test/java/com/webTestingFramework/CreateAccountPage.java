package com.webTestingFramework;

import org.junit.Assert;
import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage {
    By secondaryTitle = By.cssSelector("h2[class='title--secondary text--weight-light text--color-primary section']");
    By userNameInput = By.cssSelector("input[name='username']");
    By passwordInput = By.cssSelector("input[name='password']");
    By agreeTermsCheckbox = By.xpath("//div[@class='section']/div/label/div[1]");
    By checkYourRateButton = By.cssSelector("button[data-auto='submitPersonalInfo']");
    private String offerPageUrl = "/offer-page";

    public CreateAccountPage() { super(); }

    public void createAccount(String user, String pass) throws InterruptedException {
        if(isDisplayed(secondaryTitle)) {
            type(user, userNameInput);
            type(pass, passwordInput);
            forcedWait(2);
            click(agreeTermsCheckbox);
            forcedWait(2);
            click(checkYourRateButton);
            forcedWait(15);
            Assert.assertTrue("/offer-page did not loaded.", getUrl().contains(offerPageUrl));
        }
    }
}
