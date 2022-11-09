package com.everis.ct.web.hooks;

import com.everis.ct.web.lib.WebDriverManager;
import com.everis.ct.web.service.stepdefinition.ManageScenario;
import com.everis.ct.web.util.General;
import io.cucumber.java.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    @Autowired
    private WebDriverManager manager;

    @Autowired
    private ManageScenario scenario;

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }

    @ParameterType(value = "true|false")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }

    General general = new General();
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    DateFormat dateFormatCompleto = new SimpleDateFormat("dd:MM:yy HH:mm:ss");
    Date dateInicial;
    Date dateFinal;

    @Before(order = 0)
    public void setUp() {
        manager.setUpDriver();
    }

    @Before(order = 1)
    public void handleScenario(Scenario scenario) {
        this.scenario.setScenario(scenario);
    }

    @Before(order = 2)
    public void timeInitial() {
        dateInicial = new Date();
        System.out.println("Hora actual: " + dateFormat.format(dateInicial));
    }

    @After(order = 0)
    public void afterScenario() {

        manager.quitDriver();
    }

    @After(order = 1)
    public void tearDown() {
        scenario.shotWhenFail();
    }

    @After(order = 2)
    public void processReport() {
      /*
        //Proceso de hora
        dateFinal = new Date();
        System.out.println("Hora actual: " + dateFormat.format(dateFinal));
        Date difference = general.getDifferenceBetwenDates(dateInicial,dateFinal);
        System.out.println(dateFormat.format(difference)); //00:02:00
        try {
            Thread.sleep(180000);
        }catch (Exception e){
            e.getMessage();
        }
        //Proceso de creación de carpeta general
        general.creacionCarpetasReporte(System.getProperty("user.dir") + "//reportes//indicadores");
        //Proceso de creación de carpeta hora y ejecucion
        String rutaFechaReporte = System.getProperty("user.dir") + "//reportes//indicadores//"+dateFormatCompleto.format(dateInicial).replaceAll(":",".").replaceAll(" ","_");
        general.creacionCarpetasReporte(rutaFechaReporte);
        try {
            File file =new File(System.getProperty("user.dir")+"\\target\\cucumber\\site\\cucumber-html-reports");
            if (file.exists()){
                System.out.println("El archivo cucumber existe");
            }else{
                System.out.println("El archivo no cucumber existe");
            }
        }catch (Exception e){
            e.getMessage();
        }
        //Proceso de movimiento de reportes
        general.movimientoDeArchivos(System.getProperty("user.dir")+"\\target\\cucumber\\site\\cucumber-html-reports",rutaFechaReporte);
*/
    }

}
