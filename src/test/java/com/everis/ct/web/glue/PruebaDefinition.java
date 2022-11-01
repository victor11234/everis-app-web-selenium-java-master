package com.everis.ct.web.glue;

import com.everis.ct.web.lib.WebDriverManager;
import com.everis.ct.web.step.PruebaStep;
import com.everis.ct.web.step.SandBoxStep;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class PruebaDefinition {

    @Value("${url.google}")
    private String urlGoogle;

    @Autowired
    private WebDriverManager webDriverManager;
    @Autowired
    private PruebaStep casoStep;
    @Dado("que ingresamos a la pagina de google")
    public void queIngresamosALaPaginaDeGoogle() {

        webDriverManager.navigateTo(urlGoogle);
    }

    @Y("buscamos algo")
    public void buscamosAlgo() {

        casoStep.BucamosAlgo();
    }
}
