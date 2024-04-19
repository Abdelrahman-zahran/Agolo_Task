import Pages.HomePage;
import Pages.UAESupscriptionPage;
import org.testng.annotations.Test;

public class UAEPackageTests extends TestBase {
    UAESupscriptionPage packObject;
    HomePage homePage;
    @Test
    public void Verify_That_PackagesTypesAndPricesUAE_Are_Correct(){
        homePage = new HomePage(driver);
        packObject = new UAESupscriptionPage(driver);
        homePage.Click_on_Country_icon();
        packObject.Select_country_UAE();
        packObject.Validate_on_Supscription_Types();
        packObject.Validate_on_PriceAndCurrency();

    }
}
