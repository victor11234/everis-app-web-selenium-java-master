package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import com.everis.ct.web.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PaginaInicioPage extends WebBase {


    @FindBy (xpath = "//*[contains(@class,'slds-icon-waffle')]")
    protected WebElement waffleOption;

    @FindBy (xpath = "//input[@placeholder = 'Buscar aplicaciones y elementos...']")
    protected WebElement atencionAlCliente;

    @FindBy (xpath = "//button[text()='Ver todo']")
    protected WebElement buttonVerTodo;
    @FindBy (xpath = "//span[text()='Todas las aplicaciones']")
    protected WebElement spanTodasAplicaciones;

    protected General general = new General();
    public void ingresamosAlMenuDeseado(String opcion) {
        var wait = webDriverWait(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(waffleOption));
        click(waffleOption);
        wait.until(ExpectedConditions.elementToBeClickable(atencionAlCliente));
        click(buttonVerTodo);
        general.tiempoEsperaFijo();
        wait.until(ExpectedConditions.elementToBeClickable(spanTodasAplicaciones));
        type(atencionAlCliente,opcion);
        general.tiempoEsperaFijo();
        WebElement opcionASeleccionar = driver().findElement(By.xpath("//mark[contains(text(),'"+opcion+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(opcionASeleccionar));
        click(opcionASeleccionar);
    }



}
