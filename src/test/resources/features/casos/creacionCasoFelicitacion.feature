#language:es
@DEMO
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox


  @creacionCaso
  Esquema del escenario: Creacion de caso

    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <clave>
    Y seleccionamos atencion al cliente
    Y Desplegamos el menu de busqueda
    Y creamos un caso <cuenta> <tipoDeCaso> <selectOrigenCaso> <prioridadCaso> <almacen>
    Y terminamos de crear el caso <asunto> <descripcion> <planesDeAccion> <estado>



    Ejemplos:

      | Usuario                           | clave        | tipoDeCaso          | selectOrigenCaso|  cuenta       |   prioridadCaso | almacen | asunto |descripcion | planesDeAccion | estado |
      | 1035922188@colcomercio.com.co.uat | Pruebas2023* | FELICITACIONES      |    Teléfono     | VICTOR LOZANO |    Baja         | 68      | dasda  | sdasd      |  ewqeqwew      | Nuevo  |









