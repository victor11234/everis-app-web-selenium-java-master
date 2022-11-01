package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreacionCuentaPage extends WebBase {
    @FindBy(xpath = "//input[@id='username']" )
    protected WebElement userName;

    @FindBy (xpath = "//input[@id='password']" )
    protected WebElement password;

    @FindBy (xpath = "//input[@id='Login']" )
    protected WebElement buttonLogin;

    @FindBy (xpath = "//*[contains(@class,'slds-icon-waffle')]")
    protected WebElement waffleOption;

    @FindBy (xpath = "//input[@placeholder = 'Buscar aplicaciones y elementos...']")
    protected WebElement atencionAlCliente;

    @FindBy (xpath = "//p[text()='Atención al Cliente']")
    protected WebElement opcionAtencionAlCliente;

    @FindBy (xpath = "//button[@title ='Mostrar menú de navegación']")
    protected WebElement listaDesplegable;

    @FindBy (xpath = "//a[@data-label='Cuentas']")
    protected WebElement opcionCuentas;

    @FindBy (xpath = "//a[@title='Cuentas']")
    protected WebElement botonCuentas;











    public void iniciamosSesion(String user, String pass) {

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        type(userName, user);
        type(password, pass);
        click(buttonLogin);


    }

    public void atencionAlCliente(){



        var wait = webDriverWait(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(waffleOption));
        click(waffleOption);
        wait.until(ExpectedConditions.elementToBeClickable(atencionAlCliente));
        //type(atencionAlCliente, "Atención al Cliente");
        //wait.until(ExpectedConditions.elementToBeClickable(opcionAtencionAlCliente));
        //click(opcionAtencionAlCliente);
        opcionAtencionAlCliente.click();



    }

    public void listaDesplegable(){


        var wait = webDriverWait(Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(listaDesplegable));
        click(listaDesplegable);

        wait.until(ExpectedConditions.elementToBeClickable(opcionCuentas));
        click(opcionCuentas);
        wait.until(ExpectedConditions.elementToBeClickable(botonCuentas));
        click(botonCuentas);



    }
}
