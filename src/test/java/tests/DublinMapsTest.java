package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;


public class DublinMapsTest {

    private WebDriver driver;
    private WebElement wait;

    private final By searchInput = By.id("searchboxinput");
    private final By searchButton = By.id("searchbox-searchbutton");
    private final By directions = By.xpath("//button[@jsaction='pane.placeActions.directions;keydown:pane.placeActions.directions']");
    private final By headline = By.xpath("//span[normalize-space()='Dublin']");
    private final By destination = By.xpath("//div[@id='directions-searchbox-1']//input");


    @Before
    public void startBrowser() throws InterruptedException {

        EnvironmentManager.checkSystem();

        if (EnvironmentManager.checkSystem() == true) {
            EnvironmentManager.initWebDriver();
        } else {
            Assert.assertEquals(true, EnvironmentManager.checkSystem());
        }

    }

    @Test
    public void DublinMapsTest() throws InterruptedException {

        driver = RunEnvironment.getWebDriver();
        // Go to https://www.google.com/maps
        driver.get("https://www.google.com/maps");

        //Assert title page before by pass
        String mapsTitle = driver.getTitle();
        //System.out.println("Value from page title " + mapsTitle);
        Assert.assertTrue(mapsTitle.contains("Maps"));

        Utils.byPassGoogle(driver);

        //Assert title page after by pass
        //System.out.println("Value from page title " + mapsTitle);
        Assert.assertTrue(mapsTitle.contains("Maps"));

        // 1. Wait to load the search box and after fill Dublin
        wait = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(searchInput));
        driver.findElement(searchInput).sendKeys(Utils.DUBLIN);

        // 2. Wait to load the search button and after click on this button
        wait = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();

        //4. Wait the directions button to load and after that verify left panel has "Dublin" as a headline text
        wait = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(directions));

        String headText = driver.findElement(headline).getText();
        //System.out.println("Value from headline " + headText);
        Assert.assertTrue(headText.contains(Utils.DUBLIN));

        //5. Click in direction button and after assert the value from destination button

        driver.findElement(directions).click();
        wait = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(destination));
        String destinationText = driver.findElement(destination).getAttribute("value");
        //System.out.println("Value from destination " + destinationText);
        Assert.assertTrue(destinationText.contains(Utils.DUBLIN));

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
