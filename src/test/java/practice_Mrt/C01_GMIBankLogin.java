package practice_Mrt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_GMIBankLogin {
    public static void main(String[] args) {
        //https://www.gmibank.com/ adresine gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.gmibank.com/");

        //Sign In butonuna tikla
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();

        driver.findElement(By.xpath("//span[text()='Sign in']")).click();

       //Username: Batch81, Password: Batch81+
        driver.findElement(By.cssSelector("#username")).sendKeys("Batch81");
        driver.findElement(By.cssSelector("#password")).sendKeys("Batch81+", Keys.ENTER);

       driver.close();


    }

}
