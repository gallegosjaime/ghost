import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SingIn {
    @FindBy(xpath = "//input[@type='email']")
    WebElement email;
    @FindBy(xpath = "//input[@type='password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;
    public void Singin(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("paulorossi85@gmail.com");
        password.sendKeys("test@12345");
        submit.click();
    }
}
