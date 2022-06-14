package org.swatikagalkaracademy.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.swatikagalkaracademy.AbstractComponents.SearchFlightAvail;
import org.swatikagalkaracademy.AbstractComponents.StrategyFactor;
import org.swatikagalkaracademy.PageComponents.FooterNav;
import org.swatikagalkaracademy.PageComponents.MultiTrip;
import org.swatikagalkaracademy.PageComponents.NavigationBar;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;

public class TravelHomePage
{
    By sectionElement=By.id("traveller-home");
    By footerNavSectionElement=By.id("buttons");
    WebDriver driver;
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void goTo()
    {
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar()
    {
       return new NavigationBar(driver,footerNavSectionElement);
    }
    public FooterNav getFooterNav()
    {
        return new FooterNav(driver,sectionElement);
    }
    public void setBookingStrategy(String strategyType)
    {
        StrategyFactor strategyFactor=new StrategyFactor(driver);
        searchFlightAvail=strategyFactor.createStrategy(strategyType);
        this.searchFlightAvail=searchFlightAvail;
    }
    public void checkAvail(HashMap<String,String> reservationDetails)
    {
        searchFlightAvail.checkAvail(reservationDetails);
    }
    public String getTitle()
    {
        System.out.println("Hey How are you");
        return driver.getTitle();
    }

}
