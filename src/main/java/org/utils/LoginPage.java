package org.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By loginName = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    private By forgotPasswordLink = By.xpath("//*[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");

    //private By errorMessage  = By.id("//*[@class='oxd-alert-content oxd-alert-content--error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(loginName).sendKeys(username);
    }

    public void enterPassword(String passwordI) {
        driver.findElement(password).sendKeys(passwordI);
    }

    public HomePage clickLogin(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public ResetPasswordPage clickReset(){
        driver.findElement(forgotPasswordLink).click();
        return new ResetPasswordPage(driver);
    }




//    public String getErrorMessage() {
//        return driver.findElement(errorMessage).getText();
//    }


}
