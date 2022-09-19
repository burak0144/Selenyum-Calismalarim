import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Calismalarim3 {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
      //  driver.close();
    }
    @Test
    public void test(){
        // Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        // Verify that home page is visible successfully
        WebElement homePageWE=driver.findElement(By.xpath("//a[@style='color: orange;']"));
        String actualPage=homePageWE.getText();
        String expectedPage="Home";
        Assert.assertEquals(actualPage,expectedPage);

        // Click on 'Signup / Login' button
        WebElement signUpLogin= driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        signUpLogin.click();
        // Verify 'Login to your account' is visible.
       WebElement loginButtonWE=driver.findElement(By.xpath("//a[@href='/login']"));
       Assert.assertTrue(loginButtonWE.isDisplayed());
        // Enter incorrect email address and password.
        WebElement emailWE=driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        WebElement passwordWE=driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        emailWE.sendKeys("berk@gmail.com");
        passwordWE.sendKeys("1234");
        // Click 'login' button.
        WebElement sigInWE=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        sigInWE.click();

        // Verify error 'Your email or password is incorrect!' is visible.
        WebElement errorWE=driver.findElement(By.xpath("(//p[text()='Your email or password is incorrect!'])"));
        String actualWord=errorWE.getText();
        String expectedWord="Your email or password is incorrect!";

        Assert.assertEquals(actualWord,expectedWord);
    }
}
