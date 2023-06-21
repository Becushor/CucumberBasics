package Steps;

import Base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        base.Driver.navigate().to("http://eaapp.somee.com/");
    }

    @And("I click login button to insert data")
    public void iClickLoginButtonToInsertData() {
       base.Driver.findElement(By.linkText("Login")).click();
    }

    @And("I insert username and password")
    public void iInsertUsernameAndPassword(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();
        base.Driver.findElement(By.id("UserName")).sendKeys(dataTable.cell(1,0));
        base.Driver.findElement(By.id("Password")).sendKeys(dataTable.cell(1,1));
    }

    @And("I click login button")
    public void iClickLoginButton() {
        base.Driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/form/div[4]/div/input")).submit();
    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserformPage() {
        Assertions.assertTrue(base.Driver.findElement(By.partialLinkText("Log")).isDisplayed());
    }
}
