package Day01_Annotations_Priority;

import org.testng.annotations.*;

public class _02_Annotations {
/*
      @BeforeClass           -> Her Classdan önce çalışacaklar buraya yazılıyor.
         @BeforeMethod     -> Her metod çalışmadan önce yapılacakları buraya yazıyoruz
                  @Test         -> testimiz
                  @Test
         @AfterMethod       -> Her metod çalıştıktan sonra yapılacakları buraya yazıyoruz.
      @AfterClass           -> Her class dan sonra yapıalcaklar buraya yazılıyor.
 */

    @BeforeClass
    void beforeClass (){
        System.out.println("Class dan once calisacak: Before Class");
    }

    @AfterClass
    void afterClass (){
        System.out.println("Class dan sonra calisacak: After Class");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("Her methoddan once calisacak : Before Method");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("Her methoddan sonra calisacak : After Method");
    }


    @Test
    void test1(){
        System.out.println("Burasi Test 1");
    }

    @Test
    void test2(){
        System.out.println("Burasi Test 2");
    }

}
