package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class PageBase {

    public WebDriver driver ;
    public JavascriptExecutor jse ;
    public Select select ;
    public Actions action ;
    public Robot robot;
    public WebDriverWait explicit;



    // create constructor
    public PageBase(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    protected static void clickButton(WebElement button)
    {
        button.click();
    }

    protected static void setTextElementText(WebElement textElement , String value)
    {
        textElement.sendKeys(value);
    }
    public void Press_on_Enter() throws AWTException {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

    }

    public void Press_on_Tab() throws AWTException {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(2000);
    }

    public void Press_on_Escape() throws AWTException {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        robot.delay(2000);
    }

    public void Press_on_Arrow_Down() throws AWTException {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.delay(2000);
    }
    public void selectOption(WebElement Welement, String selectedValue){
        select = new Select(Welement);
        select.selectByValue(selectedValue);
    }
    public void selectOptionbyText(WebElement Welement, String selectedText){
        select = new Select(Welement);
        select.selectByVisibleText(selectedText);
    }
    public void Scroll_Into_View(WebElement selement){
        jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].scrollIntoView();",selement);
    }
    public void scrollToBottom()

    {
        jse = ((JavascriptExecutor) driver);
        jse.executeScript("scrollBy(0,2500)");
    }

    public void clearText(WebElement element)
    {
        element.clear();
    }
    public void Wait(WebElement Welemet){
        explicit = new WebDriverWait(driver, Duration.ofSeconds(300));
        explicit.until(ExpectedConditions.visibilityOf(Welemet));

    }
    public void Wait_Until_Element_Is_Not_Visible(WebElement Welemet){
        explicit = new WebDriverWait(driver, Duration.ofSeconds(300));
        explicit.until(ExpectedConditions.invisibilityOf(Welemet));
    }
    public void Wait_to_Be_Clickable(WebElement celement){
        explicit = new WebDriverWait(driver, Duration.ofSeconds(300));
        explicit.until(ExpectedConditions.elementToBeClickable(celement));





    }


    public void scrollToTarget(WebElement target){
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", target);
    }
    public  void windowHandles(String value) {
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentURL = it.next();
        String childURL = it.next();
        if (value == "parent") {
            driver.switchTo().window(parentURL);
        }
        if (value == "child") {
            driver.switchTo().window(childURL);
        }
    }
    public void switchToChildWindowAndCloseIt() throws InterruptedException {
        String parent = driver.getWindowHandle();

        Thread.sleep(1000);
        Set<String> availableWindows = driver.getWindowHandles();
        String newWindow = null;
        for (String window : availableWindows) {
            if (!parent.equals(window)) {
                newWindow = window;
            }
        }
        if (newWindow != null) {
            WebDriver op = driver.switchTo().window(newWindow);
            //("Driver switched to new window: " + op.getTitle() + " | " + op.getCurrentUrl());

        }
    }
    public void returnDataOfTable(WebElement table) {
        List <WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List <WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.println(col.getText());
            }

        }
    }
}
