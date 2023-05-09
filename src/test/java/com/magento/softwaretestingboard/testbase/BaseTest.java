package com.magento.softwaretestingboard.testbase;

import com.magento.softwaretestingboard.propertyreader.PropertyReader;
import com.magento.softwaretestingboard.utilities.Utility;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Jay Vaghani
 */
public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        selectBrowser(browser);
    }

    /*@AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeBrowser();
    }*/
}
