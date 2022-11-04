package com.everis.ct.web.step;

import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@ScreenShot
@Component
public class InicioSesionStep {

    @Autowired
    private StepPages page;


    public void iniciamosSesion(String user, String pass) {
        page.inicioSesionPage().iniciamosSesion(user, pass);
    }

    public void verificamosElLogueoExitoso() {
        page.inicioSesionPage().verificamosElLogueoExitoso();
    }
}
