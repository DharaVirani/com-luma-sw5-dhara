package com.magento.softwaretestingboard.testsuite;

import com.magento.softwaretestingboard.customlisteners.CustomListeners;
import com.magento.softwaretestingboard.pages.HomePage;
import com.magento.softwaretestingboard.pages.ProductsPage;
import com.magento.softwaretestingboard.pages.ShoppingCart;
import com.magento.softwaretestingboard.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class GearTest extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ShoppingCart shoppingCart;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        productsPage = new ProductsPage();
        shoppingCart = new ShoppingCart();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        // Mouse Hover on Gear Menu
        Thread.sleep(1000);
        homePage.mouseHoverOnGearTab();
        Thread.sleep(1000);
        // Click on Bags
        homePage.mouseHoverAndClickOnBagsInGear();
        Thread.sleep(1000);
        // Click on Product Name ‘Overnight Duffle’
        productsPage.clickOnProductOvernightDuffle();
        // Verify the text ‘Overnight Duffle’
        Assert.assertEquals(productsPage.verifyOvernightDuffleText(),"Overnight Duffle");
        // Change Qty 3
        productsPage.changeQty("3");
        // Click on ‘Add to Cart’ Button.
        productsPage.clickOnAddToCartButton();
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        Assert.assertEquals(productsPage.verifyProductAddedToCartMessage(),"You added Overnight Duffle to your shopping cart.");
        // Click on ‘shopping cart’ Link into message
        productsPage.clickOnShoppingCartLink();
        // Verify the product name ‘Overnight Duffle’
        Assert.assertEquals(shoppingCart.verifyProductNameOvernightDuffle(),"Overnight Duffle");
        //Verify the Qty is ‘3’
        Assert.assertEquals(shoppingCart.verifyProductOvernightDuffleQtyText("value"),"3");
        // Verify the product price ‘$135.00’
        Assert.assertEquals(shoppingCart.verifyProductOvernightDufflePriceText(),"$135.00");
        Thread.sleep(1000);
        // Change Qty to ‘5’
        shoppingCart.changeFieldInCart("5");
        Thread.sleep(2000);
        // Click on ‘Update Shopping Cart’ button
        shoppingCart.updateShoppingCart();
        // Verify the product price ‘$225.00’
        Thread.sleep(1000);
        Assert.assertEquals(shoppingCart.verifyProductPrice(),"$225.00");

    }
}
