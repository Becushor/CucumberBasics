package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import Pages.SignUpPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to the main web page")
    public void iNavigateToTheMainWebPage() {
        base.Driver.navigate().to("https://executeautomation.com/");
        base.Driver.manage().window().maximize();
    }

    @And("I click sign in button to insert data")
    public void iClickSignInButtonToInsertData() {
        base.Driver.findElement(By.linkText("Sign In")).click();
    }

    @And("I insert correct email and password")
    public void iInsertCorrectEmailAndPassword(DataTable dataTable) {
        LoginPage page = new LoginPage(base.Driver);
        page.Signin(dataTable.cell(1,0), dataTable.cell(1,1));
    }

    @And("I click sign in button")
    public void iClickSignInButton() {
        LoginPage page = new LoginPage(base.Driver);
        page.ClickSignin();
    }

    @Then("I should see the user page")
    public void iShouldSeeTheUserPage() {
        base.Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement btnUpdateProfile = base.Driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/form/div[4]/button"));
        Assertions.assertTrue(btnUpdateProfile.isDisplayed());
    }
}
