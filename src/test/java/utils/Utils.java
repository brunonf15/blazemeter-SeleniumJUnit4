package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Utils {

    public static final String DUBLIN = "Dublin";

    public static void byPassGoogle(WebDriver driver) {
        By acceptCookiesButton = By.cssSelector("button[jsname='higCR']");
        driver.findElement(acceptCookiesButton).click();
    }

}
