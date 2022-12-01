#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @cuentaExistente

  Esquema del escenario:cuentaExistente

    Dado que ingresamos a la pagina de Salesforce
    Y ingresamos los datos de inicio de sesion <Usuario> <Clave>
    Y iniciamos sesion
    Y hacemos proceso de seleccion Cliente
    Y en la lista desplegable seleccionamos la opcion cuentas
    Y ingresamos a la cuenta y realizamos la busqueda <CuentaUsuario>
    Entonces verficamos que la cuenta está creada

    Ejemplos:

      | Usuario                                                  | Clave        | CuentaUsuario  |
      | jefersonstiben.pedrazaecheverry@colcomercio.com.co.alkqa | Js101609     | 323123        |