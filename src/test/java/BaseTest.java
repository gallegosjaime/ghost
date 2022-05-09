
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected SingIn SingIn;
    protected PublishPage publishPage;

    @Before
    public void beforeTest(){
        driver = new ChromeDriver();
        SingIn = new SingIn();
        publishPage = new PublishPage();
        driver.get("http://localhost:2368/ghost");
        driver.getPageSource();
        PageFactory.initElements(driver, SingIn);
        PageFactory.initElements(driver, publishPage);
    }
    @After
    public void cleanTest(){
        driver.close();
    }
}
