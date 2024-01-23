package org.example.pages.flightreseration;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class RegistrationConfirmationPage extends AbstractPage {

    @FindBy(id = "go-to-flights-search")
    private WebElement goToFlightsSearchButton;

    @FindBy(css = "#registration-confirmation-section p b")
    private WebElement firstName;

    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public FlightsSelectionPage goToFlightsSearch() {
        this.goToFlightsSearchButton.click();
        return new FlightsSelectionPage(driver);
    }

    public String getFirstName() {
        return this.firstName.getText();
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(this.goToFlightsSearchButton));
        return this.goToFlightsSearchButton.isDisplayed();
    }

}
