package com.everis.ct.web.hooks;

import com.everis.ct.web.lib.WebDriverManager;
import com.everis.ct.web.service.stepdefinition.ManageScenario;
import com.everis.ct.web.util.General;
import io.cucumber.java.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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


    @Before(order = 0)
    public void setUp() {
       // modificacionCeldas("CreacionCuentaEmpresa","29/11/2022","12:10:20","succes");
        manager.setUpDriver();
    }

    @Before(order = 1)
    public void handleScenario(Scenario scenario) {
        this.scenario.setScenario(scenario);
    }



    @After(order = 0)
    public void afterScenario() {
        manager.quitDriver();
    }

    @After(order = 1)
    public void tearDown() {
        System.out.println(this.scenario.getScenario().getStatus().toString());
        System.out.println(scenario.getScenario().getName());
        scenario.shotWhenFail();
        general.obtenerHoraFinal();
        general.procesoReporte();
        general.modificacionCeldas(scenario.getScenario().getName().toString(),this.scenario.getScenario().getStatus().toString());
    }

}
