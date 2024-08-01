import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;

    public SoftAssert softAssert;

    @BeforeMethod
    public void beforeMethod() {

        driver = new ChromeDriver();
        driver.get("https://boom.tv/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void afterMethod() {

        driver.close();
        driver.quit();


    }


    @Test

    public void Login() throws InterruptedException {

        Thread.sleep(5000);
        WebElement signInBtn = driver.findElement(By.xpath("(//a[@class='nav_link user show'])[1]"));
        signInBtn.click();


        WebElement userName = driver.findElement(By.xpath("(//input[@name='email'])[1]"));
        userName.sendKeys("navin123");

        WebElement password = driver.findElement(By.xpath("(//input[@placeholder='Enter your password'])[1]"));
        password.sendKeys("9589120674");

        WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Login Now']"));
        loginBtn.click();

        softAssert = new SoftAssert();

        String title = driver.getTitle();

        System.out.println(driver.getTitle());

        softAssert.assertEquals(title, "BOOM.TV -LIVE", "Title should match");


    }


    @Test

    public void signUp() throws InterruptedException {

        Thread.sleep(5000);
        WebElement signInBtn = driver.findElement(By.xpath("(//a[@class='nav_link user show'])[1]"));
        signInBtn.click();

        WebElement signupPge = driver.findElement(By.xpath("((//a[text()='Sign Up'])[1]"));
        signupPge.click();


        WebElement usrNme = driver.findElement(By.xpath("(//input[@placeholder='Enter your username'])[1]"));
        usrNme.sendKeys("navin123");

        WebElement email = driver.findElement(By.xpath("(//input[@placeholder='Enter your email'])[1]"));
        email.sendKeys("navinbisen@outlook.com");

        WebElement passwd = driver.findElement(By.xpath("(//input[@placeholder='Enter your password'])[1]"));
        passwd.sendKeys("9589120674");


        WebElement passwdCnfm = driver.findElement(By.xpath("(//input[@placeholder='Confirm your password'])[1]"));
        passwdCnfm.sendKeys("9589120674");


        WebElement registerBTN = driver.findElement(By.xpath("(//button[@id='admin_login_register_btn']"));
        registerBTN.click();

        
    }
}