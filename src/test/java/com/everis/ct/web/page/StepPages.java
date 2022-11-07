package com.everis.ct.web.page;

import org.springframework.stereotype.Component;

@Component
public class StepPages {

    public CreaCasoPage creaCasoPage() {return new CreaCasoPage();
    }

    public CreacionCuentaPage creacionCuenta() {return new CreacionCuentaPage();
    }

    public InicioSesionPage inicioSesionPage() {return new InicioSesionPage();
    }

    public PaginaInicioPage paginaInicioPage() {return new PaginaInicioPage();
    }

}
