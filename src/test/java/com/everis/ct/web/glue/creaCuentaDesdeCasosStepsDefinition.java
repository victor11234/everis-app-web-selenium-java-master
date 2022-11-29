package com.everis.ct.web.glue;

import com.everis.ct.web.step.CreaCasoStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class creaCuentaDesdeCasosStepsDefinition {

    @Autowired
    private CreaCasoStep casoStep;

    @Y("^entramos al tipo de caso y creamos la cuenta (.*) (.*) (.*) (.*)$")
    public void entramosAlTipoDeCasoCreamosLaCuentaCuenta(String cuenta, String tipoRegistro, String nombreCuenta,String apellido) {
     casoStep.creaCuentaDesdeCaso(cuenta, tipoRegistro, nombreCuenta, apellido);
    }

    @Y("^creamos un caso de felicitaciones. (.*) (.*) (.*) (.*) (.*) (.*) (.*)")
    public void creamosUnCasoDeFelicitaciones(String selectOrigenCaso, String prioridadCaso, String almacen, String asunto, String descripcion, String planesAccion, String estado) {
    casoStep.creaCaso(selectOrigenCaso, prioridadCaso, almacen, asunto, descripcion, planesAccion, estado);
    }


}
