package com.everis.ct.web.glue;

import com.everis.ct.web.WebAutomationApplication;
import com.everis.ct.web.lib.WebDriverManager;
import com.everis.ct.web.page.SandBoxPage;
import com.everis.ct.web.step.PruebaStep;
import com.everis.ct.web.step.SandBoxStep;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = WebAutomationApplication.class)
public class SandBoxStepsDefinition {

    @Value("${url.sandBox}")
    private String urlSaleforce;

    @Autowired
    private WebDriverManager webDriverManager;
    @Autowired
    private SandBoxStep casoStep;


    //private WebDriver webDriver;

    @Dado("que ingresamos a la pagina de Salesforce")
    public void queIngresamosAlSalesforce() {

        //webDriver.manage().getCookies();
        webDriverManager.navigateTo(urlSaleforce);
    }


    @Y("^iniciamos sesion (.*) (.*)$")
    public void iniciamosSesion(String user, String pass) {
        casoStep.iniciamosSesion(user,pass);
    }

    @Y("seleccionamos atencion al cliente")
    public void seleccionamosAtencionAlCliente() {

            casoStep.opcionAtencionAlCliente();
    }

    @Y("Desplegamos el menu de busqueda")
    public void desplegamosElMenuDeBusqueda() {
        casoStep.despliegaMenu();
    }

    @Y("^creamos un caso (.*) (.*) (.*) (.*) (.*)$")
    public void creamosUnCaso(String cuenta,String tipoDeCaso, String selectOrigenCaso, String prioridadCaso, String almacen) {


        try {
            Thread.sleep(10000);
            casoStep.crearCaso( tipoDeCaso, cuenta, selectOrigenCaso, prioridadCaso, almacen);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }


    @Y("^terminamos de crear el caso (.*) (.*) (.*) (.*)$")
    public void terminamosDeCrearElCaso(String asunto, String descripcion, String planesDeAccion, String estado) {

        casoStep.terminaCaso(asunto,descripcion, planesDeAccion,estado);
    }
}
