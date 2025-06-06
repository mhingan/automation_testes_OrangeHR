package org.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private By upgradeButtonn = By.xpath("//button[@class='oxd-glass-button orangehrm-upgrade-button']");
    private By userDropDown = By.xpath("//*[@class='oxd-userdropdown']");




    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUpgradeButton() {
        driver.findElement(upgradeButtonn).click();
    }


    public WebElement getUserDropDown() {
        return driver.findElement(userDropDown);
    }
}
