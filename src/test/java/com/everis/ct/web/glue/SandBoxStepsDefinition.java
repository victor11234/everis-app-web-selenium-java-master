package com.everis.ct.web.glue;

import com.everis.ct.web.WebAutomationApplication;
import com.everis.ct.web.lib.WebDriverManager;
import com.everis.ct.web.step.SandBoxStep;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = WebAutomationApplication.class)
public class SandBoxStepsDefinition {

    @Value("${url.sandBox}")
    private String urlSandBox;

    @Autowired
    private WebDriverManager webDriverManager;
    @Autowired
    private SandBoxStep sandBoxStep;

    @Dado("que abro la pagina de sandbox")
    public void queAbroLaPaginaDeSandbox() {

        webDriverManager.navigateTo(urlSandBox);
    }

    @Y("aceptamos las cookies")
    public void aceptamosLasCookies() {

        sandBoxStep.aceptamosLasCookies();
        System.out.println("Prueba");
    }

    @Y("iniciamos sesion")
    public void iniciamosSesion() {

    }

    @Entonces("acceder a leer")
    public void accederLeer() {

        sandBoxStep.clickLeer();
    }
}
