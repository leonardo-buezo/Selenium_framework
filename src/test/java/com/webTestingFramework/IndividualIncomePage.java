package com.webTestingFramework;

import org.junit.Assert;
import org.openqa.selenium.By;

public class IndividualIncomePage extends BasePage {
    By secondaryTitle = By.cssSelector("h2[class='title--secondary text--weight-light text--color-primary section']");
    By individualAnnualIncomeInput = By.cssSelector("input[data-auto='borrowerIncome']");
    By additionalAnnualIncomeInput = By.cssSelector("input[data-auto='borrowerAdditionalIncome']");
    By continueButton = By.cssSelector("button[data-auto='continuePersonalInfo']");
    private String loginUrl = "step=login";

    public void completeIncomeForm(String indiv, String added) throws InterruptedException {
        if(isDisplayed(secondaryTitle)) {
            type(indiv, individualAnnualIncomeInput);
            type(added, additionalAnnualIncomeInput);
            forcedWait(2);
            click(continueButton);
            click(continueButton);
            forcedWait(4);
            Assert.assertTrue("step=login did not loaded", getUrl().contains(loginUrl));
        }
    }

}
