package com.everis.ct.web.glue;

import com.everis.ct.web.step.InicioSesionStep;
import com.everis.ct.web.step.PaginaInicioStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class PaginaInicioDefinition {
    @Autowired
    private PaginaInicioStep paginaInicioStep;
    @Y("^hacemos proceso de seleccion (.*)$")
    public void hacemosProcesoDeSeleccion(String opcion) {
        paginaInicioStep.hacemosProcesoDeSeleccion(opcion);
    }
}
