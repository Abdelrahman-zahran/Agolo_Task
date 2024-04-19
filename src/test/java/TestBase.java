import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver ;
    HomePage homePage;
    @BeforeSuite
    public void openBrowser() {


        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

        //set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://subscribe.stctv.com/");
        homePage = new HomePage(driver);
        homePage.Click_on_Language_Button();




    }

    @AfterSuite
    public void quitDriver()  {

        driver.quit();
    }
}
