import Pages.EgyptSupscriptionPage;
import Pages.HomePage;
import org.testng.annotations.Test;

public class EgeptPackageTests extends TestBase{
    EgyptSupscriptionPage PackageObject;
    HomePage homePage;

    @Test
    public void Verify_That_PackagesTypesAndPricesEgypt_Are_Correct(){
        homePage = new HomePage(driver);
        PackageObject= new EgyptSupscriptionPage(driver);
        homePage.Click_on_Country_icon();
        PackageObject.Select_country_Egypt();
        PackageObject.Validate_on_Supscription_Types();
        PackageObject.Validate_on_PriceAndCurrency();

    }

}
