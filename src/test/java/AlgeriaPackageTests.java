import Pages.AlgeriaSupscriptionPage;
import Pages.HomePage;
import org.testng.annotations.Test;

public class AlgeriaPackageTests extends TestBase{
    AlgeriaSupscriptionPage Package;
    HomePage homePage;

    @Test
    public void Verify_That_PackagesTypesAndPricesAlgeria_Are_Correct(){
        homePage = new HomePage(driver);
        Package = new AlgeriaSupscriptionPage(driver);
        homePage.Click_on_Country_icon();
        Package.Select_country_Algeria();
        Package.Validate_on_Supscription_Types();
        Package.Validate_on_PriceAndCurrency();

    }
}
