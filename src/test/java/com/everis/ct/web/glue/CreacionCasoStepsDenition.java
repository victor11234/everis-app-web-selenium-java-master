package com.everis.ct.web.glue;

import com.everis.ct.web.WebAutomationApplication;
import com.everis.ct.web.lib.WebDriverManager;
import com.everis.ct.web.step.CreacionCasoStep;
import com.everis.ct.web.step.SandBoxStep;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@CucumberContextConfiguration
@SpringBootTest(classes = WebAutomationApplication.class)
public class CreacionCasoStepsDenition {
    @Value("${url.salesForce}")
    private String urlSaleforce;

    @Autowired
    private WebDriverManager webDriverManager;
    @Autowired
    private CreacionCasoStep sandBoxStep;

    @Dado("que ingresamos a la pagina de Salesforce")
    public void queIngresamosAlSalesforce() {

        webDriverManager.navigateTo(urlSaleforce);
    }
    @Y("iniciamos sesion <Usuario> <clave>")
    public void iniciamosSesionUsuarioClave() {
    }

    @Y("Desplegamos el menu de busqueda")
    public void desplegamosElMenuDeBusqueda() {
    }

    @Y("creamos un caso <tipoDeCaso>")
    public void creamosUnCasoTipoDeCaso() {
    }
}
