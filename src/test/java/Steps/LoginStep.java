package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStep {
    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
    }

    @And("I enter the username as {string} and password as {string}")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) {
    }

    @And("I click login button")
    public void iClickLoginButton() {
    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserformPage() {
    }
}
