package org.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By upgr = By.xpath("//button[@class='oxd-glass-button orangehrm-upgrade-button']']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    public String getBreadCrumbLandingVerif() {

        return driver.findElement(upgr).getText();
    }
}
