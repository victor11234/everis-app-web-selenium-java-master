package com.everis.ct.web.glue;

import com.everis.ct.web.step.CreaCasoStep;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;


public class CreaCasoStepsDefinition {


    @Autowired
    private CreaCasoStep casoStep;

    @Y("Desplegamos el menu de busqueda")
    public void desplegamosElMenuDeBusqueda() {
        casoStep.despliegaMenu();
    }

    @Y("^Entramos a nuevo caso, Seleccionamos el tipo de caso (.*)$")
    public void entramosANuevoCasoSeleccionamosElTipoDeCaso(String tipoCaso) {
        casoStep.seleccionaTipoCaso(tipoCaso);
    }

    @Y("^creamos un caso de felicitaciones (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*)$")
    public void creamosUnCaso(String cuenta,String selectOrigenCaso, String prioridadCaso, String almacen, String asunto, String descripcion, String planesAccion, String estado) {


        try {
            Thread.sleep(10000);
            casoStep.crearCasoFelicitaciones(cuenta, selectOrigenCaso, prioridadCaso, almacen, asunto, descripcion, planesAccion, estado);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Y("^creamos un caso de informacion (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*)$")
    public void creamosUnCasoDeInformacion(String cuenta,String selectOrigenCaso, String prioridadCaso, String area, String almacen, String asunto, String descripcion, String planesAccion, String estado) {

        try {
            Thread.sleep(10000);
            casoStep.crearCasoInformacion(cuenta, selectOrigenCaso, prioridadCaso, area, almacen, asunto, descripcion, planesAccion, estado);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Y("^creamos un caso de Queja (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*)$")
    public void creamosUnCasoDeQueja(String cuenta, String selectOrigenCaso, String prioridadCaso, String area, String clase, String almacen, String asunto, String descripcion, String planesAccion, String estado) {

        try {
            Thread.sleep(10000);
            casoStep.crearCasoQueja(cuenta, selectOrigenCaso, prioridadCaso, area, clase, almacen, asunto, descripcion, planesAccion, estado);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Y("^creamos un caso de solicitud (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*)$")
    public void creamosCasoSolicitud(String cuenta,String selectOrigenCaso, String prioridadCaso, String area, String clase, String almacen, String asunto, String descripcion, String planesAccion, String estado) {

        try {
            Thread.sleep(10000);
            casoStep.crearCasoSolicitud(cuenta, selectOrigenCaso, prioridadCaso, area, clase, almacen, asunto, descripcion, planesAccion, estado);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Entonces("verificamos el caso creado")
    public void verificamosElCasoCreado() {

        casoStep.verifcaCasoCreado();
    }
}
