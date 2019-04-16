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
| GET | /users/{user-id} | Obtener un usuario | 
| POST | /users | Crear un usuario | JSON | 
| GET | /users/{user-id}/favourite-places | Listas de lugares favoritos | 
| GET | /users/{user-id}/favourite-places/{list-id} | Obtener una lista de lugares | 
| DELETE | /users/{user-id}/favourite-places/{list-id} | Eliminar una lista de lugares | 
| PUT | /users/{user-id}/favourite-places/{list-id} | Modificar una lista de lugares | Nombre, marcar como visitado | 
| POST | /users/{user-id}/favourite-places/{list-id}/{place-id} | Registrar un lugar en una lista de lugares | 
| GET | /users/places-in-common | Obtener lugares en comun entre usuarios | 
| GET | /places | Todos los lugares | 
| GET | /places/near | Lugares cercanos a una coordenada | 
| GET | /places/{place-id}/interested-users | Cantidad de usuarios interesados en un lugar | 
| GET | /places/registered-places | Consultar lugares registrados en el sistema | Query: hoy, últimos 3 días. última semana, último mes, todos | 

### Telegram

#### Bot
```
    TACS20191CGrupo3Bot
```

