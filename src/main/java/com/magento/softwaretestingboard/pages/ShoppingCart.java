package com.magento.softwaretestingboard.pages;

import com.aventstack.extentreports.Status;
import com.magento.softwaretestingboard.customlisteners.CustomListeners;
import com.magento.softwaretestingboard.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCart extends Utility {


    @CacheLookup
    @FindBy(xpath = "//span[@class='base']")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")
    WebElement productCronusYogaPantName;

    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'32')]")
    WebElement productYogaPantSizeText;

    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'Black')]")
    WebElement productCronusYogaPantColourText;

    @CacheLookup
    @FindBy(xpath = "//td[@class='col item']//a[normalize-space()='Overnight Duffle']")
    WebElement productOvernightDuffleText;

    @CacheLookup
    @FindBy(xpath = "//input[@title='Qty']")
    WebElement productOverNightDuffleQtyText;

    @CacheLookup
    @FindBy(xpath = "//td[@class='col subtotal']//span[@data-label='Excl. Tax']")
    WebElement productOvernightDufflePriceText;

    @CacheLookup
    @FindBy(xpath = "//input[@class='input-text qty'][1]")
    WebElement qtyFieldInCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='cart main actions']/descendant::button[2]")
    WebElement updateShoppingCartButton;

    @CacheLookup
    @FindBy(xpath = "//td[@data-th='Subtotal']//span[@class='price']")
    WebElement productPrice;


    public String verifyShoppingCartTitle(){
        Reporter.log("Get shopping cart title" + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS,"Get shopping cart title" );
        return getTextFromElement(shoppingCartText);
    }

    public String verifyProductCronusYogaPantName(){
        Reporter.log("Get Cronus yoga pant name" + productCronusYogaPantName.toString());
        CustomListeners.test.log(Status.PASS,"Get Cronus yoga pant name" );
        return getTextFromElement(productCronusYogaPantName);
    }

    public String verifyProductCronusYogaPantSizeText(){
        Reporter.log("Get product cronus yoga pant size text" + productYogaPantSizeText.toString());
        CustomListeners.test.log(Status.PASS,"Get product cronus yoga pant size text" );
        return getTextFromElement(productYogaPantSizeText);
    }

    public String verifyProductCronusYogaPantColourText(){
        Reporter.log("Get product cronus yoga pant colour text" + productCronusYogaPantColourText.toString());
        CustomListeners.test.log(Status.PASS,"Get product cronus yoga pant colour text" );
        return getTextFromElement(productCronusYogaPantColourText);
    }

    public String verifyProductNameOvernightDuffle(){
        Reporter.log("Get product overnight duffle text" + productOvernightDuffleText.toString());
        CustomListeners.test.log(Status.PASS,"Get product overnight duffle text" );
        return getTextFromElement(productOvernightDuffleText);
    }

    public String verifyProductOvernightDuffleQtyText(String value){
        Reporter.log("Get product overnight duffle quantity text" + productOverNightDuffleQtyText.toString());
        CustomListeners.test.log(Status.PASS,"Get product overnight duffle quantity text" );
        return getAttributeValue(productOverNightDuffleQtyText, value);
    }

    public String verifyProductOvernightDufflePriceText(){
        Reporter.log("Get product overnight duffle price text" + productOvernightDufflePriceText.toString());
        CustomListeners.test.log(Status.PASS,"Get product overnight duffle price text" );
        return getTextFromElement(productOvernightDufflePriceText);
    }

    public void changeFieldInCart(String qty){
        Reporter.log("Changing the field in cart" + qtyFieldInCart.toString());
        clearTextField(qtyFieldInCart);
        sendTextToElement(qtyFieldInCart,qty);
        CustomListeners.test.log(Status.PASS,"Changing the field in cart" + qty);
    }

    public void updateShoppingCart(){
        Reporter.log("Update shopping cart" + updateShoppingCartButton.toString());
        clickOnElement(updateShoppingCartButton);
        CustomListeners.test.log(Status.PASS,"Update shopping cart" );
    }

    public String verifyProductPrice(){
        Reporter.log("Get product price" + productPrice.toString());
        CustomListeners.test.log(Status.PASS,"Get product price" );
        return getTextFromElement(productPrice);
    }
}
