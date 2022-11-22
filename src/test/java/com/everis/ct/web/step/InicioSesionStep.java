package com.everis.ct.web.step;

import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShot;
import com.everis.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class InicioSesionStep {

    @Autowired
    private StepPages page;
    @ScreenShotAfter
    public void ingresarDatosSesion(String user, String pass){page.inicioSesionPage().ingresarDatosSesion(user, pass);}
    @ScreenShotAfter
    public void iniciamosSesion() {
        page.inicioSesionPage().iniciamosSesion();
    }
    @ScreenShotAfter
    public void verificamosElLogueoExitoso() {
        page.inicioSesionPage().verificamosElLogueoExitoso();
    }
}
