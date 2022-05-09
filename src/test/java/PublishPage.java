import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PublishPage {
    protected WebDriverWait wait;
    @FindBy(xpath = "//a[@href='#/pages/']")
    WebElement pages;
    @FindBy(xpath = "//a[@href='#/editor/page/']")
    WebElement newPage;
    @FindBy(tagName = "textarea")
    WebElement title;
    @FindBy(tagName = "p")
    WebElement description;
    @FindBy(className = "gh-publishmenu-trigger")
    WebElement publishWord;
    @FindBy(className = "gh-btn-black")
    WebElement publish;
    @FindBy(className = "gh-notification-title")
    WebElement message;
    @FindBy(xpath = "//div[@class='gh-date-time-picker-date ']/input")
    WebElement date;
    @FindBy(xpath = "//div[@class='gh-date-time-picker-time ']/input")
    WebElement time;
    @FindAll({@FindBy(className = "gh-publishmenu-radio-button")})
    List<WebElement> webElementList;

    public void newPageButtons(WebDriver driver){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(pages));
        pages.click();
        wait.until(ExpectedConditions.visibilityOf(newPage));
        newPage.click();
    }
    public void newPage(WebDriver driver ,String titleTxt, String descriptionTxt){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(title));
        title.sendKeys(titleTxt);
        description.sendKeys(descriptionTxt);
        wait.until(ExpectedConditions.visibilityOf(publishWord));
        publishWord.click();
        publish.click();
        wait.until(ExpectedConditions.visibilityOf(message));
    }
    public void newScheduledPage(WebDriver driver, String titleTxt, String descriptionTxt, String dateTxt, String timeTxt){
        title.sendKeys(titleTxt);
        description.sendKeys(descriptionTxt);
        publishWord.click();
        webElementList.get(1).click();
        date.clear();
        date.sendKeys(dateTxt);
        //clean field
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.gh-date-time-picker-time input').value=''");
        //send time values
        time.sendKeys(timeTxt);
        publish.click();
    }
    public WebElement returnMessage(){
        return message;
    }
}
