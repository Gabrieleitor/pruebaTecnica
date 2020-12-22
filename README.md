# pruebaTecnica

### Como correr la Aplicación

la base de datos que se utiliza es en memoria

```
h2
```

para correr maven

```
mvn clean install
```

comando para desplegar 

```
mvn spring-boot:run
```

Comando para crear imagen

```
docker build -t "prueba-tecnica" .
```

Comando para correr la imagen creada:

```
docker run --name prueba-tecnica -p 8080:8080 prueba-tecnica:latest
```

### Documentación con Swagger 

por medio de la siguente ruta podemos haceder a los metos para elaborar las consultas

```
http://localhost:8080/swagger-ui.html
```

### Operadores permitidos

los siguientes nombres son los permitidos para realizar las operaciones

```
 suma
 resta
 division
 multiplicacion
 potenciacion
```

### Pipeline

esta configurado para jenkins y con heroku


![alt text](https://github.com/Gabrieleitor/pruebaTecnica/blob/master/img/Captura.PNG)



