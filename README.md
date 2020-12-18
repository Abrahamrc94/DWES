# Mercadonia

#### Abraham Romero Cano

---

## Introducción

El objetivo del proyecto es trabajar sobre un sistema similar a un almacen que suministra alimentos mediante pedidos llamado Mercadonia

En el apartado de funciones disponibles se indican las distintas posibilidades del proyecto.

## Requisitos

- Tener instalado [Spring Tool Suite](https://spring.io/tools), para la parte backend.
- Utilizar algún programa tipo [Postman](https://www.postman.com/) para realizar las peticiones

- Docker --> [Instalacion](https://www.docker.com/get-started)

- [MySQL Workbench](https://www.mysql.com/products/workbench/) → Para el manejo de la base de datos.


### Instalación 🔧
_Los documenttos de la instalación del entorno de desarrollo los puedes encontrar en el documento adjunto llamado Creación BBDD._

_Ahi encontraremos como instalar la base de datos y su script de creación y como instalar el servidor y levantarlo para poder utilizarlo correctamente._

## Preparación del entorno

Para utilizar la aplicación web, primero debemos descargar los entornos [backend](https://github.com/Abrahamrc94/Mercadonia.git) y [frontend](https://github.com/Abrahamrc94/Proyecto-Integracion-Bootstrap.git).

### Backend

- Importamos el proyecto en Spring.

        File -> Import -> Maven -> Existing Maveng Projects

        Una vez agregado el proyecto, Spring descargará las dependencias necesarias (podemos comprobarlo en la esquina inferior derecha.)

- Iniciamos el servidor desde Spring

        Tras importar el proyecto, iniciamos el servidor desde el apartado "Boot Dashboard" (normalmente ubicado en la parte inferior izquieda.)

        Desplegamos el botón "local" -> click botón derecho sobre "jacaranda_V2" -> click sobre start

## Funciones disponibles

### Customer

#### GET

- Leer clientes

        Petición:
        localhost:8080/api/customer

- Leer clientes, ordenados por nombre

        Petición:
        localhost:8080/api/customer/nombres

- Leer cliente, por Id 

        Petición:
        localhost:8080/api/customer/{id}

#### POST

- Crear cliente

        Petición:
        localhost:8080/api/customer

        Debemos especificar el cuerpo (body) con los datos del usuario que vamos a crear.
        Por ejemplo:

     {
        "name": "Abraham",
        "surname": "Romero",
        "birthdate": null,
        "addres": null,
        "city": "Sevilla",
        "dni": "7816162",
        "country": null,
        "mobilenumber": null,
        "gender": null,
        "pedidos": []
    }

### PUT

    Petición:
        localhost:8080/api/customer/{id}

        Debemos especificar el cuerpo (body) con los datos del usuario que vamos a modificar y el id del usuario en la url.
        Por ejemplo:

     {
        "name": "Abraham",
        "surname": "Romero",
        "birthdate": null,
        "addres": null,
        "city": "Sevilla",
        "dni": "null",
        "country": null,
        "mobilenumber": null,
        "gender": null,
        "pedidos": []
    }


#### DELETE

-Modificar un cliente

- Borrar cliente

        Petición:
        localhost:8080/api/customer/{id}


### Pedido

#### GET

- Leer todos los pedidos

        Petición:
        localhost:8080/api/pedido

- Leer pedido concreto por Id

        Petición:
        localhost:8080/api/pedido/{id}


- Leer pedidos ordenados segun el estado (pendiente, entregado, en reparto)

        Petición:
        localhost:8080/api/pedido/estado

#### POST

- Crear un pedido

        Petición:
        localhost:8080/api/pedido

        Debemos especificar el cuerpo (body) con los datos del pedido que vamos a crear.
        Por ejemplo:

        {
        "total": 100,
        "estado": "Pendiente",
        "productos": []
        }

### PUT

- Modificar un pedido

        Petición:
        localhost:8080/api/customer/{id}

        Debemos especificar el cuerpo (body) con los datos del pedido que vamos a modificar y el id del pedido en la url.
        Por ejemplo:

        {
        "total": 80,
        "estado": "Pendiente",
        "productos": []
         }

#### DELETE

- Borrar un pedido

        Petición:
        localhost:8080/api/pedido/{id}


### Producto

#### GET

- Leer todos los productos

        Petición:
        localhost:8080/api/producto

- Leer producto concreto por Id

        Petición:
        localhost:8080/api/producto/{id}


- Leer todos los productos ordenados por nombre

        Petición:
        localhost:8080/api/producto/nombres

#### POST

- Crear un producto
        Petición:
        localhost:8080/api/producto

        Debemos especificar el cuerpo (body) con los datos del producto que vamos a crear.
        Por ejemplo:

        {
        "nombre": "Patatas",
        "precio": 10,
        "stock": 100
        }

### PUT

-Modificar un producto

        Petición:
        localhost:8080/api/customer/{id}

        Debemos especificar el cuerpo (body) con los datos del producto que vamos a modificar
        Y el id del producto en la url
        Por ejemplo:

        {
        "nombre": "Ajos",
        "precio": 10,
        "stock": 100
        }

#### DELETE

- Borrar un producto

        Petición:
        localhost:8080/api/producto/{id}
