package Day01_Annotations_Priority;

import org.testng.annotations.*;

public class Annotations2 {

  /*
  @BeforeSuite
    @BeforeTest  --
      @BeforeClass  --
        @BeforeMethod -- ne kadar test case varsa o kadar kullanilir
          @Test  -- 1 tane Test Case
        @AfterMethod ----- ne kadar test case varsa o kadar kullanilir
      @AfterClass
    @AfterTest
  @AfterSuite

   */


        @BeforeSuite
        public void setUp(){
            System.out.println("@BeforeSuite -- Chrome set up");
        }

        @BeforeTest
        public void launchBrowser(){
            System.out.println("@BeforeTest --Launch browser");
        }

        @BeforeClass
        public void login(){
            System.out.println("@BeforeClass --- login to website");
        }

        @BeforeMethod                         // Her bir Test case den once calisir...
        public void enterURl(){
            System.out.println("@BeforeMethod-- Enter URL");
        }

        @Test
        public void getTitle(){
            System.out.println("Test Case 1-- website Title test");
        }

        @Test
        public void searchTest(){
            System.out.println("Test Case 2-- search test");
        }


        @AfterMethod              // Her bir Test case den sonra calisir...
        public void logOut(){
            System.out.println("@AfterMethod --log out from website");
        }


        @AfterClass
        public void closeBrowser(){
            System.out.println("@AfterClass --close website");
        }

        @AfterTest
        public void deleteAllCookies(){
            System.out.println("@AfterTest --Delete all cookies");
        }

        @AfterSuite
        public void generateReport(){
            System.out.println("@AfterSuite --generate report");
        }
    }

