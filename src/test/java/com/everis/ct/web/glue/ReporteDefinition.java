package com.everis.ct.web.glue;

import com.everis.ct.web.util.General;
import io.cucumber.java.es.Entonces;

public class ReporteDefinition {
    General general = new General();
    @Entonces("^hacemos la generacion del reporte con su indicador (.*)$")
    public void hacemosLaGeneracionDelReporteConSuIndicadorCreacionCuentaEmpresa(String nombreHojaExcel) {
      /*  general.obtenerHoraFinal();
        general.procesoReporte();
        general.modificacionCeldas(nombreHojaExcel);*/
    }
}
