package com.magento.softwaretestingboard.pages;

import com.aventstack.extentreports.Status;
import com.magento.softwaretestingboard.customlisteners.CustomListeners;
import com.magento.softwaretestingboard.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage extends Utility {

    @CacheLookup
    @FindBy(css = ".products .product-item-info .product-item-name")
    List<WebElement> jacketElementList;

    @CacheLookup
    @FindBy(xpath = "//img[starts-with(@class,'product-image-photo')]")
    List<WebElement> noOfProducts;

    @CacheLookup
    @FindBy(xpath = "//select[@id='sorter'][1]")
    WebElement sortByField;

    @CacheLookup
    @FindBy(xpath = "//span[@class='price-wrapper ']//span")
    List<WebElement> jacketsPriceElementList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Cronus Yoga Pant']")
    WebElement productCronusYogaPant;

    @CacheLookup
    @FindBy(xpath = "//div[@class='swatch-option text'][1]")
    WebElement productCronusYogaPantSize;

    @CacheLookup
    @FindBy(xpath = "//div[@class='swatch-option color'][1]")
    WebElement productCronusYogaPantColour;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Add to Cart')][1]")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement productAddedToCartMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Overnight Duffle']")
    WebElement productOvernightDuffle;

    @CacheLookup
    @FindBy(xpath = "//span[@class='base']")
    WebElement productOverNightDuffleText;

    @CacheLookup
    @FindBy(xpath = "//input[@id='qty']")
    WebElement changeField;

    @CacheLookup
    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    WebElement addToCartButton;




    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortByField, option);
        CustomListeners.test.log(Status.PASS,"Select sortBy option" + option);
    }



    public void verifyProductsNameAlphabeticalOrder(){
        List<WebElement> elementList = noOfProducts;
        System.out.println("Total elements are : " + elementList.size());

        List<WebElement> elementListDisplay = jacketElementList;
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : elementListDisplay) {

            originalProductNameList.add(product.getText());
        }
        Collections.sort(originalProductNameList);
        System.out.println(originalProductNameList + "\n");

        List<WebElement> afterSortingElementList=jacketElementList;
        List<String> afterSortingProductName=new ArrayList<>();
        for(WebElement product:afterSortingElementList){
            afterSortingProductName.add(product.getText());
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals(originalProductNameList,afterSortingProductName,"Not sorted in Alphabetical order");
    }



    public void mouseHoverOnProductCronusYogaPant(){
        Reporter.log("Mouse hover on Product cronus yoga pant" + productCronusYogaPant.toString());
        mouseHoverToElement(productCronusYogaPant);
        CustomListeners.test.log(Status.PASS," Mouse hover on Product cronus yoga pant" );
    }

    public void mouseHoverAndClickOnSizeOfCronusYogaPant(){
        Reporter.log("Mouse hover and click on size of cronus yoga pant" + productCronusYogaPantSize.toString());
        mouseHoverToElementAndClick(productCronusYogaPantSize);
        CustomListeners.test.log(Status.PASS,"Mouse hover and click on size of cronus yoga pant" );
    }

    public void mouseHoverAndClickOnCronusYogaPantColour(){
        Reporter.log("Mouse hover and click on Cronus yoga pant" + productCronusYogaPantColour.toString());
        mouseHoverToElementAndClick(productCronusYogaPantColour);
        CustomListeners.test.log(Status.PASS,"Mouse hover and click on Cronus yoga pant" );
    }

    public void mouseHoverAndClickOnAddToCart(){
        Reporter.log("Mouse hover and click on add to cart" + addToCart.toString());
        mouseHoverToElementAndClick(addToCart);
        CustomListeners.test.log(Status.PASS,"Mouse hover and click on add to cart" );
    }

    public String verifyProductAddedToCartMessage(){
        Reporter.log("Get added to cart message" + productAddedToCartMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get added to cart message" );
        return getTextFromElement(productAddedToCartMessage);
    }

    public void clickOnShoppingCartLink(){
        Reporter.log("Click on shopping cart link" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS,"Click on shopping cart link" );
    }

    public void clickOnProductOvernightDuffle(){
        Reporter.log("Click on product Overnight Duffle" + productOvernightDuffle.toString());
        clickOnElement(productOvernightDuffle);
        CustomListeners.test.log(Status.PASS,"Click on product Overnight Duffle" );
    }

    public String verifyOvernightDuffleText(){
        Reporter.log("Get overnight duffle product's text" + productOverNightDuffleText.toString());
        CustomListeners.test.log(Status.PASS,"Get overnight duffle product's text" );
        return getTextFromElement(productOverNightDuffleText);
    }


    public void verifyProductsPriceLowToHigh(){
        List<WebElement> originalList=jacketsPriceElementList;
        //findElementsFromWebPage(By.cssSelector("span[data-price-type='finalPrice']"))
        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductPriceList.add(Double.valueOf(product.getText().replace("$", "")));
        }
        System.out.println("Before Sorting: " + originalProductPriceList);
        List<WebElement> afterSortingList = jacketsPriceElementList;
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductPrice.add(Double.valueOf(product.getText().replace("$", "")));
        }
        Collections.sort(originalProductPriceList);
        System.out.println("After Sorting: " + afterSortingProductPrice);
        Assert.assertEquals(originalProductPriceList, afterSortingProductPrice,"Error");
    }



    public void changeQty(String qty){
        Reporter.log("Change the quantity" + changeField.toString());
        clearTextField(changeField);
        sendTextToElement(changeField, qty);
        CustomListeners.test.log(Status.PASS,"Change the quantity" + qty );
    }

    public void clickOnAddToCartButton(){
        Reporter.log("Click on add to cart" + addToCartButton.toString());
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS,"Click on add to cart" );
    }


}
