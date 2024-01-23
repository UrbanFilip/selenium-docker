package org.example.pages.flightreseration;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightsSelectionPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(FlightsSelectionPage.class);

    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlights;

    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlights;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightsButton;

    public FlightsSelectionPage(WebDriver driver) {
        super(driver);
    }

    public FlightsSelectionPage selectFlights() {
        int randomDeparture = ThreadLocalRandom.current().nextInt(0, departureFlights.size());
        log.info("index of departure: " + randomDeparture);
        this.departureFlights.get(randomDeparture).click();
        int randomArrival = ThreadLocalRandom.current().nextInt(0, arrivalFlights.size());
        log.info("index of arrival: " + randomArrival);
        this.arrivalFlights.get(randomArrival).click();
        return this;
    }

    public FlightsSelectionPage confirmFlights() {
        confirmFlightsButton.click();
        return this;
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(this.confirmFlightsButton));
        return confirmFlightsButton.isDisplayed();
    }

}
