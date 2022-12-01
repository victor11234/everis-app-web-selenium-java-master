package com.everis.ct.web.step;

import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShot;
import com.everis.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CreacionCuentaStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void seleccionaOpcionListaDesplegable() {
        page.creacionCuenta().listaDesplegable();
    }

    @ScreenShotAfter
    public void ingresarCuenta(String cuenta){

        page.creacionCuenta().ingresarCuenta(cuenta);
    }
    @ScreenShotAfter
    public void busquedaCuenta(String tipoCuenta){

        page.creacionCuenta().busquedaCuenta(tipoCuenta);
    }

    @ScreenShotAfter
    public void crearCuentaEmpresa(String nombreCuenta, String identificacionEmpresa){

        page.creacionCuenta().crearCuentaEmpresa(nombreCuenta, identificacionEmpresa);
    }
    @ScreenShotAfter
    public  void crearCuentaPersona(String nombre, String apellido, String email, String telefono, String tipoDeDocumento){

        page.creacionCuenta().crearCuentaPersonas(nombre, apellido, email, telefono, tipoDeDocumento);
    }
    @ScreenShotAfter
    public void crarCuentaAliados(String cuenta){

        page.creacionCuenta().crearCuentaAliados(cuenta);
    }

    @ScreenShotAfter
    public void cuentaExistente(String cuenta){

        page.creacionCuenta().cuentaExistente(cuenta);
    }

    @ScreenShotAfter
    public void verificacuenta(){

        page.creacionCuenta().verificarCuenta();
    }

}
