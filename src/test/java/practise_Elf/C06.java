package practise_Elf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C06 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // ...Exercise5...
        // @BeforeClass'in icine driver'i kuralim
        // maximize edip tum web elementler yuklenene kadar 10sn bekletelim
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown() {

        driver.close();
    }

    @Test
    public void amazonTest() {
        // 1. Amazon.com'a gidelim
        driver.get("https://amazon.com");

        // 2. DropDown uzerinde Books secelim.(All yazan yerde)
        WebElement ddm=driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");
        //    kategorilerin hepsini konsola yazdiralim
        List<WebElement> ddmList=select.getOptions();
        ddmList.forEach(t-> System.out.println(t.getText()));
        // 3. Arama kutusuna Les Miserables yazalim ve arama yapalim.
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Les Miserables", Keys.ENTER);
        // 4. Sonuc sayisini ekrana yazdiralim.
        WebElement sonuc=driver.findElement(By.xpath("//span[text()='1-16 of over 5,000 results for']"));
       String[] sonucArr = sonuc.getText().split(" ");
        System.out.println("sonuc sayisi ="+sonucArr[3]);
        // 5. Sonuclarin Les Miserables i icerdigini assert edelim
        String actual=driver.findElement(By.xpath("//span[text()='\"Les Miserables\"']")).getText();
        Assert.assertTrue(actual.contains("Les Miserables"));
    }
}