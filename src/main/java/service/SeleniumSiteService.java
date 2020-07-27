package service;

import model.NewUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utill.WebDriverUtill;

public class SeleniumSiteService {

    public static WebDriver connectToSite(String url) {
        WebDriverUtill webDriverUtill = new WebDriverUtill();
        WebDriver webDriver = webDriverUtill.getWebDriver();
        webDriver.get(url);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return webDriver;
    }

    public static WebDriver citilinkRegistration(NewUser newUser, WebDriver webDriver) {
        String registration = webDriver.findElement(By.className("auth-popup__registration-link")).getAttribute("href");
        webDriver.get(registration);
        ThreadSleep.sleepThread();
        WebElement emailField = webDriver.findElement(By.id("registration_user_email"));
        emailField.sendKeys(newUser.getEmail());
        WebElement phoneNumberField = webDriver.findElement(By.id("registration_user_phone"));
       phoneNumberField.sendKeys(newUser.getPhoneNumber());
        webDriver.findElement(By.className("js--registration-form__check-phone-btn")).click();
        return null;
    }
}
