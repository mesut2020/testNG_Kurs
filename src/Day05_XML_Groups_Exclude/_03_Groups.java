package Day05_XML_Groups_Exclude;

import org.testng.annotations.Test;

public class _03_Groups {

    @Test(groups = "Regression")  // Regression: Sistemin tumunu kontrol eden teste verilen isim...
    public void test1(){ System.out.println("Test 1 Regression");  }

    @Test(groups = "Regression")
    public void test2(){ System.out.println("Test 2 Regression");  }

    @Test(groups = "Regression")
    public void test7(){ System.out.println("Test 7 Regression");  }

    @Test(groups = "Regression")
    public void tes5(){ System.out.println("Test 5 Regression");  }

    @Test(groups = "SmokeTest")   // SmokeTest ise sistemin en genel haliyle calsitirildiginin testi
    public void test3(){ System.out.println("Test 3 SmokeTest");  }

    @Test(groups = "SmokeTest")
    public void test4(){ System.out.println("Test 4 SmokeTest");  }

    @Test
    public void test6(){ System.out.println("Test 6 ");  }
}
