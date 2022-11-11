#language:es
@DEMO
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox


  @creacionCasoQueja
  Esquema del escenario: Creacion de caso

    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <clave>
    Y hacemos proceso de seleccion Cliente
    Y Desplegamos el menu de busqueda
    Y Entramos a nuevo caso, Seleccionamos el tipo de caso Queja
    Y creamos un caso de Queja <cuenta> <selectOrigenCaso> <prioridadCaso> <area> <clase> <almacen> <asunto> <descripcion> <planesDeAccion> <estado>




    Ejemplos:

      | Usuario                           | clave        | selectOrigenCaso|  cuenta       |   prioridadCaso | area     | clase      | almacen | asunto |descripcion | planesDeAccion | estado |
      | 1035922188@colcomercio.com.co.uat | Pruebas2023* |    Teléfono     | dsadas        |    Media         | POSVENTA | DETERIORADO| 68      | dasda  | sdasd      |  ewqeqwew     | Nuevo  |








