package com.everis.ct.web.step;

import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.everis.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class CreaCasoStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void despliegaMenu() {
        page.creaCasoPage().listaDesplegable();
    }

    @ScreenShotBefore
    public void seleccionaTipoCaso(String tipoCaso){

       page.creaCasoPage().seleccionTipoCaso(tipoCaso);
    }

    @ScreenShotAfter
    public void crearCasoFelicitaciones(String cuenta, String selectOrigenCaso, String prioridadCaso, String almacen, String asunto, String descripcion, String planesAccion, String estado){

        page.creaCasoPage().creacionCasoFelicitaciones(cuenta, selectOrigenCaso, prioridadCaso, almacen, asunto, descripcion, planesAccion, estado);

    }

    @ScreenShotAfter
    public void crearCasoInformacion(String cuenta, String selectOrigenCaso, String area, String prioridadCaso, String almacen, String asunto, String descripcion, String planesAccion, String estado){

        page.creaCasoPage().creacionCasoInformacion(cuenta, selectOrigenCaso, area, prioridadCaso, almacen, asunto, descripcion, planesAccion, estado);

    }

    @ScreenShotAfter
    public void crearCasoQueja(String cuenta, String selectOrigenCaso, String prioridadCaso, String area, String clase, String almacen, String asunto, String descripcion, String planesAccion, String estado){

        page.creaCasoPage().creacionCasoQueja(cuenta, selectOrigenCaso, prioridadCaso, area, clase, almacen, asunto, descripcion, planesAccion, estado);

    }

    @ScreenShotAfter
    public void crearCasoSolicitud(String cuenta, String selectOrigenCaso, String prioridadCaso, String area, String clase, String almacen, String asunto, String descripcion, String planesAccion, String estado){

        page.creaCasoPage().creacionCasoSolicitud(cuenta, selectOrigenCaso, prioridadCaso, area, clase, almacen, asunto, descripcion, planesAccion, estado);

    }
    @ScreenShotAfter
    public void verifcaCasoCreado(){

        page.creaCasoPage().verifcarCasoCreado();
    }

}
