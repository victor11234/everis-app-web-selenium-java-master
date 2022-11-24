#language:es
@DEMO
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox


  @creacionCasoQueja
  Esquema del escenario:creacionCasoQueja

    Dado que ingresamos a la pagina de Salesforce
    Y ingresamos los datos de inicio de sesion <usuario> <clave>
    Y iniciamos sesion
    Y hacemos proceso de seleccion Cliente
    Y Desplegamos el menu de busqueda
    Y Entramos a nuevo caso, Seleccionamos el tipo de caso Queja
    Y creamos un caso de Queja <cuenta> <selectOrigenCaso> <prioridadCaso> <area> <clase> <almacen> <asunto> <descripcion> <planesDeAccion> <estado>
    Entonces verificamos el caso creado




    Ejemplos:

      | usuario                                               | clave        | selectOrigenCaso|  cuenta               |   prioridadCaso | area     | clase      | almacen | asunto |descripcion | planesDeAccion | estado |
      | victor.manuel.lozano.cardona@colcomercio.com.co.alkqa | Pruebas2023* |    Teléfono     |  victor lozano        |    Media         | POSVENTA | DETERIORADO| 68      | dasda  | sdasd      |  ewqeqwew     | Nuevo  |








