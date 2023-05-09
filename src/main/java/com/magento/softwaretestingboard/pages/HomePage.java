package com.magento.softwaretestingboard.pages;

import com.aventstack.extentreports.Status;
import com.magento.softwaretestingboard.customlisteners.CustomListeners;
import com.magento.softwaretestingboard.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Women')]")
    WebElement womenTab;

    @CacheLookup
    @FindBy(css = "a[id='ui-id-9'] span:nth-child(1)")
    WebElement topsInWomenDropdown ;

    @CacheLookup
    @FindBy(css = "a[id='ui-id-11'] span:nth-child(1)")
    WebElement jacketsInTops;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Men']")
    WebElement mensTab;

    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-18']")
    WebElement bottomsInMensDropdown;

    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-23']//span[contains(text(),'Pants')]")
    WebElement pantsInBottoms;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Gear']")
    WebElement gearTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Bags']")
    WebElement bagsInGear;


    public void mouseHoverOnWomenTab(){
        Reporter.log("Mouse hover on womensTab" + womenTab.toString());
        mouseHoverToElement(womenTab);
        CustomListeners.test.log(Status.PASS,"Mouse hover on womensTab" );

    }

    public void mouseHoverOnTopsInWomenTab(){
        Reporter.log("Mouse hover on womensTab and on tops" + topsInWomenDropdown.toString());
        mouseHoverToElement(topsInWomenDropdown);
        CustomListeners.test.log(Status.PASS,"Mouse hover on womensTab and on tops" );


    }

    public void mouseHoverAndClickOnJacketsInWomen(){
        Reporter.log("Mouse hover on womensTab and then top and click on jackets" + jacketsInTops.toString());
        mouseHoverToElementAndClick(jacketsInTops);
        CustomListeners.test.log(Status.PASS,"Mouse hover on womensTab and then top and click on jackets" );
    }

    public void mouseHoverOnMensTab(){
        Reporter.log("Mouse hover on mensTab" + mensTab.toString());
        mouseHoverToElement(mensTab);
        CustomListeners.test.log(Status.PASS,"Mouse hover on mensTab" );
    }

    public void mouseHoverOnBottomsInMensTab(){
        Reporter.log("Mouse hover on mensTab and on bottoms" + bottomsInMensDropdown.toString());
        mouseHoverToElement(bottomsInMensDropdown);
        CustomListeners.test.log(Status.PASS,"Mouse hover on mensTab and on bottoms" );
    }

    public void mouseHoverAndClickOnPantsInBottoms(){
        Reporter.log("Mouse hover on mensTab and on bottoms and click pants" + pantsInBottoms.toString());
        mouseHoverToElementAndClick(pantsInBottoms);
        CustomListeners.test.log(Status.PASS,"Mouse hover on mensTab and on bottoms and click pants" );
    }

    public void mouseHoverOnGearTab(){
        Reporter.log("Mouse hover on gearTab" + gearTab.toString());
        mouseHoverToElement(gearTab);
        CustomListeners.test.log(Status.PASS,"Mouse hover on gearTab" );
    }

    public void mouseHoverAndClickOnBagsInGear(){
        Reporter.log("Mouse hover on gearTab and click on bags" + bagsInGear.toString());
        mouseHoverToElementAndClick(bagsInGear);
        CustomListeners.test.log(Status.PASS,"Mouse hover on gearTab and click on bags" );
    }
}
