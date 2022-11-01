package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class SandBoxPage extends WebBase {



    @FindBy (xpath = "//input[@id='username']" )
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

    @FindBy (xpath = "//a[@data-label='Casos']")
    protected WebElement opcionCasos;

    @FindBy (xpath = "//a[@title='Casos']")
    protected WebElement botonCasos;

    @FindBy (xpath = "//a[@title='Nuevo']")
    protected WebElement buttonNew;

    @FindBy (xpath = "//span[text()='Siguiente']")
    protected WebElement buttonSiguiente;

    @FindBy (xpath = "//input[contains(@title,'Buscar Cuentas')]")
    protected WebElement campoBuscarCuenta;

    @FindBy (xpath = "//input[contains(@title, 'Buscar Ubicaciones')]")
    protected  WebElement ubicacionAlmacen;

    @FindBy (xpath = "//input[contains(@title, '//div[@data-aura-rendered-by='451:3343;a']')]")
    protected  WebElement resultadoAlmacen;

    @FindBy (xpath = "//a[@href='/lightning/r/1314C000000Dk9YQAS/view']")
    protected  WebElement seleccionaAlmacen;

    @FindBy (xpath = "//input[@id='566:3343;a']")
    protected  WebElement campoAsunto;

    @FindBy (xpath = "///textarea[@id='586:3343;a']")
    protected  WebElement campoDescripcion;
    @FindBy (xpath = "//textarea[@id='606:3343;a']")
    protected  WebElement campoPlanes;

    @FindBy (xpath = "//span[text()='Guardar']")
    protected  WebElement guardarCaso;

    @FindBy (xpath = "//div[@class='close slds-col--bump-left slds-p-left--none slds-context-bar__icon-action ']")
    protected  WebElement cerrarPestaña;








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
               wait.until(ExpectedConditions.elementToBeClickable(cerrarPestaña));
               click(cerrarPestaña);
               wait.until(ExpectedConditions.elementToBeClickable(listaDesplegable));
               click(listaDesplegable);

               wait.until(ExpectedConditions.elementToBeClickable(opcionCasos));
               click(opcionCasos);
               wait.until(ExpectedConditions.elementToBeClickable(botonCasos));
               click(botonCasos);



    }

    public void creacionCaso(String tipoDeCaso, String cuenta, String selectOrigenCaso, String prioridadCaso, String almacen){

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonNew));
        click(buttonNew);

        WebElement caso = find().getElementByXPath("//span[text()='"+tipoDeCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(caso));
        click(caso);
        click(buttonSiguiente);

        wait.until(ExpectedConditions.elementToBeClickable(campoBuscarCuenta));
        type(campoBuscarCuenta, cuenta);
        /*WebElement clickCuenta = find().getElementByXPath("//span[text()= '"+cuenta+" en Cuentas']");
        wait.until(ExpectedConditions.elementToBeClickable(clickCuenta));
        click(clickCuenta);
        WebElement seleccionaCuenta = find().getElementByXPath("//a[text()= '"+cuenta+"']");
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaCuenta));
        click(seleccionaCuenta);*/
        WebElement seleccionaCuenta = find().getElementByXPath("//div[@title='"+cuenta+"']");
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaCuenta));
        click(seleccionaCuenta);

        wait.until(ExpectedConditions.elementToBeClickable(seleccionaCuenta));

        WebElement origenCaso = find().getElementByXPath("//a[text()='"+selectOrigenCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(origenCaso));
        click(origenCaso);

        WebElement casoPrioridad = find().getElementByXPath("//a[text()='"+prioridadCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(casoPrioridad));
        click(casoPrioridad);

        type(ubicacionAlmacen, almacen);
        wait.until(ExpectedConditions.elementToBeClickable(resultadoAlmacen));
        click(resultadoAlmacen);
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaAlmacen));
        click(seleccionaAlmacen);

    }

    public void terminaCaso(String asunto, String descripcion, String planesDeAccion, String estado){

        type(campoAsunto,asunto);
        type(campoDescripcion,descripcion);
        type(campoPlanes,planesDeAccion);
        var wait = webDriverWait(Duration.ofSeconds(10));
        WebElement estadoCaso = find().getElementByXPath("//a[text()='"+estado+"']");
        wait.until(ExpectedConditions.elementToBeClickable(estadoCaso));
        click(estadoCaso);
    }

}
