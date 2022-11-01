package com.everis.ct.web.step;

import com.everis.ct.web.page.CreacionCuentaPage;
import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class CreacionCuentaStep {

    @Autowired
    private CreacionCuentaPage page;

    public void inicioSesion( String usuario, String clave){

        page.iniciamosSesion(usuario, clave);
    }

    public void seleccionAtencionAlCliente(){

        page.atencionAlCliente();
    }

    public void seleccionaOpcionListaDesplegable() {

        page.listaDesplegable();
    }
}