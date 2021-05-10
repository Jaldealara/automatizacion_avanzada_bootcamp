package bctsoft.g6.testcases;


import io.github.bonigarcia.wdm.WebDriverManager;
<<<<<<< HEAD
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
=======

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
>>>>>>> 411e24dc8c8d24156ca259cbc92336f887d99a09

import java.util.concurrent.TimeUnit;

public class TestBase {

    //atributo
    protected WebDriver driver;
<<<<<<< HEAD
    @Before
=======
    @BeforeClass
>>>>>>> 411e24dc8c8d24156ca259cbc92336f887d99a09
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
    }
    /*

     */

<<<<<<< HEAD
    @After
=======
    @AfterClass
>>>>>>> 411e24dc8c8d24156ca259cbc92336f887d99a09
    public void close(){
        driver.close();
    }


}
