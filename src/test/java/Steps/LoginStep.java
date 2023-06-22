package Steps;

import Base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        base.Driver.navigate().to("https://executeautomation.com/");
        base.Driver.manage().window().maximize();
    }

    @And("I click login button to insert data")
    public void iClickLoginButtonToInsertData() {
       base.Driver.findElement(By.linkText("Start Learning")).click();
    }

    @And("I insert email, password, profession, fName, lName, coutry")
    public void iInsertEmailPasswordProfessionFNameLNameCoutry(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();
        base.Driver.findElement(By.id("email")).sendKeys(dataTable.cell(1,0));
        base.Driver.findElement(By.id("password")).sendKeys(dataTable.cell(1,1));
        base.Driver.findElement(By.id("password_confirmation")).sendKeys(dataTable.cell(1,1));
        base.Driver.findElement(By.id("designation")).sendKeys(dataTable.cell(1,2));
        base.Driver.findElement(By.id("first_name")).sendKeys(dataTable.cell(1,3));
        base.Driver.findElement(By.id("last_name")).sendKeys(dataTable.cell(1,4));
        base.Driver.findElement(By.id("react-select-2-input")).sendKeys(dataTable.cell(1,5));
        base.Driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.RETURN);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        WebElement avatar = base.Driver.findElement((By.xpath("/html/body/div[1]/div/div[2]/div/form/div/div[1]/div[1]/img")));
        Actions avatarClick = new Actions(base.Driver);
        avatarClick.moveToElement(avatar).click().build().perform();
        WebElement avatarImg = base.Driver.findElement((By.xpath("/html/body/div[1]/div/div[2]/div/form/div/div[1]/div[1]/div/div[1]/img[2]")));
        Actions avatarImgClick = new Actions(base.Driver);
        avatarImgClick.moveToElement(avatarImg).click().build().perform();
        base.Driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div/div[2]/div[5]/button")).submit();
    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserformPage() {
        base.Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assertions.assertTrue(base.Driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/button")).isDisplayed());
    }
}
