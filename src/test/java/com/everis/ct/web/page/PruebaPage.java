package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PruebaPage extends WebBase {

    @FindBy(xpath = "//input[@title='Buscar']" )
    protected WebElement buscar;

    public void buscar(){

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buscar));
        type(buscar,"Hola");
    }


}
