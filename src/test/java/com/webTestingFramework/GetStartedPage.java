package com.webTestingFramework;

import org.junit.Assert;
import org.openqa.selenium.By;

public class GetStartedPage extends BasePage {
    By desiredAmount = By.cssSelector("input[name='desiredAmount']");
    By loanPurposeCombo = By.cssSelector("select[data-auto='dropLoanPurpose']");
    By purposeOption = By.cssSelector("option[value='SMALL_BUSINESS']");
    By submitButton = By.cssSelector("button[data-auto='CheckYourRate']");
    private String initialUrl = "/nonDMFunnel";
    private String individualFormUrl = "step=contact";

    public GetStartedPage() {
        super();
    }

    public void initiateChecking(String amount) throws InterruptedException {
        Assert.assertTrue("/nonDMFunnel did not loaded.", getUrl().contains(initialUrl));
        type(amount, desiredAmount);
        click(loanPurposeCombo);
        click(purposeOption);
        click(submitButton);
        forcedWait(2);
        Assert.assertTrue("step=concact did not loaded.", getUrl().contains(individualFormUrl));
    }
}
