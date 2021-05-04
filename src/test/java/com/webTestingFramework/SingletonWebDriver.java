package com.webTestingFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonWebDriver {
    private WebDriver driver;
    private static SingletonWebDriver instanceOfSingletonBrowserClass = null;

    private  SingletonWebDriver() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver-mac-64bit");
        driver = new ChromeDriver();
    }

    public static SingletonWebDriver chromeDriverConnection() {
        if (instanceOfSingletonBrowserClass == null) {
            instanceOfSingletonBrowserClass = new SingletonWebDriver();
        }
        return instanceOfSingletonBrowserClass;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
