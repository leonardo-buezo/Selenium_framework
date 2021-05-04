package com.webTestingFramework;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class Registration_Test {
    GetStartedPage getStartedPage;
    IndividualFormPage individualFormPage;
    IndividualIncomePage individualIncomePage;
    CreateAccountPage createAccountPage;
    OfferPage offerPage;
    LoginPage loginPage;
    String firstUrl = "https://www.credify.tech/phone/nonDMFunnel";
    String loginUrl = "https://www.credify.tech/portal/login";
    String amount = "2000";
    String firstName = "Leo";
    String lastName = "Buezo";
    String address = "pal";
    String DOB = "01011990";
    String indiv = "120000";
    String added = "5000";
    String email = "user_10@testing.com";
    String password = "Testing_2"; // DON'T DO IT!!! (Use properties file)

    @Before
    public void setUp() throws Exception {
        getStartedPage = new GetStartedPage();
        individualFormPage = new IndividualFormPage();
        individualIncomePage = new IndividualIncomePage();
        createAccountPage = new CreateAccountPage();
        offerPage = new OfferPage();
        loginPage = new LoginPage();
        getStartedPage.openUrl(firstUrl);
    }

    /**
     * Regression Test that validates registration of borrower, login and info regarding loan offers.
     * Author: Leonardo Buezo
     * Date: 08/05/2020
     *
     * pages:
     * ======
     * page #1 >> https://www.credify.tech/phone/nonDMFunnel
     * page #2 >> https://www.credify.tech/funnel/personal-information-1/SMALL_BUSINESS/2000?step=contact
     * page #3 >> https://www.credify.tech/funnel/personal-information-1/SMALL_BUSINESS/2000?step=income
     * page #4 >> https://www.credify.tech/funnel/personal-information-1/SMALL_BUSINESS/2000?step=login
     * page #5 >> https://www.credify.tech/funnel/offer-page
     * page #6 >> https://www.credify.tech/funnel/logout
     * page #7 >> https://www.credify.tech/portal/login
     * page #8 >> https://www.credify.tech/funnel/offer-page
     *
     */
    @Test
    public void test() throws InterruptedException {
        getStartedPage.initiateChecking(amount);
        offerPage.forcedWait(2);
        individualFormPage.completeForm(firstName, lastName, address, DOB);
        individualFormPage.forcedWait(2);
        individualIncomePage.completeIncomeForm(indiv, added);
        individualIncomePage.forcedWait(2);
        createAccountPage.createAccount(email, password);
        createAccountPage.forcedWait(2);
        offerPage.copyData();
        offerPage.userSignOut();
        offerPage.forcedWait(2);
        loginPage.openUrl(loginUrl);
        loginPage.loginUser(email,password);
        offerPage.verifyData();
        offerPage.userSignOut();
    }

    @After
    public void tearDown() throws Exception {
        loginPage.closeBrowser();
    }

}
