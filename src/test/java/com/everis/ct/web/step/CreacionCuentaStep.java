package com.everis.ct.web.step;

import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class CreacionCuentaStep {

    @Autowired
    private StepPages page;

    public void inicioSesion( String usuario, String clave){

        page.creacionCuenta().iniciamosSesion(usuario, clave);
    }

    public void seleccionAtencionAlCliente(){

        page.creacionCuenta().atencionAlCliente();
    }

    public void seleccionaOpcionListaDesplegable() {

        page.creacionCuenta().listaDesplegable();
    }

    public void busquedaCuenta(String cuenta, String tipoCuenta){

        page.creacionCuenta().busquedaCuenta(cuenta, tipoCuenta);
    }

    public void crearCuentaEmpresa(String nombreCuenta, String identificacionEmpresa){

        page.creacionCuenta().crearCuentaEmpresa(nombreCuenta, identificacionEmpresa);
    }
}
