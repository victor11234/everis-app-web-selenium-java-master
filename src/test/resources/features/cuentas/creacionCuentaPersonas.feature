#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @CreacionCuentaPersonas

  Esquema del escenario: Creacion de cuenta

    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <Clave>
    Y hacemos proceso de seleccion Cliente
    Y en la lista desplegable seleccionamos la opcion cuentas
    Y Realizamos la busqueda de cuenta  <CuentaUsuario> Persona
    Y Si la cuenta no existe realizamos la creacion de personas <nombre> <apellido> <email> <telefono> <documento>

    Ejemplos:

      | Usuario                                               | Clave        | CuentaUsuario  | nombre   | apellido | email            | telefono   | documento |
      | jefersonstiben.pedrazaecheverry@colcomercio.com.co.alkqa | Js101609     | 23126124       | dsadasd  | dsadsd   | prueba@gmail.com | 3106677777 | Cedula |



