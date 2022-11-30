#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @inicioSesionFallido
  Esquema del escenario: inicioSesionFallido
    Dado que ingresamos a la pagina de Salesforce
    Y ingresamos los datos de inicio de sesion <usuario> <clave>
    Y iniciamos sesion
    Entonces verificamos el logueo fallido

    Ejemplos:
      | usuario                                            | clave        |
      | victor.manuel.lozano.cardona@colcomercio.com.co.kq | Pruebas2023* |








