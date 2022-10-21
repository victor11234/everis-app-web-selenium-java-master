package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
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

    public void iniciamosSesion() {

        SearchContext shadow0 = driver().findElement(By.cssSelector("th-header[lx-search='true']")).getShadowRoot();
        SearchContext shadow1 = shadow0.findElement(By.cssSelector("lwc-tds-header")).getShadowRoot();
        SearchContext shadow2 = shadow1.findElement(By.cssSelector("lwc-tds-header-desktop")).getShadowRoot();
        shadow2.findElement(By.cssSelector("lwc-tds-button-link:nth-child(2)")).click();
    }

    public void clickLeer(){

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonLeer));
        click(buttonLeer);
    }



}
