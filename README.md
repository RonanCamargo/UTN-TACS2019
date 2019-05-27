# TACS-2019-GRUPO3
Repositorio del TP cuatrimestral de TACS UTN 1C-2019

### Proyecto backend

### Install

Desde el root del proyecto

```bash
    cd grupo3-backend
    mvn install
```

#### Build

Desde el root del proyecto
```
    cd grupo3-backend/grupo3-spring-controller
    mvn compile
```

#### Run

Desde el root del proyecto
```
    cd grupo3-backend/grupo3-spring-controller
    mvn spring-boot:run
```

#### URL base
```
    http://localhost:8080
```

## Endpoints
## [Importante] Ver collecion de Postman para ver los parametros y el body que se envian en los metodos HTTP

| Method | URI | Descripción | Observación | 
| ------ | ------ | ------ | ------ |
| GET | /users | Todos los usuarios | 
| POST | /sign-up | Crear un usuario | body=JSON
| POST | /login | login a un usuario | body=JSON
| GET | /places/near | Lugares cercanos a una coordenada | parameter=coordinates
| POST | /users/{user-id}/list-of-places{list-id}/{place-id} |Registrar un lugar en una lista de lugares | place-id es el id de foursquare
| POST | /users/{user-id}/list-of-places/{list-id} | crear una listas de lugares | 
| GET | /users/{user-id}/list-of-places | Listas de lugares favoritos | 
| GET | /users/{user-id}/list-of-places/{list-id} | buscar una lista de lugares | 
| DELETE | /users/{user-id}/list-of-places/{list-id} | Eliminar una lista de lugares | 
| PUT | /users/{user-id}/list-of-places/{list-id} | Modificar una lista de lugares | parameter=new-name
| PUT | /users/{user-id}/places-visited/{place-id} | marcar un lugar como visitado | 
| GET | /administrator/users/{user-id} | Ver Datos de un usuario | 
| GET | /administrator/places/{place-id}/interested-users | Cantidad de usuarios interesados en un lugar | 
| GET | /administrator/places/places-in-common | Obtener lugares en comun entre usuarios | parameter1=list-id-1 parameter2=,list-id-2
| GET | /administrator/places/registered-places | Consultar lugares registrados en el sistema | days: hoy, últimos 3 días. última semana, último mes, todos (days=0)
| GET | /places | Todos los lugares | 

##
### Proyecto Telegram

#### Install

```
    cd grupo3-telegram-bot
    mvn install
```

#### Build

```    
    mvn compile
```

#### Run

```
    mvn exec:java
```


#### Bot Username
```
    TACS20191CGrupo3Bot
```
##
### Proyecto React
```
    cd grupo3-frontend-react/grupo3-react-application
    npm i
    npm start
```

#### URLs para probar el frontend
```
    http://localhost:8008/stats
    http://localhost:8008/users/list-of-places
    http://localhost:8008/places
    http://localhost:8008/users
    http://localhost:8008/signup
    http://localhost:8008/login
    
```
