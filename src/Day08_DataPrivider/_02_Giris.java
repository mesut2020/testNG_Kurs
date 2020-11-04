package Day08_DataPrivider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_Giris {
    @Test(dataProvider = "getData") // senin dataproviderın getData isimli metoddur
    public void UsernameTest(String username,  String password)
    {
        System.out.println(username + "  "+ password );
    }


    /**
     * Data provider must return Object[][]/Object[] or Iterator<Object[]>/Iterator<Object>
     */
    @DataProvider // bu metoda dataprovider görevi verildi.
    public Object[] getData() // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
    {
        Object[][] data={
                {"ahmet", "abc"},
                {"ayşe", "xyz"},
                {"mehmet", "123"}
        };
        return data;
    }


}
