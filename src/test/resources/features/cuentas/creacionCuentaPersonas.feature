#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @CreacionCuentaPersonas

  Esquema del escenario:CreacionCuentaPersonas

    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <Clave>
    Y hacemos proceso de seleccion Cliente
    Y en la lista desplegable seleccionamos la opcion cuentas
    Y Realizamos la busqueda de cuenta <CuentaUsuario> Persona
    Y Si la cuenta no existe realizamos la creacion de personas <nombre> <apellido> <email> <telefono> <documento>
    Entonces verficamos que la cuenta está creada

    Ejemplos:

      | Usuario                                                  | Clave        | CuentaUsuario  | nombre           | apellido | email            | telefono        | documento              |
      | jefersonstiben.pedrazaecheverry@colcomercio.com.co.alkqa | Js101609     | N/A            | N/A              | N/A      | N/A              | N/A             | Cedula                 |
      #| jefersonstiben.pedrazaecheverry@colcomercio.com.co.alkqa | Js101609     | 323123        | Prueba          | Personas | prueba@gmail.com | 3105686111      | Cedula de extrajeria   |



