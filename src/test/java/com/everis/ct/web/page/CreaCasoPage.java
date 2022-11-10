package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import com.everis.ct.web.util.General;
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

    @FindBy (xpath = "//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']/div")
    protected WebElement selectOrigen;

    @FindBy (xpath = "//a[text()='Baja']")
    protected WebElement selectPrioridad;

    @FindBy (xpath = "//input[contains(@title, 'Buscar Ubicaciones')]")
    protected  WebElement ubicacionAlmacen;

    @FindBy (xpath = "//div[@class = 'searchButton itemContainer slds-lookup__item-action--label slds-text-link--reset slds-grid slds-grid--vertical-align-center slds-truncate forceSearchInputLookupDesktopActionItem lookup__header highlighted']")
    protected  WebElement resultadoAlmacen;

    @FindBy (xpath = "//a[@href='/lightning/r/1314C000000Dk9YQAS/view']")
    protected  WebElement seleccionaAlmacen;

    @FindBy (xpath = "//input[@class=' input']")
    protected  WebElement campoAsunto;

    @FindBy (xpath = "(//textarea[@role='textbox'])[position()=1]")
    protected  WebElement campoDescripcion;
    @FindBy (xpath = "(//textarea[@role='textbox'])[position()=2]")
    protected  WebElement campoPlanes;
    @FindBy (xpath = "//a[text()='Nuevo']")
    protected WebElement selectEstado;
    @FindBy (xpath = "(//span[text()='Guardar'])[position()=2]")
    protected  WebElement guardarCaso;

    @FindBy (xpath = "//lightning-formatted-text[@slot='primaryField']")
    protected WebElement idCaso;


    General general = new General();

    public void listaDesplegable(){

        general.tiempoEsperaFijo();

        click(listaDesplegable);
        click(opcionCasos);
        general.tiempoEsperaFijo();
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
    public void creacionCaso(String cuenta, String selectOrigenCaso, String prioridadCaso, String almacen, String asunto, String descripcion, String planesAccion, String estado){
        var wait = webDriverWait(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(campoBuscarCuenta));
        type(campoBuscarCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(clickCuenta));
        click(clickCuenta);


        WebElement seleccionaCuenta = find().getElementByXPath("//a[contains(text(),'"+cuenta+"')]");
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaCuenta));
        click(seleccionaCuenta);

        click(selectOrigen);
        general.tiempoEsperaFijo();
        WebElement origenCaso = find().getElementByXPath("//a[text()='"+selectOrigenCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(origenCaso));
        click(origenCaso);

        click(selectPrioridad);
        general.tiempoEsperaFijo();
        WebElement casoPrioridad = find().getElementByXPath("//a[text()='"+prioridadCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(casoPrioridad));
        click(casoPrioridad);

        type(ubicacionAlmacen, almacen);
        wait.until(ExpectedConditions.elementToBeClickable(resultadoAlmacen));
        click(resultadoAlmacen);
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaAlmacen));
        click(seleccionaAlmacen);
        type(campoAsunto, asunto);
        type(campoDescripcion, descripcion);
        type(campoPlanes, planesAccion);
        click(selectEstado);
        general.tiempoEsperaFijo();
        WebElement selectEstado = find().getElementByXPath("//a[contains(text(),'"+estado+"')]");
        wait.until(ExpectedConditions.elementToBeClickable(selectEstado));
        click(selectEstado);
        general.tiempoEsperaFijo();
        click(guardarCaso);
        general.tiempoEsperaFijo();
        //obtiene el ID del caso creado
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println(getText(idCaso));
        System.out.println("----------------------------------------------------------------------------------------");
        general.tiempoEsperaFijo();



    }
}
