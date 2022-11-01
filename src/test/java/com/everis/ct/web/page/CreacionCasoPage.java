package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreacionCasoPage extends WebBase {





    @FindBy (xpath = "//input[@id='username']" )
    protected WebElement usuario;

    @FindBy (xpath = "//input[@id='password']" )
    protected WebElement clave;

    @FindBy (xpath = "//input[@id='Login']" )
    protected WebElement buttonLogin;

    @FindBy (xpath = "//*[contains(@data-key,'chevrondown')]")
    protected WebElement listaDesplegable;



    @FindBy (xpath = "//div[@title='Nuevo']")
    protected WebElement botonNuevoCaso;


    @FindBy (xpath = "//input[contains(@title,'Buscar Cuentas')]")
    protected WebElement campoBuscarCuenta;




    public void iniciamosSesion(String user, String pass) {

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(usuario));
        type(usuario, user);
        type(clave, pass);
        click(buttonLogin);

    }

    public void listaDesplegable(){

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(listaDesplegable));
        click(listaDesplegable);


    }

    public void creacionCaso(String tipoDeCaso){

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(botonNuevoCaso));

        click(botonNuevoCaso);

        WebElement check = find().getElementByXPath("//span[text()='"+tipoDeCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(check));
        click(check);


    }



}
