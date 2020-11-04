package Day12_Project;

import Utils.Tools;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class Task2 extends BaseDriverProject2{
    @Test
    public void testWishList() {
        TestNGProjectElements testNGProjectElements = new TestNGProjectElements(driver);

        testNGProjectElements.apparelShoesLink.click();

        String product1 = testNGProjectElements.blueAndGreenSneaker.getText();
        testNGProjectElements.blueAndGreenSneaker.click();
        testNGProjectElements.addToWishList.click();

        driver.navigate().back();
        String product2 = testNGProjectElements.RockabillyPolkaDot.getText();
        testNGProjectElements.RockabillyPolkaDot.click();
        testNGProjectElements.addToWishList.click();

        testNGProjectElements.wishList.click();

        List<String> selectedProductsList = new ArrayList<>();
        selectedProductsList.add(product1);
        selectedProductsList.add(product2);

        System.out.println(selectedProductsList);

        Tools.compareToList(testNGProjectElements.actualProductLists, selectedProductsList);

//          2. YONTEM:
//        for (WebElement el: testNGProjectElements.actualProductLists) {
//            System.out.println(el.getText());
//            Assert.assertTrue(selectedProductsList.contains(el.getText()));
//        }
    }
}
