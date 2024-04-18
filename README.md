# demo-vehicle
Prueba Tecnica

## Tecnologias
* **Java:** La version que se va a utilizar es la 1.8
* **Spring-Boot:** La version que se va a utilizar es la 2.7.18
* **MySql:** La version para la base de datos sera 8.1.5

## Instalacion
Para descargar el proyecto se utilizara Git
```
git clone https://github.com/rlealm8/demo-vehicle.git
```

**Importante:** El desarrollo de esta prueba se encuentra en la rama feature-develop

## API Rest

En la carpeta resources se encuentra la collection del postman de los servicios rest 

###Metodos
* **Save Vehicle:** Para registrar un vehiculo
* **Update Vehicle:** Para actualizar un vehiculo por su ID
* **List Vehicles:** Filtro de busqueda, el cual recibe por parametros marca, modelo y matricula, retorna una lista paginada
* **Delete Vehicle:** Para eliminar un vehiculo por su ID

## Interfaz

Para acceder a la interfaz grafica es mediante esta URL:

http://localhost:8080/listar
