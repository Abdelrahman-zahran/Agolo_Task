package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    @FindBy(xpath = "(//a[contains(.,'English')])[1]")
    WebElement Language_Btn;
    @FindBy(css = "span[id='arrow'] img")
    WebElement countries_icon;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void Click_on_Country_icon(){
        clickButton(countries_icon);
    }
    public void Click_on_Language_Button(){
        clickButton(Language_Btn);
    }

}
