package Steps;

import Base.BaseUtil;
import Pages.SignUpPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpStep extends BaseUtil {

    private BaseUtil base;

    public SignUpStep(BaseUtil base) {
        this.base = base;
    }
    @Given("I navigate to the main page")
    public void iNavigateToTheMainPage() {
        base.Driver.navigate().to("https://executeautomation.com/");
        base.Driver.manage().window().maximize();
    }

    @And("I click SignUp button to insert data")
    public void iClickSignUpButtonToInsertData() {
        base.Driver.findElement(By.linkText("Start Learning")).click();
    }

    @And("I insert the following credentials")
    public void iInsertTheFollowingCredentials(DataTable dataTable) {
        SignUpPage page = new SignUpPage(base.Driver);
        page.InsertInfo(dataTable.cell(1,0), dataTable.cell(1,1), dataTable.cell(1,2),
                        dataTable.cell(1,3), dataTable.cell(1,4), dataTable.cell(1,5));
    }

    @And("I select the avatar picture")
    public void iSelectTheAvatarPicture() {
        SignUpPage page = new SignUpPage(base.Driver);
        page.SelectAvatar();
    }

    @And("I click confirmation button")
    public void iClickConfirmationButton() {
        SignUpPage page = new SignUpPage(base.Driver);
        page.Confirm();
    }

    @Then("I should see the popUp")
    public void iShouldSeeThePopUp() {
        SignUpPage page = new SignUpPage(base.Driver);
        new WebDriverWait(base.Driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(page.popUp));
        Assertions.assertTrue(page.isPopUpActive());
    }
}
