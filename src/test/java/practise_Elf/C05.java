package practise_Elf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C05 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // ...Exercise5...
        // @BeforeClass'in icine driver'i kuralim
        // maximize edip tum web elementler yuklenene kadar 10sn bekletelim
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown() {
        // @AfterClass to driver'i kapatalim
        driver.close();
    }

    @Test
    public void googleTest() {

        // Google'a gidelim ve sayfa basliginin "Google" icerdigini dogrulayalim
        driver.get("https://google.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void amazonTest() {
        // Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
       driver.get("https://www.amazon.com");
        String actual=driver.getCurrentUrl();
        String expected="www.amazon.com";
        Assert.assertTrue(actual.contains(expected));

    }
}