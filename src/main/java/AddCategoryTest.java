import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;


/**
 * Created by dmitr on 16.04.2017.
 */
public class AddCategoryTest {

    private static final String URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private static final String USER_LOGIN = "webinar.test@gmail.com";
    private static final String USERR_PASSWORD = "Xcg7299bnSmMuRLp9ITw";
    private static final String ALLERT_TEXT = "Создано";
    private static final String CATEGORY_NAME = "testCategory";


    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.initWebDriver("chrome");

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        eventDriver.register(new WebDriverLogger());

        eventDriver.get(URL);
        login(eventDriver);
        Actions builder = new Actions(driver);
        WebElement element = eventDriver.findElement(By.xpath("//span[contains(text(), 'Каталог')]"));
        builder.moveToElement(element).build().perform();
        element = eventDriver.findElement(By.xpath("//a[contains(text(),'категории')]"));
        element.click();
        element = eventDriver.findElement(By.className("process-icon-new"));
        element.click();
        element = eventDriver.findElement(By.id("name_1"));
        element.sendKeys(CATEGORY_NAME);
        element = eventDriver.findElement(By.id("category_form_submit_btn"));
        element.click();
        element = eventDriver.findElement(By.className("alert-success"));
        if (!element.getText().contains(ALLERT_TEXT)) {
            System.out.println("False");
        }
        element = eventDriver.findElement(By.xpath("//span[contains(text(), 'Имя')]//i[@class='icon-caret-down']"));
        element.click();
        element = eventDriver.findElement(By.xpath("//*[contains(text(), 'testCategory')]"));
        if (!element.getText().contains(CATEGORY_NAME)) {
            System.out.println("False");
        }
        eventDriver.close();
    }

    private static void login(WebDriver driver) {
        driver.findElement(By.id("email")).sendKeys(USER_LOGIN);
        driver.findElement(By.id("passwd")).sendKeys(USERR_PASSWORD);
        driver.findElement(By.className("ladda-button")).click();
    }
}
