package com.everis.ct.web.glue;

import com.everis.ct.web.step.CreacionCuentaStep;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class CreacionCuentaStepDefinition {
    @Autowired
    private CreacionCuentaStep casoStep;


    @Y("en la lista desplegable seleccionamos la opcion cuentas")
    public void enLaListaDesplegableSeleccionamosLaOpcionCuentas() {
        casoStep.seleccionaOpcionListaDesplegable();
    }

    @Y("^ingresamos la cuenta y realizamos la busqueda (.*)$")
    public void ingresamosLaCuenta(String cuentaUsuario) {

        casoStep.ingresarCuenta(cuentaUsuario);
    }

    @Y("^seleccionamos el tipo de cuenta (.*)$")
    public void realizamosLaBusquedaDeCuenta(String tipoCuenta) {
        casoStep.busquedaCuenta(tipoCuenta);
    }


    @Y("^Si la cuenta no existe realizamos la creacion de empresa (.*) (.*)")
    public void siLaCuentaNoExisteRealizamosLaCreacion(String nombreCuenta, String identificacionEmpresa) {

        casoStep.crearCuentaEmpresa(nombreCuenta, identificacionEmpresa);
    }


    @Y("^Si la cuenta no existe realizamos la creacion de personas (.*) (.*) (.*) (.*) (.*)")
    public void siLaCuentaNoExisteRealizamosLaCreacionDePersonas(String nombre, String apellido, String email, String telefono, String tipoDeDocumento) {

        casoStep.crearCuentaPersona(nombre, apellido, email, telefono, tipoDeDocumento);
    }

    @Y("^Si la cuenta no existe realizamos la creacion de aliados (.*)")
    public void siLaCuentaNoExisteRealizamosLaCreacionDeAliados(String cuenta) {

        casoStep.crarCuentaAliados(cuenta);
    }

    @Entonces("verficamos que la cuenta está creada")
    public void verficamosQueLaCuentaEstáCreada() {

        casoStep.verificacuenta();
    }


}
