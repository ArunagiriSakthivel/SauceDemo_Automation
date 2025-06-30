package pagesTests;

import org.testng.annotations.Test;
import pages.ProductCount;
import setup.BaseTest;

public class ProductCountTest extends BaseTest {


    @Test(priority = 2)
    public void productCountTest() {

        int numberOfProduct = new ProductCount(driver).getProductCount();
        System.out.println("Number of Product in the Page"+numberOfProduct);
        new ProductCount(driver).printProductNames();

    }

}
