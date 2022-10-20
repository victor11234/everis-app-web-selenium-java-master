package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SandBoxPage extends WebBase {


    @FindBy (xpath = "//button[contains(text(),'Aceptar todas las cookies')]")
    protected WebElement buttonCookies;

    @FindBy (xpath = "//button[contains(text(),'Leer')]")
    protected WebElement buttonLeer;


    public void aceptarCookies(){

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonCookies));
        click(buttonCookies);
    }

    public void clickLeer(){

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonLeer));
        click(buttonLeer);
    }



}
