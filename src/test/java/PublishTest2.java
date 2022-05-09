import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.How.CSS;

public class PublishTest2 extends BaseTest{

    //#1. Publish a page
    @Test
    public void SuccessPublishPage() {
        //page data
        String title = "Hellow world";
        String description = "This is an example";

        //SingIn
        SingIn.Singin(driver);

        //new page section
        publishPage.newPageButtons(driver);

        //Create page
        publishPage.newPage(driver,title, description);

        //Result
        assertEquals(publishPage.returnMessage().getText(),"Published");
    }

    //#2. Publish a scheduled page
    @Test
    public void ScheduledSuccessfulPublishPage() {
        //page data
        String title = "Hellow world";
        String description = "This is an example";
        String date = "2022-05-25";
        String time = "03:45";

        //Sing In
        SingIn.Singin(driver);

        //new page section
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        publishPage.newPageButtons(driver);

        //Create page
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        publishPage.newScheduledPage(driver, title, description, date, time);
                
        //Result
        try {
            if (publishPage.returnMessage().getText().contains("Scheduled")) System.out.println("Prueba exitosa");
            else System.out.println("Prueba fallida");
        } catch (Exception e) {
            System.out.println("Prueba fallida");
            System.out.println(e);
        }
    }

    //#3 Publish a page without title
    @Test
    public void PublishPageWithoutTitle() {
        //Datos de la página
        String title = "";
        String description = "This is an example";

        //Sing In
        SingIn.Singin(driver);

        //new page section
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        publishPage.newPageButtons(driver);

        //Result
        try {
            //Create page
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            publishPage.newPage(driver, title, description);

            //Validate
            if (publishPage.returnMessage().getText().contains("Published")) System.out.println("Prueba fallida");
        } catch (Exception e) {
            System.out.println("Prueba Exitosa");
            System.out.println(e);
        }
    }

    //#4 Publish a page without discription
    @Test
    public void PublishPageWithoutDescription() {
        //Datos de la página
        String title = "Hello world";
        String description = "";

        //Sing In
        SingIn.Singin(driver);

        //new page section
        publishPage.newPageButtons(driver);

        //Result
        try {
            //Create page
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            publishPage.newPage(driver, title, description);

            //validate
            if (publishPage.returnMessage().getText().contains("Published")) System.out.println("Prueba fallida");
        } catch (Exception e) {
            System.out.println("Prueba Exitosa");
            System.out.println(e);
        }
    }

    //#5 Publish a page without any information
    @Test
    public void PublishPageWithoutAnyInformation() {
        //Datos de la página
        String title = "";
        String description = "";

        //Sing In
        SingIn.Singin(driver);

        //new page section
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        publishPage.newPageButtons(driver);

        //Result
        try {
            //Create page
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            publishPage.newPage(driver, title,description);

            //Validate
            if (publishPage.returnMessage().getText().contains("Published")) System.out.println("Prueba fallida");
        } catch (Exception e) {
            System.out.println("Prueba Exitosa");
            System.out.println(e);
        }
    }

    //#6 Publish a page tith same title
    @Test
    public void PublishPageWithSameTitle() {
        //Datos de la página
        String title = "Hello world";
        String description = "This is an example";

        //Sing In
        SingIn.Singin(driver);

        //new page section
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        publishPage.newPageButtons(driver);

        //Result
        try {
            //Create page
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            publishPage.newPage(driver, title,description);

            //validate
            if (publishPage.returnMessage().getText().contains("Published")) System.out.println("Prueba fallida");
        } catch (Exception e) {
            System.out.println("Prueba Exitosa");
            System.out.println(e);
        }
    }

    //#7. Publish a scheduled page with a date before now
    @Test
    public void ScheduledPublishPageWithDateBeforeNow(){
        //page data
        String title = "Hellow world";
        String description = "This is an example";
        String date = "2022-04-25";
        String time = "03:45";

        //Sing In
        SingIn.Singin(driver);

        //new page section
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        publishPage.newPageButtons(driver);

        //Result
        try{
            //Create page
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            publishPage.newScheduledPage(driver,title,description,date,time);

            //validate
            if (publishPage.returnMessage().getText().contains("Scheduled")) System.out.println("Prueba fallida");
            else System.out.println("Prueba exitosa");
        }catch (Exception e){
            System.out.println("Prueba exitosa");
            System.out.println(e);
        }
    }

    //#8. Publish a scheduled page with a past time
    @Test
    public void ScheduledPublishPageWithPastTime(){
        //page data
        String title = "Hellow world";
        String description = "This is an example";
        String date = "2022-04-28";
        String time = "03:45";

        //Sing In
        SingIn.Singin(driver);

        //new page section
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        publishPage.newPageButtons(driver);

        //Result
        try{
            //Create page
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            publishPage.newScheduledPage(driver,title,description,date,time);

            //validate
            if (publishPage.returnMessage().getText().contains("Scheduled")) System.out.println("Prueba fallida");
            else System.out.println("Prueba exitosa");
        }catch (Exception e){
            System.out.println("Prueba exitosa");
            System.out.println(e);
        }
    }

    //#9. Publish a scheduled page with incorrect time format
    @Test
    public void ScheduledPublishPageWithIncorrectTimeFormat(){
        //page data
        String title = "Hellow world";
        String description = "This is an example";
        String date = "2022-04ddf28";
        String time = "03:45";

        //Sing In
        SingIn.Singin(driver);

        //new page section
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        publishPage.newPageButtons(driver);

        //Result
        try{
            //Create page
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            publishPage.newScheduledPage(driver,title,description,date,time);

            //validate
            if (publishPage.returnMessage().getText().contains("Scheduled")) System.out.println("Prueba fallida");
            else System.out.println("Prueba exitosa");
        }catch (Exception e){
            System.out.println("Prueba exitosa");
            System.out.println(e);
        }
    }
    //#10. Publish a scheduled page with incorrect date format
    @Test
    public void ScheduledPublishPageWithIncorrectDateFormat(){
        //page data
        String title = "Hellow world";
        String description = "This is an example";
        String date = "2022-05-25";
        String time = "03ffffgg:45";

        //Sing In
        SingIn.Singin(driver);

        //new page section
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        publishPage.newPageButtons(driver);

        //Result
        try{
            //Create page
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            publishPage.newScheduledPage(driver,title,description,date,time);

            //validate
            if (publishPage.returnMessage().getText().contains("Scheduled")) System.out.println("Prueba fallida");
            else System.out.println("Prueba exitosa");
        }catch (Exception e){
            System.out.println("Prueba exitosa");
            System.out.println(e);
        }
    }
}


