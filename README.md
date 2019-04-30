# TACS-2019-GRUPO3
Repositorio del TP cuatrimestral de TACS UTN 1C-2019

### Proyecto Spring

### Install

Desde el root del proyecto

```bash
    mvn install
```

#### Build

Desde el root del proyecto
```
    cd grupo3/grupo3-spring-controller
    mvn compile
```

#### Run

Desde el root del proyecto
```
    cd grupo3/grupo3-spring-controller
    mvn spring-boot:run
```

#### URL base
```
    http://localhost:8080
```

## Endpoints

| Method | URI | Descripción | Observación | 
| ------ | ------ | ------ | ------ |
| GET | /users | Todos los usuarios | 
| POST | /users | Crear un usuario | body=JSON
| GET | /places/near | Lugares cercanos a una coordenada | parameter=coordinates
| POST | /users/{user-id}/list-of-places{list-id}/{place-id} |Registrar un lugar en una lista de lugares | 
| POST | /users/{user-id}/list-of-places/{list-id} | crear una listas de lugares | 
| GET | /users/{user-id}/list-of-places | Listas de lugares favoritos | 
| GET | /users/{user-id}/list-of-places/{list-id} | buscar una lista de lugares | 
| DELETE | /users/{user-id}/list-of-places/{list-id} | Eliminar una lista de lugares | 
| PUT | /users/{user-id}/list-of-places/{list-id} | Modificar una lista de lugares | parameter=new_name
| PUT | /users/{user-id}/places-visited/{place-id} | marcar un lugar como visitado | 
| GET | /users/{user-id} | Ver Datos de un usuario | 
| GET | /places/{place-id}/interested-users | Cantidad de usuarios interesados en un lugar | 
| GET | /places/places-in-common | Obtener lugares en comun entre usuarios | parameter1=list_1 parameter2=,list_2
| GET | /places/registered-places | Consultar lugares registrados en el sistema | Query: hoy, últimos 3 días. última semana, último mes, todos
| GET | /places | Todos los lugares | 
| PUT | /users/{user-id}/list-of-places/{list-id} | Modificar una lista de lugares | parameter=new_name

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
