package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import com.everis.ct.web.util.General;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreacionCuentaPage extends WebBase {



    //Xpath selecciona la opcion cuenta
    @FindBy (xpath = "//button[@title ='Mostrar menú de navegación']")
    protected WebElement listaDesplegable;

    @FindBy (xpath = "//span[text()='Cuentas']")
    protected WebElement opcionCuentas;

    @FindBy (xpath = "//a[@title='Cuentas']")
    protected WebElement botonCuentas;

    //Xpath busqueda de cuenta

    @FindBy (xpath = "//a[@title='Búsqueda de Cuenta']")
    protected WebElement botonBusquedaCuenta;

    @FindBy (xpath = "//iframe[@title='accessibility title']")
    protected WebElement iframe;
    @FindBy (xpath = "//input[@name='Numero_de_Identificacion_screen']")
    protected WebElement campoCuenta;

    @FindBy (xpath = "//button[text()='Siguiente']")
    protected WebElement botonSiguiente;


    @FindBy (xpath = "//span[text()='Empresa']")
    protected WebElement cuentaEmpresa;

    @FindBy (xpath = "//span[text()='Persona Natural']")
    protected WebElement cuentaPersona;

    @FindBy (xpath = "//span[text()='Aliados']")
    protected WebElement cuentaAliados;

    //Xpath Cuenta Empresa
    @FindBy (xpath = "//div[@class='slds-form-element__control slds-grow']")
    protected WebElement campoNombreCuenta;

    @FindBy (xpath = "//button[text()='Crear Cuenta']")
    protected WebElement botonCrearCuenta;

    //Xpath Cuenta Personas
    @FindBy (xpath = "//input[@name='Nome_Persona']")
    protected WebElement campoNombre;

    @FindBy (xpath = "//input[@name='Apellido_Persona']")
    protected WebElement campoApellido;

    @FindBy (xpath = "//input[@name='PersonEmail']")
    protected WebElement campoEmail;

    @FindBy (xpath = "//input[@name='PersonMobilePhone']")
    protected WebElement campoTelefono;

    protected General general = new General();
    public void listaDesplegable(){
        general.tiempoEsperaFijo();
        var wait = webDriverWait(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(listaDesplegable));
        click(listaDesplegable);

        wait.until(ExpectedConditions.elementToBeClickable(opcionCuentas));
        click(opcionCuentas);
        wait.until(ExpectedConditions.elementToBeClickable(botonCuentas));
        click(botonCuentas);
    }

    public void busquedaCuenta(String cuenta, String tipoCuenta){
        if (cuenta.equalsIgnoreCase("N/A"))
            cuenta="1"+general.numeroAleatorio();
        var wait  = webDriverWait(Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(botonBusquedaCuenta));
        click(botonBusquedaCuenta);
        wait.until(ExpectedConditions.elementToBeClickable(iframe));
        driver().switchTo().frame(iframe);
        wait.until(ExpectedConditions.elementToBeClickable(campoCuenta));
        type(campoCuenta, cuenta);
        general.tiempoEsperaFijo();
        // wait.until(ExpectedConditions.elementToBeClickable(iframe));
        //driver().switchTo().frame(iframe);
        wait.until(ExpectedConditions.elementToBeClickable(botonSiguiente));
        click(botonSiguiente);
        general.tiempoEsperaFijo();
        click(botonSiguiente);
        general.tiempoEsperaFijo();

        //if (!find().getElementByXPath("//a[text()='Haga clic aquí para acceder a la Cuenta']").isEnabled()) {
            if (tipoCuenta.equalsIgnoreCase("Empresas")) {
                wait.until(ExpectedConditions.elementToBeClickable(cuentaEmpresa));
                click(cuentaEmpresa);
            } else if (tipoCuenta.equalsIgnoreCase("Persona")) {
                wait.until(ExpectedConditions.elementToBeClickable(cuentaPersona));
                click(cuentaPersona);
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(cuentaAliados));
                click(cuentaAliados);
            }
            general.tiempoEsperaFijo();
            wait.until(ExpectedConditions.elementToBeClickable(botonSiguiente));
            click(botonSiguiente);
        /*}else {
            Assert.fail("El número de cuenta indicado ya se encuentra creado");
        }*/
    }

    public void crearCuentaEmpresa(String nombreCuenta, String identificacionEmpresa){
        if (nombreCuenta.equalsIgnoreCase("N/A"))
            nombreCuenta= general.getRandomValue() + "S.A";
        general.tiempoEsperaFijo();
        var wait  = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(campoNombreCuenta));
        type(campoNombreCuenta, nombreCuenta);
        WebElement tipoIdentificacion =find().getElementByXPath("//option[text()='"+identificacionEmpresa+"']");
        wait.until(ExpectedConditions.elementToBeClickable(tipoIdentificacion));
        click(tipoIdentificacion);
        general.tiempoEsperaFijo();
        wait.until(ExpectedConditions.elementToBeClickable(botonCrearCuenta));
        click(botonCrearCuenta);
    }

    public void crearCuentaPersonas(String nombre, String apellido, String email, String telefono, String tipoDeDocumento){
        if (nombre.equalsIgnoreCase("N/A"))
            nombre = general.firstName();
        if (apellido.equalsIgnoreCase("N/A"))
            apellido= general.lastName();
        if (email.equalsIgnoreCase("N/A"))
            email= nombre+"."+ apellido+"@gmail.com";
        if (telefono.equalsIgnoreCase("N/A"))
            telefono= 311+general.numeroAleatorio();

        var wait  = webDriverWait(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(campoNombre));
        type(campoNombre, nombre);
        type(campoApellido, apellido);
        type(campoEmail, email);
        type(campoTelefono, telefono);
        WebElement documento =find().getElementByXPath("//option[contains(text(),'"+tipoDeDocumento+"')]");
        wait.until(ExpectedConditions.elementToBeClickable(documento));
        click(documento);
        wait.until(ExpectedConditions.elementToBeClickable(botonCrearCuenta));
        click(botonCrearCuenta);
    }

    public void crearCuentaAliados(String cuenta){
        if (cuenta.equalsIgnoreCase("N/A"))
            cuenta= general.getRandomValue() + " S.A";
        var wait  = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(campoNombreCuenta));
        type(campoNombreCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(botonCrearCuenta));
        click(botonCrearCuenta);
    }

}
