#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @CreacionCuentaAliados

  Esquema del escenario: Creacion de cuenta

    Dado que ingresamos a Salesforce
    Y inicia sesion <Usuario> <Clave>
    Y Seleccionamos atencion al cliente
    Y en la lista desplegable seleccionamos la opcion cuentas
    Y Realizamos la busqueda de cuenta  <CuentaUsuario>
    Y Si la cuenta no existe realizamos la creacion de aliados <cuenta>
    Ejemplos:

      | Usuario                           | Clave        | CuentaUsuario  | cuenta   |
      | 1016091477@colcomercio.com.co.uat | Js101609     | 1035922188     | sdasdas  |




