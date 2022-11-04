#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @inicioSesion
  Esquema del escenario: Creacion de caso
    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <clave>
    Entonces verificamos el logueo exitoso

    Ejemplos:
      | Usuario                           | clave        |
      | 1035922188@colcomercio.com.co.uat | Pruebas2023* |








