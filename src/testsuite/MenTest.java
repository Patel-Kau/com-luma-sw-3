package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MenTest extends Utility {
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

        Actions action = new Actions(driver);


        // Mouse Hover on Men Menu
        action.moveToElement(driver.findElement(By.xpath("//a[@id='ui-id-5']//span[contains(text(),'Men')]"))).build().perform();
        Thread.sleep(2000);

        // Mouse Hover on Bottoms
        action.moveToElement(driver.findElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"))).build().perform();
        Thread.sleep(2000);

        // Click on Pants
        action.moveToElement(driver.findElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"))).click().build().perform();
        Thread.sleep(2000);

        //  Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        action.moveToElement(driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"))).click().build().perform();
        Thread.sleep(2000);

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        action.moveToElement(driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"))).click().build().perform();
        Thread.sleep(2000);

        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        action.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"))).click().build().perform();
        Thread.sleep(2000);

        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedAddedShoppingCartText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualAddedShoppingCartText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expectedAddedShoppingCartText, actualAddedShoppingCartText);
        Thread.sleep(2000);

        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Thread.sleep(2000);

        // Verify the text ‘Shopping Cart.’
        String expectedShoppingCartText = "Shopping Cart";
        String actualShoppingCartText = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals(expectedShoppingCartText, actualShoppingCartText);
        Thread.sleep(2000);

        // Verify the product name ‘Cronus Yoga Pant’
        String expectedProductNameText = "Cronus Yoga Pant";
        String actualProductNameText = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals(expectedProductNameText, actualProductNameText);
        Thread.sleep(2000);

        //  Verify the product size ‘32’
        String expectedProductSizeText = "32";
        String actualProductSizeText = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals(expectedProductSizeText, actualProductSizeText);
        Thread.sleep(2000);

        // Verify the product colour ‘Black’
        String expectedProductColourText = "Black";
        String actualProductColourText = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals(expectedProductColourText, actualProductColourText);
        Thread.sleep(2000);

    }

}
