package com.everis.ct.web.step;

import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@ScreenShot
@Component
public class CreacionCasoStep {

    @Autowired
    private StepPages page;


    public void iniciamosSesion(String user, String pass) {
        page.creacionCasoPage().iniciamosSesion(user, pass);
    }

    public void despliegaMenu() {

        page.creacionCasoPage().listaDesplegable();
    }
    public void crearCaso(String tipoDeCaso){

        page.creacionCasoPage().creacionCaso(tipoDeCaso);
    }
}
