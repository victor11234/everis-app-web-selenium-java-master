package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import com.everis.ct.web.service.aspect.evidence.ScreenShotAfter;
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
    protected WebElement checkTipoCasoFelici;

    @FindBy (xpath = "//span[contains(text(),'INFORMACI')]")
    protected WebElement checkTipoCasoInforma;

    @FindBy (xpath = "//span[contains(text(),'QUEJA')]")
    protected WebElement checkTipoCasoQueja;

    @FindBy (xpath = "//span[contains(text(),'SOLICITUD')]")
    protected WebElement checkTipoCasoSolicitud;

    @FindBy (xpath = "//span[text()='Siguiente']")
    protected WebElement buttonSiguiente;

    //Xpath utilizados por los 6 casos
    @FindBy (xpath = "//input[contains(@title,'Buscar Cuentas')]")
    protected WebElement campoBuscarCuenta;

    @FindBy (xpath = "//div[@class = 'searchButton itemContainer slds-lookup__item-action--label slds-text-link--reset slds-grid slds-grid--vertical-align-center slds-truncate forceSearchInputLookupDesktopActionItem lookup__header highlighted']")
    protected WebElement clickCuenta;

    @FindBy (xpath = "//tr[1]/td/a[@data-refid='recordId']")
    protected WebElement seleccionaCuenta;

    @FindBy (xpath = "(//a[text()='--Ninguno--'])[position()=1]")
    protected WebElement selectOrigen;

    @FindBy (xpath = "//a[text()='Baja']")
    protected WebElement selectPrioridad;

    @FindBy (xpath = "(//a[@role = 'button'])[position()=10]")
    protected WebElement selectPrioridadQueja;

    @FindBy (xpath = "//input[contains(@title, 'Buscar Ubicaciones')]")
    protected  WebElement ubicacionAlmacen;

    @FindBy (xpath = "//div[@class = 'searchButton itemContainer slds-lookup__item-action--label slds-text-link--reset slds-grid slds-grid--vertical-align-center slds-truncate forceSearchInputLookupDesktopActionItem lookup__header highlighted']")
    protected  WebElement resultadoAlmacen;

    @FindBy (xpath = "//tr[1]/td/a[@data-refid='recordId']")
    protected  WebElement seleccionaAlmacen;


    @FindBy (xpath = "(//input[@class=' input'])[position()=1]")
    protected  WebElement campoAsunto;

    @FindBy (xpath = "(//textarea[@role='textbox'])[position()=1]")
    protected  WebElement campoDescripcion;
    @FindBy (xpath = "(//textarea[@role='textbox'])[position()=2]")
    protected  WebElement campoPlanes;
    @FindBy (xpath = "//a[@class='select']")
    protected WebElement selectEstado;
    @FindBy (xpath = "(//span[text()='Guardar'])[position()=2]")
    protected  WebElement guardarCaso;

    @FindBy (xpath = "//lightning-formatted-text[@slot='primaryField']")
    protected WebElement idCaso;
    @FindBy (xpath = "(//a[contains(text(),'--Ninguno--')])[position()=1]")
    protected WebElement selectArea;

    //Adicion de objetos casos Queja y solicitud

    @FindBy (xpath = "(//input[@class=' input'])[position()=2]")
    protected  WebElement campoAsuntoDiferente;
    @FindBy (xpath = "(//textarea[@role='textbox'])[position()=2]")
    protected  WebElement campoDescripcion2;

    @FindBy (xpath = "(//textarea[@role='textbox'])[position()=3]")
    protected  WebElement campoPlanes2;

    General general = new General();

    public void listaDesplegable(){

        general.tiempoEsperaFijo();

        click(listaDesplegable);
        click(opcionCasos);
        general.tiempoEsperaFijo();
        click(botonCasos);
    }

    @ScreenShotAfter
    public void seleccionTipoCaso(String tipoDeCaso){

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonNew));
        click(buttonNew);

        general.tiempoEsperaFijo();

        if(tipoDeCaso.equalsIgnoreCase("Felicitaciones")) {
            click(checkTipoCasoFelici);
        }
        else if (tipoDeCaso.equalsIgnoreCase("Informacion")){
            click(checkTipoCasoInforma);
        }else if (tipoDeCaso.equalsIgnoreCase("Queja")){

            click(checkTipoCasoQueja);
        } else if (tipoDeCaso.equalsIgnoreCase("Solicitud")){
        click(checkTipoCasoSolicitud);
    }


        click(buttonSiguiente);


    }
    public void creacionCasoFelicitaciones(String cuenta, String selectOrigenCaso, String prioridadCaso, String almacen, String asunto, String descripcion, String planesAccion, String estado){
        var wait = webDriverWait(Duration.ofSeconds(10));
        general.tiempoEsperaFijo();

        cuenta = general.primelaLetraDeCadaPalabra(cuenta);
        type(campoBuscarCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(clickCuenta));
        click(clickCuenta);
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaCuenta));
        click(seleccionaCuenta);

        click(selectOrigen);
        selectOrigenCaso = general.primelaLetraDeCadaPalabra(selectOrigenCaso);
        WebElement origenCaso = find().getElementByXPath("//a[text()='"+selectOrigenCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(origenCaso));
        click(origenCaso);

        click(selectPrioridad);
        prioridadCaso = general.primelaLetraDeCadaPalabra(prioridadCaso);
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
        estado = general.primelaLetraDeCadaPalabra(estado);
        WebElement selectEstado = find().getElementByXPath("//a[contains(text(),'"+estado+"')]");
        wait.until(ExpectedConditions.elementToBeClickable(selectEstado));
        click(selectEstado);
        general.tiempoEsperaFijo();
        click(guardarCaso);


    }

    public void creacionCasoInformacion(String cuenta, String selectOrigenCaso, String prioridadCaso, String area, String almacen, String asunto, String descripcion, String planesAccion, String estado){
        var wait = webDriverWait(Duration.ofSeconds(10));
        general.tiempoEsperaFijo();

        type(campoBuscarCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(clickCuenta));
        click(clickCuenta);
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaCuenta));
        click(seleccionaCuenta);

        click(selectOrigen);
        WebElement origenCaso = find().getElementByXPath("//a[text()='"+selectOrigenCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(origenCaso));
        click(origenCaso);

        click(selectPrioridad);
        WebElement casoPrioridad = find().getElementByXPath("//a[text()='"+prioridadCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(casoPrioridad));
        click(casoPrioridad);

        click(selectArea);
        WebElement opcionArea = find().getElementByXPath("//a[text()='"+area+"']");
        wait.until(ExpectedConditions.elementToBeClickable(opcionArea));
        click(opcionArea);

        type(ubicacionAlmacen, almacen);
        wait.until(ExpectedConditions.elementToBeClickable(resultadoAlmacen));
        click(resultadoAlmacen);
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaAlmacen));
        click(seleccionaAlmacen);
        type(campoAsunto, asunto);
        type(campoDescripcion, descripcion);
        type(campoPlanes, planesAccion);

        click(selectEstado);
        WebElement selectEstado = find().getElementByXPath("//a[contains(text(),'"+estado+"')]");
        wait.until(ExpectedConditions.elementToBeClickable(selectEstado));
        click(selectEstado);

        general.tiempoEsperaFijo();
        click(guardarCaso);


    }

    public void creacionCasoQueja(String cuenta, String selectOrigenCaso, String prioridadCaso, String area, String clase, String almacen, String asunto, String descripcion, String planesAccion, String estado){
        var wait = webDriverWait(Duration.ofSeconds(10));
        general.tiempoEsperaFijo();

        type(campoBuscarCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(clickCuenta));
        click(clickCuenta);
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaCuenta));
        click(seleccionaCuenta);

        click(selectOrigen);
        selectOrigenCaso = general.primelaLetraDeCadaPalabra(selectOrigenCaso);
        WebElement origenCaso = find().getElementByXPath("//a[text()='"+selectOrigenCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(origenCaso));
        click(origenCaso);

        click(selectPrioridadQueja);
        prioridadCaso = general.primelaLetraDeCadaPalabra(prioridadCaso);
        WebElement casoPrioridad = find().getElementByXPath("//a[text()='"+prioridadCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(casoPrioridad));
        click(casoPrioridad);

        click(selectArea);
        general.tiempoEsperaFijo();
        WebElement opcionArea = find().getElementByXPath("//a[text()='"+area+"']");
        click(opcionArea);
        click(selectArea);
        general.tiempoEsperaFijo();
        WebElement opcionClase = find().getElementByXPath("//a[text()='"+clase+"']");
        click(opcionClase);

        type(ubicacionAlmacen, almacen);
        wait.until(ExpectedConditions.elementToBeClickable(resultadoAlmacen));
        click(resultadoAlmacen);
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaAlmacen));
        click(seleccionaAlmacen);
        wait.until(ExpectedConditions.elementToBeClickable(campoAsunto));
        type(campoAsuntoDiferente, asunto);
        type(campoDescripcion2, descripcion);
        type(campoPlanes2, planesAccion);


        click(selectEstado);
        WebElement selectEstado = find().getElementByXPath("//a[contains(text(),'"+estado+"')]");
        wait.until(ExpectedConditions.elementToBeClickable(selectEstado));
        click(selectEstado);

        general.tiempoEsperaFijo();
        click(guardarCaso);


    }

    public void creacionCasoSolicitud(String cuenta, String selectOrigenCaso, String prioridadCaso, String area, String clase, String almacen, String asunto, String descripcion, String planesAccion, String estado){
        var wait = webDriverWait(Duration.ofSeconds(10));
        general.tiempoEsperaFijo();
        cuenta = general.primelaLetraDeCadaPalabra(cuenta);
        type(campoBuscarCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(clickCuenta));
        click(clickCuenta);
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaCuenta));
        click(seleccionaCuenta);

        click(selectOrigen);
        selectOrigenCaso = general.primelaLetraDeCadaPalabra(selectOrigenCaso);
        WebElement origenCaso = find().getElementByXPath("//a[text()='"+selectOrigenCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(origenCaso));
        click(origenCaso);

        click(selectPrioridad);
        prioridadCaso = general.primelaLetraDeCadaPalabra(prioridadCaso);
        WebElement casoPrioridad = find().getElementByXPath("//a[text()='"+prioridadCaso+"']");
        click(casoPrioridad);

        click(selectArea);
        WebElement opcionArea = find().getElementByXPath("//a[text()='"+area+"']");
        wait.until(ExpectedConditions.elementToBeClickable(opcionArea));
        click(opcionArea);

        click(selectArea);
        general.tiempoEsperaFijo();
        WebElement opcionClase = find().getElementByXPath("//a[text()='"+clase+"']");
        click(opcionClase);

        type(ubicacionAlmacen, almacen);
        wait.until(ExpectedConditions.elementToBeClickable(resultadoAlmacen));
        click(resultadoAlmacen);
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaAlmacen));
        click(seleccionaAlmacen);
        type(campoAsuntoDiferente, asunto);
        type(campoDescripcion2, descripcion);
        type(campoPlanes2, planesAccion);

        click(selectEstado);
        general.tiempoEsperaFijo();
        estado = general.primelaLetraDeCadaPalabra(estado);
        WebElement selectEstado = find().getElementByXPath("//a[contains(text(),'"+estado+"')]");
        wait.until(ExpectedConditions.elementToBeClickable(selectEstado));
        click(selectEstado);

        general.tiempoEsperaFijo();
        click(guardarCaso);

    }

    public void verifcarCasoCreado(){

        general.tiempoEsperaFijo();
        getText(idCaso);
        general.tiempoEsperaFijo();

    }
}
