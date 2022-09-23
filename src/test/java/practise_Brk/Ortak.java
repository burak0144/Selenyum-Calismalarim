package practise_Brk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Ortak {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //  driver.close();
    }

    @Test
    public void test() {
        driver.get("https://www.amazon.com/hz/wishlist/ls/PQO3YEU90ZA4?type=wishlist&ref=cm_wl_list_create&relatedRequestID=E8AZ3CS4X3M59CB2CSW9");
        System.out.println(driver.getTitle());
        List<WebElement> list=driver.findElements(By.cssSelector("#your-lists-nav"));
        for (WebElement element : list)
              {
                  System.out.println(element);
        }
    }
}