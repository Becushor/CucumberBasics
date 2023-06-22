package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "email")
    public WebElement txtEmail;

    @FindBy(how = How.ID, using = "password")
    public WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/form/div[3]/button")
    public WebElement btnSignin;

    public void Signin(String email, String password) {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
    }

    public void ClickSignin() {
        btnSignin.submit();
    }
}
