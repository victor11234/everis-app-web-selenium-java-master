#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @CreacionCuentaAliados

  Esquema del escenario: Creacion de cuenta
    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <Clave>
    Y hacemos proceso de seleccion Cliente
    Y en la lista desplegable seleccionamos la opcion cuentas
    Y Realizamos la busqueda de cuenta <cuentaUsuario> Aliados
    Y Si la cuenta no existe realizamos la creacion de aliados <cuenta>
    Ejemplos:
      | Usuario                           | Clave        | cuentaUsuario  | cuenta       |
      | 1016091477@colcomercio.com.co.uat | Js101609     | N/A     | N/A     |




