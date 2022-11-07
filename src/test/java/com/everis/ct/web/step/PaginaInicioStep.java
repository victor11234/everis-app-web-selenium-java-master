package com.everis.ct.web.step;

import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@ScreenShot
@Component
public class PaginaInicioStep {

    @Autowired
    private StepPages page;

    public void hacemosProcesoDeSeleccion(String opcion) {
        page.paginaInicioPage().ingresamosAlMenuDeseado(opcion);
    }

}
