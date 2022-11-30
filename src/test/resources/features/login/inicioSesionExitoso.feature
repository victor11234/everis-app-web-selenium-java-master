#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @inicioSesionExitoso
  Esquema del escenario: inicioSesionExitoso
    Dado que ingresamos a la pagina de Salesforce
    Y ingresamos los datos de inicio de sesion <usuario> <clave>
    Y iniciamos sesion
    Entonces verificamos el logueo exitoso

    Ejemplos:
      | usuario                                               | clave        |
      | victor.manuel.lozano.cardona@colcomercio.com.co.alkqa | Pruebas2023* |








