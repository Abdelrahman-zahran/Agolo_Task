package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class UAESupscriptionPage extends PageBase{

    @FindBy(id = "ae-contry-flag")
    WebElement UAE_country_flag;

    @FindBy(css = "strong[class=\"plan-title\"]")
    List<WebElement> SupscriptionTypes;
    @FindBy(css = "div[class=\"price\"]")
    List<WebElement> PriceAndCurrency;
    public UAESupscriptionPage(WebDriver driver) {
        super(driver);
    }
    public void Select_country_UAE(){
        clickButton(UAE_country_flag);
    }
    public void Validate_on_Supscription_Types(){
        String[ ] ExpectedResultSupscriptionTypes = {"Lite","Classic","Premium"};
        int i = 0;
        for(WebElement e : SupscriptionTypes) {
            String ActualResultSupscriptionTypes = e.getText();
            Assert.assertEquals(ActualResultSupscriptionTypes.toLowerCase(),(ExpectedResultSupscriptionTypes[i].toLowerCase()));
            i++;
        }

    }
    public void Validate_on_PriceAndCurrency(){
        String [] ExpectedResultPriceAndCurrency = {"5.4 USD/month", "10.9 USD/month", "16.3 USD/month"};
        int j =0 ;
        for(WebElement a : PriceAndCurrency) {
            String ActualResultPriceAndCurrency = a.getText();

            Assert.assertEquals(ActualResultPriceAndCurrency.toLowerCase(),(ExpectedResultPriceAndCurrency[j].toLowerCase()));
            j++;
        }
    }

}
