package Day08_DataPrivider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_Giris {
    @Test(dataProvider = "getData") // senin dataproviderın getData isimli metoddur
    public void UsernameTest(String username)
    {
        System.out.println(username  );
    }


    /**
     * Data provider must return Object[][]/Object[] or Iterator<Object[]>/Iterator<Object>
     */
    @DataProvider // bu metoda dataprovider görevi verildi.
    public Iterator<Object> getData() // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
    {
        List<Object> data = new ArrayList<>();
        data.add("ahmet");
        data.add("ayse");
        data.add("ali");
        data.add("Fatma");

        return data.iterator();
    }

    /*************************************************/
    /*********   2 Boyutlu *****************************/

    @Test(dataProvider = "getData2") // senin dataproviderın getData isimli metoddur
    public void UsernameTest2(String username, String password)
    {
        System.out.println(username + "   "+ password );
    }


    /**
     * Data provider must return Object[][]/Object[] or Iterator<Object[]>/Iterator<Object>
     */
    @DataProvider // bu metoda dataprovider görevi verildi.
    public Iterator<Object[]> getData2() // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
    {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[] {"Ali","xyz"});  // List in her bir elemani Object dizi oldugu icin Object dizisi eklendi...
        data.add(new Object[] {"Mehmet","abc"});
        data.add(new Object[] {"Ayse","123"});

        return data.iterator();
    }


}
