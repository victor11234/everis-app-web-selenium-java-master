#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @CreacionCuentaEmpresa

  Esquema del escenario: Creacion de cuenta

    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <Clave>
    Y hacemos proceso de seleccion Cliente
    Y en la lista desplegable seleccionamos la opcion cuentas
    Y Realizamos la busqueda de cuenta <CuentaUsuario> Empresas
    Y Si la cuenta no existe realizamos la creacion de empresa <nombreCuenta> <identificacionEmpresa>
    Ejemplos:

      | Usuario                                              | Clave        | CuentaUsuario | nombreCuenta | identificacionEmpresa |
      |victor.manuel.lozano.cardona@colcomercio.com.co.alkqa | Pruebas2023* | 1035922189    | dsadasd      | NIT                   |



