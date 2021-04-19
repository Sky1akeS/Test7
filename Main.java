import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyFile;
public class Main {
    @VisibleForTesting
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sky\\IdeaProjects\\FirstTest\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();

        String searchFieldXpath = "//input[@name='search']";
        WebElement serchElement = driver.findElement(By.xpath(searchFieldXpath));
        serchElement.sendKeys("Монитор");
        serchElement.sendKeys(Keys.ENTER);
        ((ChromeDriver) driver).findElementByXPath("//a[@href=\"https://hard.rozetka.com.ua/samsung_lc27g54tqwixci/p250703981/\"]").click();
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@title='А-Банк. Плати частями']")));
        ((ChromeDriver) driver).findElementByXPath("//button[@aria-label='Купить']").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"https://rozetka.com.ua//checkout/\"]")));

        ((ChromeDriver) driver).findElementByXPath("//a[@href='https://rozetka.com.ua//checkout/']").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@tabindex=\"29\"]")));

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
        driver.quit();

    }

}


