#language:es
@DEMO
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @CreacionCuenta

  Esquema del escenario: Creacion de cuenta

    Dado que ingresamos a Salesforce
    Y inicia sesion <Usuario> <Clave>
    Y Seleccionamos atencion al cliente
    Y en la lista desplegable seleccionamos la opcion cuentas
    Y Vamos a cuentas y realizamos la busqueda de cuenta
    Y Si la cuenta no existe realizamos la creacion

    Ejemplos:

      | Usuario                          | Clave        |
      |1035922188@colcomercio.com.co.uat | Pruebas2023* |



