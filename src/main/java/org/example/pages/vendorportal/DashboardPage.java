package org.example.pages.vendorportal;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);

    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarning;

    @FindBy(id = "annual-earning")
    private WebElement annualEarning;

    @FindBy(id = "profit-margin")
    private WebElement profitMargin;

    @FindBy(id = "available-inventory")
    private WebElement availableInventory;

    @FindBy(css = "#dataTable_filter input")
    private WebElement searchInput;

    @FindBy(id = "dataTable_info")
    private WebElement searchResultsCount;

    @FindBy(css = "img.img-profile")
    private WebElement userProfilePicture;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(css = "#logoutModal a")
    private WebElement modalLogoutButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(monthlyEarning));
        return monthlyEarning.isDisplayed();
    }

    public String getMonthlyEarning() {
        return monthlyEarning.getText();
    }

    public String getAnnualEarning() {
        return annualEarning.getText();
    }

    public String getProfitMargin() {
        return profitMargin.getText();
    }

    public String getAvailableInventory() {
        return availableInventory.getText();
    }

    public void searchOrderHistoryBy(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public int getResultsCount() {
        String resultsText = searchResultsCount.getText();
        String[] arr = resultsText.split(" ");
        int count = Integer.parseInt(arr[5]);
        log.info("Results count: {}", count);
        return count;
    }

    public void logout() {
        userProfilePicture.click();
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.click();
        wait.until(ExpectedConditions.visibilityOf(modalLogoutButton));
        modalLogoutButton.click();
    }


}
