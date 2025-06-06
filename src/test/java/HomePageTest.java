import org.junit.Assert;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.HomePage;
import org.utils.LoginPage;

import java.time.Duration;
import java.util.List;

public class HomePageTest {

    ChromeOptions options;
    WebDriver driver;
    HomePage homePage;
    WebDriverWait wait;

    @Before
    public void setUp() {
        options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl(), driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));

        homePage = new HomePage(driver);
    }

    @Test
    public void clickUpgradeButton() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-userdropdown']")));

        String originalWindow = driver.getWindowHandle();

        homePage.clickUpgradeButton();

        wait.until(driver -> driver.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.urlContains("/upgrade-to-advanced"));

        Assert.assertTrue(driver.getCurrentUrl(), driver.getCurrentUrl().matches("https://orangehrm.com/open-source/upgrade-to-advanced"));

        driver.close();
    }

    @Test
    public void selectDropdown() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-userdropdown']")));

        homePage.getUserDropDown().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'oxd-dropdown-menu')]")));

        List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'oxd-dropdown-menu')]/li"));

        Assert.assertTrue("Dropdown has no values", options.size() > 0);

        driver.close();
    }


}
