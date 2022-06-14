package org.swatikagalkaracademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.swatikagalkaracademy.AbstractComponents.AbstractComponent;
import org.swatikagalkaracademy.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail
{
    private By rdo= By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By cb=By.id("ctl00_mainContent_chk_IndArm");
    private By search=By.id("ctl00_mainContent_btn_FindFlights");
    private By to=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");

    public RoundTrip(WebDriver driver, By sectionElement)
    {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails)
    {
        System.out.println("Im inside Round Trip");
        findElement(rdo).click();
        selectOriginCity(reservationDetails.get("origin"));
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(cb).click();
        findElement(search).click();
    }
    public void selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
}
