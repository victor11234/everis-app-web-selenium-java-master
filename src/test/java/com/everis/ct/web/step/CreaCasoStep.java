package com.everis.ct.web.step;

import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@ScreenShot
@Component
public class CreaCasoStep {

    @Autowired
    private StepPages page;

    public void despliegaMenu() {
        page.creaCasoPage().listaDesplegable();
    }
    public void crearCaso(String tipoDeCaso, String cuenta, String selectOrigenCaso, String prioridadCaso, String almacen){

        page.creaCasoPage().creacionCaso(tipoDeCaso, cuenta, selectOrigenCaso, prioridadCaso, almacen);
    }

    public void terminaCaso(String asunto, String descripcion, String planesDeAccion, String estado){

        page.creaCasoPage().terminaCaso(asunto,descripcion, planesDeAccion,estado);
    }
}
