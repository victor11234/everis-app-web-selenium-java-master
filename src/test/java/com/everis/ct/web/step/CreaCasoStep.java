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


    public void iniciamosSesion(String user, String pass) {
        page.sandBoxPage().iniciamosSesion(user, pass);
    }

    public void opcionAtencionAlCliente(){
        page.sandBoxPage().atencionAlCliente();
    }

    public void despliegaMenu() {

        page.sandBoxPage().listaDesplegable();
    }
    public void crearCaso(String tipoDeCaso, String cuenta, String selectOrigenCaso, String prioridadCaso, String almacen){

        page.sandBoxPage().creacionCaso(tipoDeCaso, cuenta, selectOrigenCaso, prioridadCaso, almacen);
    }

    public void terminaCaso(String asunto, String descripcion, String planesDeAccion, String estado){

        page.sandBoxPage().terminaCaso(asunto,descripcion, planesDeAccion,estado);
    }
}
