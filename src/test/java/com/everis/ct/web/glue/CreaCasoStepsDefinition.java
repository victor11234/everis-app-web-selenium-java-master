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

    @Y("^Entramos a nuevo caso, Seleccionamos el tipo de caso(.*)$")
    public void entramosANuevoCasoSeleccionamosElTipoDeCaso(String tipoCaso) {
        casoStep.seleccionaTipoCaso(tipoCaso);
    }

    @Y("^creamos un caso de felicitaciones (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*)$")
    public void creamosUnCaso(String cuenta,String selectOrigenCaso, String prioridadCaso, String almacen, String asunto, String descripcion, String planesAccion, String estado) {


        try {
            Thread.sleep(10000);
            casoStep.crearCaso(cuenta, selectOrigenCaso, prioridadCaso, almacen, asunto, descripcion, planesAccion, estado);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }


}
