package Day09_SoftAssertHardAssert_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertHardAssert {

    @Test
    public void hardAssert(){
        String s1="Merhaba";

        System.out.println("Hard Assert oncesi...");
        Assert.assertEquals("Merhaba123", s1);
        System.out.println("Hard Assert sonrasi...");
    }

    @Test
    public void softAssert(){
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert _softAssert = new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage);
        System.out.println("assert 1");
        _softAssert.assertEquals("www.facebook.com/profile", strCartPage);
        System.out.println("assert 2");
        _softAssert.assertEquals("www.facebook.com/abc", strEditAccount);
        System.out.println("assert 3");

        _softAssert.assertAll(); // butun assertleri aktif ediyor
        System.out.println("kod bitis..."); // bu bolum assert All oldugu icin  ve assertlerde fail oldugu icin burasi CALISMAZ...
    }
}
