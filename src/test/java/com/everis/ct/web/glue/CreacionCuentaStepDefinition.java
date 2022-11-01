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


    @Dado("que ingresamos a Salesforce")
    public void queIngresamosASalesforce() {
        webDriverManager.navigateTo(urlSaleforce);
    }

    @Y("^inicia sesion (.*) (.*)")
    public void iniciaSesion(String usuario, String clave) {
        casoStep.inicioSesion(usuario, clave);
    }

    @Y("Seleccionamos atencion al cliente")
    public void seleccionamosAtencionAlCliente() {
        casoStep.seleccionAtencionAlCliente();
    }

    @Y("en la lista desplegable seleccionamos la opcion cuentas")
    public void enLaListaDesplegableSeleccionamosLaOpcionCuentas() {

        casoStep.seleccionaOpcionListaDesplegable();
    }

    @Y("^Realizamos la busqueda de cuenta (.*) (.*)$")
    public void realizamosLaBusquedaDeCuenta(String cuenta, String tipoCuenta) {
        casoStep.busquedaCuenta(cuenta, tipoCuenta);
    }


    @Y("^Si la cuenta no existe realizamos la creacion de empresa (.*) (.*)")
    public void siLaCuentaNoExisteRealizamosLaCreacion(String nombreCuenta, String identificacionEmpresa) {

        casoStep.crearCuentaEmpresa(nombreCuenta, identificacionEmpresa);
    }



}
