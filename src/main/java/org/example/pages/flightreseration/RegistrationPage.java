package org.example.pages.flightreseration;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends AbstractPage {

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "street")
    private WebElement streetInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "zip")
    private WebElement zipInput;

    @FindBy(id = "register-btn")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void goTo(String url) {
        this.driver.get(url);
    }

    public RegistrationPage enterUserDetails(String firstName, String lastName) {
        this.firstNameInput.sendKeys(firstName);
        this.lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterUserCredentials(String email, String password) {
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage enterAddress(String street, String city, String zip) {
        this.streetInput.sendKeys(street);
        this.cityInput.sendKeys(city);
        this.zipInput.sendKeys(zip);
        return this;
    }

    public RegistrationConfirmationPage register() {
        this.registerButton.click();
        return new RegistrationConfirmationPage(driver);
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(this.firstNameInput));
        return firstNameInput.isDisplayed();
    }
}
