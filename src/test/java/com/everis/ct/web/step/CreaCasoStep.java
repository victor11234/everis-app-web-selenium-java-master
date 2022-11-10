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

    public void seleccionaTipoCaso(String tipoCaso){

       page.creaCasoPage().seleccionTipoCaso(tipoCaso);
    }
    public void crearCaso(String cuenta, String selectOrigenCaso, String prioridadCaso, String almacen, String asunto, String descripcion, String planesAccion, String estado){

        page.creaCasoPage().creacionCaso(cuenta, selectOrigenCaso, prioridadCaso, almacen, asunto, descripcion, planesAccion, estado);

    }


}
