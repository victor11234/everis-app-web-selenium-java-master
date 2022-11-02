package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreacionCuentaPage extends WebBase {


    //Xpath inicio de sesion
    @FindBy (xpath = "//input[@id='username']" )
    protected WebElement userName;

    @FindBy (xpath = "//input[@id='password']" )
    protected WebElement password;

    @FindBy (xpath = "//input[@id='Login']" )
    protected WebElement buttonLogin;

    //Xpath atencion al cliente
    @FindBy (xpath = "//*[contains(@class,'slds-icon-waffle')]")
    protected WebElement waffleOption;

    @FindBy (xpath = "//input[@placeholder = 'Buscar aplicaciones y elementos...']")
    protected WebElement atencionAlCliente;

    @FindBy (xpath = "//p[text()='Atención al Cliente']")
    protected WebElement opcionAtencionAlCliente;

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

    //Xpath Cuenta Empresa

    @FindBy (xpath = "(//input[@name='_2'])[position()=1]")
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

    @FindBy (xpath = "//select[@name = 'Tipo_identificacion']")
    protected WebElement selectIdentificacion;






    public void iniciamosSesion(String usuario, String clave) {

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        type(userName, usuario);
        type(password, clave);
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


        var wait = webDriverWait(Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(listaDesplegable));
        click(listaDesplegable);

        wait.until(ExpectedConditions.elementToBeClickable(opcionCuentas));
        click(opcionCuentas);
        wait.until(ExpectedConditions.elementToBeClickable(botonCuentas));
        click(botonCuentas);



    }

    public void busquedaCuenta(String cuenta, String tipoCuenta){


        var wait  = webDriverWait(Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(botonBusquedaCuenta));
        click(botonBusquedaCuenta);
        wait.until(ExpectedConditions.elementToBeClickable(iframe));
        driver().switchTo().frame(iframe);
        wait.until(ExpectedConditions.elementToBeClickable(campoCuenta));
        type(campoCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(botonSiguiente));
        click(botonSiguiente);

        if(tipoCuenta.equalsIgnoreCase("Empresas")) {

            wait.until(ExpectedConditions.elementToBeClickable(cuentaEmpresa));
            click(cuentaEmpresa);



        } else if (tipoCuenta.equalsIgnoreCase("Persona") ){

            wait.until(ExpectedConditions.elementToBeClickable(cuentaPersona));
            click(cuentaPersona);



        }
        wait.until(ExpectedConditions.elementToBeClickable(botonSiguiente));
        click(botonSiguiente);



    }

    public void crearCuentaEmpresa(String nombreCuenta, String identificacionEmpresa){

        var wait  = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(campoNombreCuenta));
        type(campoNombreCuenta, nombreCuenta);

        WebElement tipoIdentificacion =find().getElementByXPath("//option[text()='"+identificacionEmpresa+"']");
        wait.until(ExpectedConditions.elementToBeClickable(tipoIdentificacion));
        click(tipoIdentificacion);
        wait.until(ExpectedConditions.elementToBeClickable(botonCrearCuenta));
        click(botonCrearCuenta);

    }

    public void crearCuentaPersonas(String nombre, String apellido, String email, String telefono, String tipoDeDocumento){

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


}
