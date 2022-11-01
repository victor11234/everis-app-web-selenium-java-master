package com.everis.ct.web.glue;

import com.everis.ct.web.lib.WebDriverManager;
import com.everis.ct.web.step.CreacionCuentaStep;
import com.everis.ct.web.step.SandBoxStep;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class CreacionCuentaStepDefinition {

    @Value("${url.sandBox}")
    private String urlSaleforce;

    @Autowired
    private WebDriverManager webDriverManager;
    @Autowired
    private CreacionCuentaStep casoStep;


    //private WebDriver webDriver;

    @Dado("que ingresamos a la pagina de Salesforce")
    public void queIngresamosAlSalesforce() {

        //webDriver.manage().getCookies();
        webDriverManager.navigateTo(urlSaleforce);
    }
    @Dado("que ingresamos a Salesforce")
    public void queIngresamosASalesforce() {

    }

    @Y("inicia sesion <Usuario> <Clave>")
    public void iniciaSesionUsuarioClave() {
    }

    @Y("Seleccionamos atencion al cliente")
    public void seleccionamosAtencionAlCliente() {
    }

    @Y("en la lista desplegable seleccionamos la opcion cuentas")
    public void enLaListaDesplegableSeleccionamosLaOpcionCuentas() {
    }

    @Y("Vamos a cuentas y realizamos la busqueda de cuenta")
    public void vamosACuentasYRealizamosLaBusquedaDeCuenta() {
    }

    @Y("Si la cuenta no existe realizamos la creacion")
    public void siLaCuentaNoExisteRealizamosLaCreacion() {
    }
}
