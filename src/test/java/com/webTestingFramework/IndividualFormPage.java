package com.webTestingFramework;

import org.junit.Assert;
import org.openqa.selenium.By;

public class IndividualFormPage extends BasePage {
    By secondaryTitle = By.cssSelector("h2[class='title--secondary text--weight-light text--color-primary section']");
    By firstNameInput = By.cssSelector("input[data-auto='borrowerFirstName']");
    By lastNameInput = By.cssSelector("input[data-auto='borrowerLastName']");
    By homeAddressInput = By.cssSelector("input[name='borrowerStreet']");
    By optionAddress = By.xpath("//ul[@class='geosuggest__suggests']//li[1]");
    By cityInput = By.cssSelector("input[data-auto='borrowerCity']");
    By stateInput = By.cssSelector("input[data-auto='borrowerState']");
    By zipCodeInput = By.cssSelector("input[data-auto='borrowerZipCode']");
    By dateOfBirthInput = By.cssSelector("input[data-auto='borrowerDateOfBirth']");
    By continueButton = By.cssSelector("button[data-auto='continuePersonalInfo']");
    private String incomeUrl = "step=income";

    public IndividualFormPage() { super(); }

    public void completeForm(String firstName, String lastName, String address, String DOB) throws InterruptedException {
        if(isDisplayed(secondaryTitle)) {
            type(firstName, firstNameInput);
            type(lastName, lastNameInput);
            type(address, homeAddressInput);
            click(optionAddress);
            type(DOB, dateOfBirthInput);
            forcedWait(2);
            click(continueButton);
            forcedWait(4);
            Assert.assertTrue("step=income did not loaded.", getUrl().contains(incomeUrl));
        }
    }
}
