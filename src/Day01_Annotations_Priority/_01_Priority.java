package Day01_Annotations_Priority;

import org.testng.annotations.Test;

public class _01_Priority {
    //  Eger Test metodlarina siralama verilmezse alafabetik siraya gore calisir...
    @Test(priority = 1)
    void webSitesiAc() {
        System.out.println("Driver tanımlandı, ve web sitesi açıldı...");
    }

    @Test (priority = 2)
    void loginTest(){
        System.out.println("Login test işlemleri yapıldı");
    }

    @Test (priority = 3)
    void driverKapat(){
        System.out.println("Driver kapatıldı ve çıkıldı.");
    }
}
