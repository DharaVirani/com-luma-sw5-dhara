package com.magento.softwaretestingboard.testsuite;

import com.magento.softwaretestingboard.customlisteners.CustomListeners;
import com.magento.softwaretestingboard.pages.HomePage;
import com.magento.softwaretestingboard.pages.ProductsPage;
import com.magento.softwaretestingboard.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class WomenTest extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        productsPage = new ProductsPage();

    }

    @Test(groups = {"sanity","regression"})
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //* Mouse Hover on Women Menu
        Thread.sleep(2000);
        homePage.mouseHoverOnWomenTab();
        //* Mouse Hover on Tops
        Thread.sleep(2000);
        homePage.mouseHoverOnTopsInWomenTab();
        //* Click on Jackets
        Thread.sleep(2000);
        homePage.mouseHoverAndClickOnJacketsInWomen();
        //Select sort by option Product name
        productsPage.selectSortByOption("Product Name");
        //verify products arranged in alphabetical order
        productsPage.verifyProductsNameAlphabeticalOrder();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        //  Mouse Hover on Women Menu
        Thread.sleep(1000);
        homePage.mouseHoverOnWomenTab();
        //* Mouse Hover on Tops
        Thread.sleep(1000);
        homePage.mouseHoverOnTopsInWomenTab();
        //* Click on Jackets
        homePage.mouseHoverAndClickOnJacketsInWomen();
        //Select sort by option price Low to High
        productsPage.selectSortByOption("Price");
        //* Verify the products price display in Low to High
      productsPage.verifyProductsPriceLowToHigh();
    }
}
