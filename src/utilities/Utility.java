package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will send text to the element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void verifyExpectedAndActual(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        Assert.assertEquals(actualText, expectedText);
    }

    public String getValueFromElement(By by) {
        return driver.findElement(by).getAttribute("value");
    }

    public void verifyExpectedAndActualValue(By by, String expectedValue) {
        String actualValue = getValueFromElement(by);
        Assert.assertEquals(actualValue, expectedValue);
    }


    /*public WebElement getWebElement(By by){
        return driver.findElement(by);
    }*/


    //************************* Alert Methods *****************************************************
    // Homework - Create 5 alert methods

    //************************* Select Methods *****************************************************
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by VisibleText
        select.selectByVisibleText(text);
    }

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverMultiple(By by, By one) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(one)).perform();
    }

    /**
     * This method will use to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    /**
     * ****************************Clear Text Method***********************
     */
    public void clearText(By by) {
        driver.findElement(by).clear();
        /*Actions actions = new Actions(driver);
        WebElement text = driver.findElement(by);
        text.clear();*/
    }

    /**
     * **************************** Number and Name of products  displayed on a page ***********************
     */
    public void noOfProductsOnPage(By by,String text) {
        List<WebElement> productCount = driver.findElements(by);
        System.out.println(text + productCount.size());
    }

    public void noOfProductsOnPageAndProductName(By by,String text) {
        List<WebElement> productCount = driver.findElements(by);
        System.out.println(text + productCount.size());

        for (WebElement element : productCount) {
            System.out.println(element.getText());
        }
    }
}
