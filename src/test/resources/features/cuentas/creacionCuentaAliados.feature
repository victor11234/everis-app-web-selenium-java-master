#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @CreacionCuentaAliados

  Esquema del escenario:CreacionCuentaAliados
    Dado que ingresamos a la pagina de Salesforce
    Y ingresamos los datos de inicio de sesion <Usuario> <Clave>
    Y iniciamos sesion
    Y hacemos proceso de seleccion Cliente
    Y en la lista desplegable seleccionamos la opcion cuentas
    Y ingresamos la cuenta <cuentaUsuario>
    Y Realizamos la busqueda de cuenta Aliados
    Y Si la cuenta no existe realizamos la creacion de aliados <cuenta>
    Entonces verficamos que la cuenta está creada

    Ejemplos:
      | Usuario                                                  | Clave        | cuentaUsuario  | cuenta            |
      | jefersonstiben.pedrazaecheverry@colcomercio.com.co.alkqa | Js101609     | N/A            | N/A               |
     #| jefersonstiben.pedrazaecheverry@colcomercio.com.co.alkqa | Js101609     | 63616371       | Prueba Aliados    |




