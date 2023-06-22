package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "email")
    public WebElement txtEmail;

    @FindBy(how = How.ID, using = "password")
    public WebElement txtPassword;

    @FindBy(how = How.ID, using = "password_confirmation")
    public WebElement txtPasswordConfirmation;

    @FindBy(how = How.ID, using = "designation")
    public WebElement txtProfession;

    @FindBy(how = How.ID, using = "first_name")
    public WebElement txtFName;

    @FindBy(how = How.ID, using = "last_name")
    public WebElement txtLName;

    @FindBy(how = How.ID, using = "react-select-2-input")
    public WebElement txtCountry;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/form/div/div[1]/div[1]/img")
    public WebElement imgAvatar;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/form/div/div[1]/div[1]/div/div[1]/img[2]")
    public WebElement imgAvatarVariant2;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/form/div/div[2]/div[5]/button")
    public WebElement btnConfirm;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[3]/div/button")
    public WebElement popUp;

    public void InsertInfo(String email, String password, String profession, String fName, String lName, String country) {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        txtPasswordConfirmation.sendKeys(password);
        txtProfession.sendKeys(profession);
        txtFName.sendKeys(fName);
        txtLName.sendKeys(lName);
        txtCountry.sendKeys(country);
        txtCountry.sendKeys(Keys.RETURN);
    }

    public void SelectAvatar() {
        imgAvatar.click();
        imgAvatarVariant2.click();
    }

    public void Confirm() {
        btnConfirm.submit();
    }

    public boolean isPopUpActive() {
        if (popUp.isDisplayed())
            return true;
        else
            return false;
    }
}
