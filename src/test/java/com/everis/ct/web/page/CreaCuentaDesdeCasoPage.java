package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import com.everis.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.everis.ct.web.util.General;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreaCuentaDesdeCasoPage extends WebBase {

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
    @FindBy (xpath = "//span[contains(text(),'SUGERENCIA')]")
    protected WebElement checkTipoCasoSugerencia;

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

    @FindBy (xpath = "//span[@title = 'Crear Cuenta']")
    protected WebElement botonCrearCuenta;

    @FindBy (xpath = "//span[contains(text(),'Persona Natural')]" )
    protected WebElement opcionPersona;

    @FindBy (xpath = "//span[contains(text(),'Empresa')]" )
    protected WebElement opcionEmpresa;

    @FindBy (xpath = "(//button[@title= 'Guardar'])[position()=2]")
    protected WebElement guardaCaso;

    @FindBy (xpath = "(//input[@role = 'combobox'])[position()=5]")
    protected WebElement nombreCuentaEmpresas;

    @FindBy (xpath = "//input[@class = 'firstName compoundBorderBottom form-element__row input']")
    protected WebElement nombreCuentaPersonas;

    @FindBy (xpath = "//input[@class = 'lastName compoundBLRadius compoundBRRadius form-element__row input']")
    protected WebElement apellidoPersonas;

    @FindBy (xpath = "//button[@class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']")
    protected WebElement siguiente;

    General general = new General();


    public void creaCuenta(String cuenta, String tipoRegistro, String nombreCuenta, String apellido){

        var wait = webDriverWait(Duration.ofSeconds(10));
        general.tiempoEsperaFijo();
        cuenta = general.primelaLetraDeCadaPalabra(cuenta);
        type(campoBuscarCuenta, cuenta);
        if(general.verificarSiExisteObjeto(driver(), "(//div[@class = 'listContent'])[position()=2]")){
            general.tiempoEsperaFijo();
            click(botonCrearCuenta);

        }else{
            Assert.fail("El número de cuenta indicado ya se encuentra creado");}

        if (tipoRegistro.equalsIgnoreCase("Empresa")){

            general.tiempoEsperaFijo();
            click(opcionEmpresa);
            click(siguiente);
            general.tiempoEsperaFijo();
            type(nombreCuentaEmpresas,nombreCuenta);
            click(guardaCaso);
            general.tiempoEsperaFijo();

        }else if (tipoRegistro.equalsIgnoreCase("Persona")){

            general.tiempoEsperaFijo();
            click(opcionPersona);
            click(siguiente);
            general.tiempoEsperaFijo();
            type(nombreCuentaPersonas, nombreCuenta);
            type(apellidoPersonas, apellido);
            click(guardaCaso);
            general.tiempoEsperaFijo();
        }

    }
    public void creacionCasoFelicitaciones(String selectOrigenCaso, String prioridadCaso, String almacen, String asunto, String descripcion, String planesAccion, String estado){
        var wait = webDriverWait(Duration.ofSeconds(10));
        general.tiempoEsperaFijo();
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

}
