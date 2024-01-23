package org.example.pages.flightreseration;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightsSearchPage extends AbstractPage {

    @FindBy(id = "passengers")
    private WebElement passengersSelect;

    @FindBy(id = "search-flights")
    private WebElement searchFlightsButton;


    public FlightsSearchPage(WebDriver driver) {
        super(driver);
    }

    public FlightsSearchPage selectPassengers(String noOfPassengers) {
        Select select = new Select(passengersSelect);
        select.selectByValue(noOfPassengers);
        return this;
    }

    public void searchFlights() {
        searchFlightsButton.click();
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(passengersSelect));
        return passengersSelect.isDisplayed();
    }


}
