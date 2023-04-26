package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDoem() {
            driver.close();
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {

        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//span[text()='Women']"))).build().perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"))).build().perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("(//a[@id='ui-id-11'])[1]"))).click().build().perform();
        Thread.sleep(2000);

        //  Select Sort By filter “Product Name”
        clickOnElement(By.xpath("(//select[@id='sorter'])[1]"));
        selectFromDropDown(By.xpath("//div[2]//div[3]//select[1]"), "Product Name");

        // Verify the products name display in alphabetical order
        List<WebElement> beforeShoringJacketsElements = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> beforeShoringJacketsText = new ArrayList<>();
        for (WebElement jacketsElementsBefore : beforeShoringJacketsElements) {
            beforeShoringJacketsText.add(jacketsElementsBefore.getText());
        }
        Thread.sleep(2000);
        clickOnElement(By.xpath("(//select[@id='sorter'])[1]"));
        selectFromDropDown(By.xpath("//div[2]//div[3]//select[1]"), "Product Name");

        List<WebElement> afterSortingJacketsElement = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> afterSortingJacketsText = new ArrayList<>();
        for (WebElement jacketselementsafter : afterSortingJacketsElement) {
            afterSortingJacketsText.add(jacketselementsafter.getText());
        }

        Assert.assertEquals(beforeShoringJacketsText, afterSortingJacketsText);
        Thread.sleep(2000);
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        Actions action = new Actions(driver);
        Thread.sleep(2000);

        // Mouse Hover on Women Menu
        action.moveToElement(driver.findElement(By.xpath("//span[text()='Women']"))).build().perform();
        Thread.sleep(2000);

        // Mouse Hover on Tops
        action.moveToElement(driver.findElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"))).build().perform();
        Thread.sleep(2000);

        // Click on Jackets
        action.moveToElement(driver.findElement(By.xpath("(//a[@id='ui-id-11'])[1]"))).click().build().perform();
        Thread.sleep(2000);

        //  Select Sort By filter “Price”
        clickOnElement(By.xpath("(//select[@id='sorter'])[1]"));
        selectFromDropDown(By.xpath("//div[2]//div[3]//select[1]"), "Price");
        Thread.sleep(2000);

        // Verify the products name display in alphabetical order
        List<WebElement> beforeShoringJacketsPriceElements = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<String> beforeShoringJacketsPriceText = new ArrayList<>();
        for (WebElement jacketsElementsBefore : beforeShoringJacketsPriceElements) {
            beforeShoringJacketsPriceText.add(jacketsElementsBefore.getText());
        }
        Thread.sleep(2000);

        clickOnElement(By.xpath("(//select[@id='sorter'])[1]"));
        selectFromDropDown(By.xpath("//div[2]//div[3]//select[1]"), "Price");
        Thread.sleep(2000);

        List<WebElement> afterSortingJacketsPriceElement = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<String> afterSortingJacketsPriceText = new ArrayList<>();
        for (WebElement jacketselementsafter : afterSortingJacketsPriceElement) {
            afterSortingJacketsPriceText.add(jacketselementsafter.getText());
        }

        Assert.assertEquals(beforeShoringJacketsPriceText, afterSortingJacketsPriceText);
        Thread.sleep(2000);


    }


}
