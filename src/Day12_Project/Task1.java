package Day12_Project;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task1 extends BaseDriverProject2 {
@Test
@Parameters("message")
    public void testSubmitMessage(String message){
        TestNGProjectElements testNGProjectElements = new TestNGProjectElements(driver);

        testNGProjectElements.contactUs.click();
        testNGProjectElements.enquiryTextBox.sendKeys(message); //"Burdan bir garip mi gecti dersiniz..."
        testNGProjectElements.submitButton.click();

        String actualMessage = testNGProjectElements.submitMessage.getText();
        Assert.assertTrue(actualMessage.contains("successfully"));
    }
}
