package com.everis.ct.web.glue;

import com.everis.ct.web.WebAutomationApplication;
import com.everis.ct.web.lib.WebDriverManager;
import com.everis.ct.web.step.InicioSesionStep;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = WebAutomationApplication.class)
public class inicioSesionDefinition {

    @Value("${url.sandBox}")
    private String urlSaleforce;

    @Autowired
    private WebDriverManager webDriverManager;

    @Autowired
    private InicioSesionStep inicioSesionStep;


    @Dado("que ingresamos a la pagina de Salesforce")
    public void queIngresamosALaPaginaDeSalesforce() {
        /*General g = new General();
        System.out.println(g.firstName());
        System.out.println(g.lastName());
        System.out.println(g.getRandomValue());*/
        webDriverManager.navigateTo(urlSaleforce);
    }

    @Y("^iniciamos sesion (.*) (.*)$")
    public void iniciamosSesionUsuarioClave(String usuario, String clave) {
        inicioSesionStep.iniciamosSesion(usuario, clave);
    }

    @Entonces("verificamos el logueo exitoso")
    public void verificamosElLogueoExitoso() {
        inicioSesionStep.verificamosElLogueoExitoso();
    }

}
