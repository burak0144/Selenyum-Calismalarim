import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Calismalarim2 {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
         driver.close();
    }
    @Test
    public void test(){
        // Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        //Verify that home page is visible successfully
        WebElement homeButtonWE =driver.findElement(By.xpath("//a[@style='color: orange;']"));

        if (homeButtonWE.isDisplayed()){
            System.out.println("Home Button is visible successfully");
        }else {
            System.out.println("Home Button is not visible successfully");
        }
        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //Verify 'Login to your account' is visible
        WebElement LoginButtonWE=driver.findElement(By.xpath("(//h2)[1]"));
        if (LoginButtonWE.isDisplayed()){
            System.out.println("Login Button is visible");
        } else {
            System.out.println("Login Button is not visible");
        }
        // 6. Enter correct email address and password
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("karanfilkaranfil822@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("karanfil822");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement LoginUserAsNameWE= driver.findElement(By.xpath("//b[text()='Berk01']"));
        if (LoginUserAsNameWE.isDisplayed()) {
            System.out.println("LoginUserAsName is visible");
        }else {
            System.out.println("LoginUserAsName is not visible");
        }
        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDeletedWE=driver.findElement(By.xpath("//h1"));
        if (accountDeletedWE.isDisplayed()){
            System.out.println("Account deleted is visible");
        }else {
            System.out.println("Account deleted is not visible");
        }

    }
}
