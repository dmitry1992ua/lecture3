import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * Created by dmitr on 16.04.2017.
 */
public class WebDriverLogger extends AbstractWebDriverEventListener {

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Go to: " + url);

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Find element: " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clck on: " + element.getTagName() + " " + element.getText());
    }


    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Enter value: " + charSequenceArrToString(keysToSend));
    }

    private String charSequenceArrToString(CharSequence[] arr) {
        String result = "";
        for (CharSequence a : arr) {
            result += a;
        }
        return result;
    }
}