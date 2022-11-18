#language:es
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox

  @CreacionCuentaEmpresa

  Esquema del escenario:CreacionCuentaEmpresa

    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <Clave>
    Y hacemos proceso de seleccion Cliente
    Y en la lista desplegable seleccionamos la opcion cuentas
    Y Realizamos la busqueda de cuenta <CuentaUsuario> Empresas
    Y Si la cuenta no existe realizamos la creacion de empresa <nombreCuenta> <identificacionEmpresa>
    Entonces verficamos que la cuenta está creada

    Ejemplos:

      | Usuario                                              | Clave        | CuentaUsuario | nombreCuenta        | identificacionEmpresa |
      |victor.manuel.lozano.cardona@colcomercio.com.co.alkqa | Pruebas2023* | N/A           | N/A                 | NIT                   |
      #|victor.manuel.lozano.cardona@colcomercio.com.co.alkqa | Pruebas2023* | 2314141412    | Prueba Empresa     | NIT                   |


