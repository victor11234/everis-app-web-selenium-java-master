package com.everis.ct.web.glue;

import com.everis.ct.web.step.CreaCasoStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;


public class CreaCasoStepsDefinition {


    @Autowired
    private CreaCasoStep casoStep;

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
