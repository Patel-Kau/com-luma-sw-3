package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class GearTest extends Utility {

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
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

    // Mouse Hover on Gear Menu
//    mouseHover(By.xpath("//span[normalize-space()='Gear']"));
//    // Click on Bags
//    mouseHoverAndClick(By.xpath("//span[normalize-space()='Bags']"));
        Actions action = new Actions(driver);

        // Mouse Hover on Gear Menu
        mouseHover(By.xpath("(//span[normalize-space()='Gear'])[1]"));
//    action.moveToElement(driver.findElement(By.xpath("(//span[normalize-space()='Gear'])[1]"))).build().perform();
        Thread.sleep(3000);

        // Click on Bags
//    mouseHover(By.xpath("//span[normalize-space()='Bags'])[1]"));
        action.moveToElement(driver.findElement(By.xpath("(//span[normalize-space()='Bags'])[1]"))).click().build().perform();
        Thread.sleep(3000);

        // Click on Product Name ‘Overnight Duffle’
       clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
//        action.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Overnight Duffle']"))).click().build().perform();
        Thread.sleep(2000);

        // Change Qty 3
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        Thread.sleep(2000);

        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));
        Thread.sleep(2000);

        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedAddedShoppingCart = "You added Overnight Duffle to your shopping cart.";
        String actualAddedShoppingCart = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expectedAddedShoppingCart, actualAddedShoppingCart);
        Thread.sleep(2000);

        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Thread.sleep(2000);

        // Verify the product name ‘Overnight Duffle’
        String expectedProductName = "Overnight Duffle";
        String actualProductName = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        Assert.assertEquals(expectedProductName, actualProductName);
        Thread.sleep(2000);

        // Verify the Qty is ‘3’
//        String expectedProductQty = "3";
//        String actualProductQty = getTextFromElement(By.xpath("(//input[@class='input-text qty'])[1]"));
//        Assert.assertEquals(expectedProductQty, actualProductQty);
//        Thread.sleep(2000);

        // Verify the product price ‘$135.00’
        String expectedProductPrice = "$135.00";
        String actualProductPrice = getTextFromElement(By.xpath("//span[@data-bind='text: getValue()'][normalize-space()='$135.00']"));
        Assert.assertEquals(expectedProductPrice, actualProductPrice);
        Thread.sleep(2000);

        // Change Qty to ‘5’
        sendTextToElement(By.xpath("(//input[@class='input-text qty'])[1]"), "5");
//        sendTextToElement(By.xpath("//input[@id='cart-106567-qty']"), "5");
        Thread.sleep(2000);

        // Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        Thread.sleep(2000);

        // Verify the product price ‘$225.00
        String expectedProductUpdatedPrice = "$225.00";
        String actualProductUpdatedPrice = getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]"));
        Assert.assertEquals(expectedProductUpdatedPrice, actualProductUpdatedPrice);
        Thread.sleep(2000);





    }

}
