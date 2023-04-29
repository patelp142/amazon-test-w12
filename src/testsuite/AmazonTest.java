package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class AmazonTest extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheProductsOnThePage() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.id("sp-cc-rejectall-link"));
        Thread.sleep(1000);
//        2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"),"Dell Laptop");
        clickOnElement(By.id("nav-search-submit-button"));
//        3. Click on the checkbox brand Dell on the left side.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@id='brandsRefinements']//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
//        4. Verify that the  30 (Maybe different) products are displayed on the page.
//        5. Print all product names in the console.
        noOfProductsOnPageAndProductName(By.tagName("h2"),"Total products on a page : ");
//        6. Click on the product name 'Dell Inspiron 3511 15.6" FHD Laptop, Intel Core i5-1135G7, 8GB RAM, 512GB SSD, Windows 11 Home (Platinum Silver)'
        clickOnElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']" +
                "[contains(text(),'Dell Inspiron 3511 15.6\" FHD Laptop, Intel Core i5-1135G7, 8GB RAM, 512GB SSD, Windows 11 Home (Platinum Silver)')]"));
//        7. Verify the Product name 'Dell Inspiron 3511 15.6" FHD Laptop, Intel Core i5-1135G7, 8GB RAM, 512GB SSD, Windows 11 Home (Platinum Silver)'
        verifyExpectedAndActual(By.xpath("//span[@id='productTitle']"),
                "Dell Inspiron 3511 15.6\" FHD Laptop, Intel Core i5-1135G7, 8GB RAM, 512GB SSD, Windows 11 Home (Platinum Silver)");
        /*public void clickOnProduct(String product) throws InterruptedException {
            boolean isPresent = false;
            int totalPages = 20; //number of pages
            for (int i = 0; i < totalPages; i++) {
                System.out.println("Page: " + (i + 1));
                System.out.println(driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span")).size());
                for (WebElement name : driver.findElements(By.xpath("//span[contains(text(),'Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB ')]"))) {
                    Thread.sleep(500);
                    System.out.println(name.getText().equalsIgnoreCase(product));
                    if (name.getText().equalsIgnoreCase(product)) {
                        Thread.sleep(1000);
                        name.click();
                        isPresent = true;
                        break;
                    }
                }
                if (!isPresent) {
                    Thread.sleep(2000);
                    clickOnElement1(driver.findElement(By.xpath("//a[text()='Next']")));
                } else {
                    break;
                }
            }
        }*/
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
