package org.swatikagalkaracademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.swatikagalkaracademy.AbstractComponents.AbstractComponent;

public class FooterNav extends AbstractComponent
{
    WebDriver driver;
    By flights=By.cssSelector("[title='Flights']");
    By links=By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement)
    {
        super(driver,sectionElement); //when you inherit parent class you should invoke parent class constructor in
        // you're own child class constructor.

    }
    //method to handle flights
    //when selenium executes any method in this class-scope of selenium should be in footer only.

    public String getFlightAttribute()
    {
        return findElement(flights).getAttribute("class");
    }
    public int getLinkCount()
    {
        return findElements(links).size();
    }
}
