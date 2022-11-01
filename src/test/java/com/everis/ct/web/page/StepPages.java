package com.everis.ct.web.page;

import com.everis.ct.web.step.CreacionCuentaStep;
import org.springframework.stereotype.Component;

@Component
public class StepPages {

    public SandBoxPage sandBoxPage() {return new SandBoxPage();
    }
    public PruebaPage sandBoxPage1() {return new PruebaPage();
    }

    public CreacionCuentaStep creacionCuenta() {return new CreacionCuentaStep();
    }

}
