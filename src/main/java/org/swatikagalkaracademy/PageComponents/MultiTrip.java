package org.swatikagalkaracademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.swatikagalkaracademy.AbstractComponents.AbstractComponent;
import org.swatikagalkaracademy.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail
{
    private By modelPopUp= By.id("MultiCityModelAlert");
    private By multiCity_rdo=By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By from=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By destinationCity=By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By submit=By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement)
    {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails)
    {
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));
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
    public void selectDestinationCity2(String destination2)
    {
        findElement(destinationCity).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }
    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        System.out.println("I'm inside Multi Trip");
        findElement(multiCity_rdo).click();
        findElement(modelPopUp).click();
        waitForElemetToDisappear(modelPopUp);
        consumer.accept(this);
        System.out.println("I'm done");

        //common prerequistes code
        //execute actual function-Book/calendar
        //tear down method
    }


}
