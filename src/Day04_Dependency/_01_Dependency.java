package Day04_Dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {
    @Test
    void startCar()
    {
        System.out.println("Car startCar");
        Assert.fail(); // hata oluşturur
    }

    @Test(dependsOnMethods = {"startCar"})  // bu testin çalışması, startCar ın hatasız çalışmasına bağımlı
    void driveCar()
    {
        System.out.println("Car driveCar");
    }

    @Test(dependsOnMethods = {"driveCar"}) // bu testin çalışması, driveCar ın hatasız çalışmasına bağımlı
    void stopCar()
    {
        System.out.println("Car stopCar");
    }

    @Test(dependsOnMethods = {"stopCar","driveCar"}, alwaysRun = true) //alwaysRun = true bağımlılıkları var ama hata çıkarsa da yine çalıştır
    void parkCar()
    {
        System.out.println("Car parkCar");
    }
}