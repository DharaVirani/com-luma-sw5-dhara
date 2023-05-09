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
public class MenTest extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ShoppingCart shoppingCart;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        productsPage = new ProductsPage();
        shoppingCart = new ShoppingCart();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        Thread.sleep(1000);
        //Mouse Hover on Men Menu
        homePage.mouseHoverOnMensTab();
        Thread.sleep(1000);
        //Mouse Hover on Bottoms
        homePage.mouseHoverOnBottomsInMensTab();
        //* Click on Pants
        Thread.sleep(1000);
        homePage.mouseHoverAndClickOnPantsInBottoms();
        //* Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        productsPage.mouseHoverOnProductCronusYogaPant();
        Thread.sleep(1000);
        productsPage.mouseHoverAndClickOnSizeOfCronusYogaPant();
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        productsPage.mouseHoverAndClickOnCronusYogaPantColour();
        //* Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        productsPage.mouseHoverOnProductCronusYogaPant();
        productsPage.mouseHoverAndClickOnAddToCart();
        //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        Assert.assertEquals(productsPage.verifyProductAddedToCartMessage(), "You added Cronus Yoga Pant to your shopping cart.");
        //* Click on ‘shopping cart’ Link into message
        productsPage.clickOnShoppingCartLink();
        //* Verify the text ‘Shopping Cart.’
        Assert.assertEquals( shoppingCart.verifyShoppingCartTitle(), "Shopping Cart");
        //* Verify the product name ‘Cronus Yoga Pant’
        Assert.assertEquals( shoppingCart.verifyProductCronusYogaPantName(),"Cronus Yoga Pant");
        //* Verify the product size ‘32’
        Assert.assertEquals(shoppingCart.verifyProductCronusYogaPantSizeText(),"32");
        //* Verify the product colour ‘Black’
        Assert.assertEquals(shoppingCart.verifyProductCronusYogaPantColourText(),"Black");

    }
}
