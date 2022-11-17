#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @inicioSesion
  Esquema del escenario: inicioSesion
    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <clave>
    Entonces verificamos el logueo exitoso

    Ejemplos:
      | Usuario                           | clave        |
      | victor.manuel.lozano.cardona@colcomercio.com.co.kqa | Pruebas2023* |








