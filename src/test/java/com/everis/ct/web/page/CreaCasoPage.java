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
    protected WebElement checkTipoCasoFelici;

    @FindBy (xpath = "//span[contains(text(),'INFORMACI')]")
    protected WebElement checkTipoCasoInforma;

    @FindBy (xpath = "(//span[contains(text(),'QUEJA')])[position()=3]")
    protected WebElement checkTipoCasoQueja;

    @FindBy (xpath = "//span[text()='Siguiente']")
    protected WebElement buttonSiguiente;

    //Crear casos
    @FindBy (xpath = "//input[contains(@title,'Buscar Cuentas')]")
    protected WebElement campoBuscarCuenta;

    @FindBy (xpath = "//div[@class = 'searchButton itemContainer slds-lookup__item-action--label slds-text-link--reset slds-grid slds-grid--vertical-align-center slds-truncate forceSearchInputLookupDesktopActionItem lookup__header highlighted']")
    protected WebElement clickCuenta;

    @FindBy (xpath = "(//a[text()='--Ninguno--'])[position()=1]")
    protected WebElement selectOrigen;

    @FindBy (xpath = "//a[text()='Baja']")
    protected WebElement selectPrioridad;

    @FindBy (xpath = "//input[contains(@title, 'Buscar Ubicaciones')]")
    protected  WebElement ubicacionAlmacen;

    @FindBy (xpath = "//div[@class = 'searchButton itemContainer slds-lookup__item-action--label slds-text-link--reset slds-grid slds-grid--vertical-align-center slds-truncate forceSearchInputLookupDesktopActionItem lookup__header highlighted']")
    protected  WebElement resultadoAlmacen;

    @FindBy (xpath = "//a[@href='/lightning/r/1314C000000Dk9YQAS/view']")
    protected  WebElement seleccionaAlmacen;

    @FindBy (xpath = "(//input[@class=' input'])[position()=1]")
    protected  WebElement campoAsunto;

    @FindBy (xpath = "(//textarea[@role='textbox'])[position()=1]")
    protected  WebElement campoDescripcion;
    @FindBy (xpath = "(//textarea[@role='textbox'])[position()=2]")
    protected  WebElement campoPlanes;
    @FindBy (xpath = "(//a[@class='select'])[position()=5]")
    protected WebElement selectEstado;
    @FindBy (xpath = "(//span[text()='Guardar'])[position()=2]")
    protected  WebElement guardarCaso;

    @FindBy (xpath = "//lightning-formatted-text[@slot='primaryField']")
    protected WebElement idCaso;
    @FindBy (xpath = "(//a[contains(text(),'--Ninguno--')])[position()=1]")
    protected WebElement selectArea;

    //Adicion de objetos casos PAK

    @FindBy (xpath = "//a[@class='select']")
    protected WebElement selectEstadoPak;

    //Adicion de objetos casos Queja
    @FindBy (xpath = "//a[text()='Media']")
    protected WebElement selectPrioridadQueja;

    @FindBy (xpath = "(//textarea[@role='textbox'])[position()=2]")
    protected  WebElement campoDescripcionQueja;

    @FindBy (xpath = "(//textarea[@role='textbox'])[position()=3]")
    protected  WebElement campoPlanesQueja;

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
            wait.until(ExpectedConditions.elementToBeClickable(checkTipoCasoFelici));
            click(checkTipoCasoFelici);
        }
        else if (tipoDeCaso.equalsIgnoreCase("Informacion")){
            wait.until(ExpectedConditions.elementToBeClickable(checkTipoCasoInforma));
            click(checkTipoCasoInforma);
        }else if (tipoDeCaso.equalsIgnoreCase("Queja")){
            wait.until(ExpectedConditions.elementToBeClickable(checkTipoCasoQueja));
            click(checkTipoCasoQueja);
        }


        click(buttonSiguiente);


    }
    public void creacionCasoFelicitaciones(String cuenta, String selectOrigenCaso, String prioridadCaso, String almacen, String asunto, String descripcion, String planesAccion, String estado){
        var wait = webDriverWait(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(campoBuscarCuenta));
        type(campoBuscarCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(clickCuenta));
        click(clickCuenta);


        WebElement seleccionaCuenta = find().getElementByXPath("(//a[contains(text(),'"+cuenta+"')])[position()=1]");
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

    public void creacionCasoInformacion(String cuenta, String selectOrigenCaso, String prioridadCaso, String area, String almacen, String asunto, String descripcion, String planesAccion, String estado){
        var wait = webDriverWait(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(campoBuscarCuenta));
        type(campoBuscarCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(clickCuenta));
        click(clickCuenta);


        WebElement seleccionaCuenta = find().getElementByXPath("(//a[contains(text(),'"+cuenta+"')])[position()=1]");
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaCuenta));
        click(seleccionaCuenta);

        click(selectOrigen);
        general.tiempoEsperaFijo();
        WebElement origenCaso = find().getElementByXPath("//a[text()='"+selectOrigenCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(origenCaso));
        click(origenCaso);

        click(selectPrioridadQueja);
        general.tiempoEsperaFijo();
        WebElement casoPrioridad = find().getElementByXPath("//a[text()='"+prioridadCaso+"']");
        wait.until(ExpectedConditions.elementToBeClickable(casoPrioridad));
        click(casoPrioridad);

        click(selectArea);
        general.tiempoEsperaFijo();
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

   /* public void crearCasoPak(String selectEstado){

        general.tiempoEsperaFijo();
        click(selectEstadoPak);
        general.tiempoEsperaFijo();
        WebElement estado = find().getElementByXPath("(//a[text()='"+selectEstado+"'])[position()=1]");
        click(estado);
        click(guardarCaso);
        general.tiempoEsperaFijo();
        //obtiene el ID del caso creado
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println(getText(idCaso));
        System.out.println("----------------------------------------------------------------------------------------");
        general.tiempoEsperaFijo();

    }*/


    public void creacionCasoQueja(String cuenta, String selectOrigenCaso, String prioridadCaso, String area, String clase, String almacen, String asunto, String descripcion, String planesAccion, String estado){
        var wait = webDriverWait(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(campoBuscarCuenta));
        type(campoBuscarCuenta, cuenta);
        wait.until(ExpectedConditions.elementToBeClickable(clickCuenta));
        click(clickCuenta);


        WebElement seleccionaCuenta = find().getElementByXPath("(//a[contains(text(),'"+cuenta+"')])[position()=1]");
        wait.until(ExpectedConditions.elementToBeClickable(seleccionaCuenta));
        click(seleccionaCuenta);

        click(selectOrigen);
        general.tiempoEsperaFijo();
        WebElement origenCaso = find().getElementByXPath("//a[contains(text(),'"+selectOrigenCaso+"')]");
        click(origenCaso);

        click(selectPrioridadQueja);
        general.tiempoEsperaFijo();
        WebElement casoPrioridad = find().getElementByXPath("//a[text()='"+prioridadCaso+"']");

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
        type(campoAsunto, asunto);
        type(campoDescripcionQueja, descripcion);
        type(campoPlanesQueja, planesAccion);

        click(selectEstado);
        general.tiempoEsperaFijo();
        WebElement selectNinguno = find().getElementByXPath("//a[contains(text(),'--Ninguno--')]");
        click(selectNinguno);
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
        click(idCaso);
        general.tiempoEsperaFijo();
    }
}
