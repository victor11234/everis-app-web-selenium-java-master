package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreaCasoPage extends WebBase {

    @FindBy (xpath = "//button[@title ='Mostrar menú de navegación']")
    protected WebElement listaDesplegable;

    @FindBy (xpath = "//a[@data-label='Casos']")
    protected WebElement opcionCasos;

    @FindBy (xpath = "//a[@title='Casos']")
    protected WebElement botonCasos;

    //Ingresar a casos
    @FindBy (xpath = "//a[@title='Nuevo']")
    protected WebElement buttonNew;

    @FindBy (xpath = "//span[text()='FELICITACIONES']")
    protected WebElement checkTipoCaso;

    @FindBy (xpath = "//span[text()='Siguiente']")
    protected WebElement buttonSiguiente;

    //Crear caso
    @FindBy (xpath = "//input[contains(@title,'Buscar Cuentas')]")
    protected WebElement campoBuscarCuenta;

    @FindBy (xpath = "//div[@class = 'searchButton itemContainer slds-lookup__item-action--label slds-text-link--reset slds-grid slds-grid--vertical-align-center slds-truncate forceSearchInputLookupDesktopActionItem lookup__header highlighted']")
    protected WebElement clickCuenta;


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



    public void listaDesplegable(){
               var wait = webDriverWait(Duration.ofSeconds(47));
               wait.until(ExpectedConditions.elementToBeClickable(listaDesplegable));
               click(listaDesplegable);
               wait.until(ExpectedConditions.elementToBeClickable(opcionCasos));
               click(opcionCasos);
               wait.until(ExpectedConditions.elementToBeClickable(botonCasos));
               click(botonCasos);
    }

    public void seleccionTipoCaso(String tipoDeCaso){

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonNew));
        click(buttonNew);

        if(tipoDeCaso.equalsIgnoreCase("Felicitaciones")) {
            wait.until(ExpectedConditions.elementToBeClickable(checkTipoCaso));
            click(checkTipoCaso);
        }
        else if (tipoDeCaso.equalsIgnoreCase("lo que sigue")){}


        click(buttonSiguiente);


    }
    public void creacionCaso(String cuenta, String selectOrigenCaso, String prioridadCaso, String almacen){
        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(campoBuscarCuenta));
        type(campoBuscarCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(clickCuenta));
        click(clickCuenta);
        WebElement seleccionaCuenta = find().getElementByXPath("//a[contains(text(),'"+cuenta+"')]");
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
        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(campoAsunto));

        type(campoAsunto,asunto);
        type(campoDescripcion,descripcion);
        type(campoPlanes,planesDeAccion);

        WebElement estadoCaso = find().getElementByXPath("//a[text()='"+estado+"']");
        wait.until(ExpectedConditions.elementToBeClickable(estadoCaso));
        click(estadoCaso);
    }

}
