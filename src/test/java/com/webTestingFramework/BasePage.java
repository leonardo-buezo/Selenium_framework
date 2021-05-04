package com.webTestingFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private WebDriver driver;
    private SingletonWebDriver chromeDriver = null;

    public BasePage() {
        chromeDriver = SingletonWebDriver.chromeDriverConnection();
        driver = chromeDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void forcedWait(int seconds) throws InterruptedException {
        int ms = seconds * 1000;
        Thread.sleep(ms); //TOO BAD
    }

    public void closeBrowser() {
        chromeDriver.closeDriver();
    }
}

// Implicit wait
// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

// Explicit wait
// WebElement guru99seleniumlink;
// guru99seleniumlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i")));
// guru99seleniumlink.click();