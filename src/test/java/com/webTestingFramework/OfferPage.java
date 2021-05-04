package com.webTestingFramework;

import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.openqa.selenium.By;

@Getter
@Setter
public class OfferPage extends BasePage {
    private String loanAmount;
    private String monthlyPayment;
    private String monthTerm;
    private String interestRate;
    private String aprValue;
    private String logoutUrl = "/logout";

    By loanAmountText = By.cssSelector("span[data-auto='userLoanAmount']");
    By monthlyPaymentText = By.cssSelector("span[data-auto='defaultMonthlyPayment']");
    By monthTermText = By.cssSelector("div[data-auto='defaultLoanTerm']");
    By interestRateText = By.cssSelector("div[data-auto='defaultLoanInterestRate']");
    By aprValueText = By.cssSelector("div[data-auto='defaultMoreInfoAPR']");
    By selectButtonText = By.cssSelector("button[data-auto='getDefaultLoan']");
    By menu = By.cssSelector("label[class='header-nav__toggle']");
    By signOut = By.cssSelector("a[href='/funnel/logout']");
    By logoutMessageLocator = By.cssSelector("h1[data-auto='logoutMessage']");

    public void copyData() {
        setLoanAmount(getText((loanAmountText)));
        setMonthlyPayment(getText(monthlyPaymentText));
        setMonthTerm(getText(monthTermText));
        setInterestRate(getText(interestRateText));
        setAprValue(getText(aprValueText));
    }

    public void verifyData() {
        Assert.assertEquals("Wrong loan amount.", loanAmount, getText(loanAmountText));
        Assert.assertEquals("Wrong monthly Payment amount.", monthlyPayment, getText(monthlyPaymentText));
        Assert.assertEquals("Wrong month Term amount.", monthTerm, getText(monthTermText));
        Assert.assertEquals("Wrong interest Rate amount.", interestRate, getText(interestRateText));
        Assert.assertEquals("Wrong apr Value amount.", aprValue, getText(aprValueText));
    }

    public void userSignOut() throws InterruptedException {
        click(menu);
        forcedWait(2);
        click(signOut);
        forcedWait(4);
        Assert.assertTrue("/logout did not loaded.", getUrl().contains(logoutUrl));
    }
}
