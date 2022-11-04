package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
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



    public void iniciamosSesion(String user, String pass) {

        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        type(userName, user);
        type(password, pass);
        click(buttonLogin);


    }

    public void verificamosElLogueoExitoso() {
        var wait = webDriverWait(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(atencionAlCliente));

    }

}
