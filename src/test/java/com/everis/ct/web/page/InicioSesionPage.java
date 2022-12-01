package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import com.everis.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.everis.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.everis.ct.web.util.General;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class InicioSesionPage extends WebBase {



    @FindBy (xpath = "//input[@id='username']" )
    protected WebElement userName;

    @FindBy (xpath = "//input[@id='password']" )
    protected WebElement password;

    @FindBy (xpath = "//input[@id='Login']" )
    protected WebElement buttonLogin;

    @FindBy (xpath = "//span[@title='Atención al Cliente']")
    protected WebElement atencionAlCliente;

    @FindBy (xpath = "//font[contains(text(), 'Si aún no puede iniciar sesión, comuníquese con su administrador de Salesforce.')]")
    protected WebElement loginNoxitoso;



   General general = new General();


    public void ingresarDatosSesion(String user, String pass){
        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        type(userName, user);
        type(password, pass);
    }
    public void iniciamosSesion() {

        click(buttonLogin);


    }

    public void verificamosElLogueoExitoso() {
        var wait = webDriverWait(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(atencionAlCliente));


    }

    public void verificamosElLogueoFallido() {
        var wait = webDriverWait(Duration.ofSeconds(30));
        general.tiempoEsperaFijo();
        if(general.verificarSiExisteObjeto(driver(),"//div[@class = 'slds-icon-waffle']")){

            Assert.fail("El usuario y contraseña son correctos");
        }

    }

}
