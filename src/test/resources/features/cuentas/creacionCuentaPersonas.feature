#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @CreacionCuentaPersonas

  Esquema del escenario: Creacion de cuenta

    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <Clave>
    Y Seleccionamos atencion al cliente
    Y en la lista desplegable seleccionamos la opcion cuentas
    Y Realizamos la busqueda de cuenta  <CuentaUsuario> Persona
    Y Si la cuenta no existe realizamos la creacion de personas <nombre> <apellido> <email> <telefono> <documento>

    Ejemplos:

      | Usuario                           | Clave        | CuentaUsuario  | nombre   | apellido | email | telefono | documento |
      | 1016091477@colcomercio.com.co.uat | Js101609     | 23124124       | dsadasd  | dsadsd   | prueba@gmail.com | 3106677777 | Cedula |



