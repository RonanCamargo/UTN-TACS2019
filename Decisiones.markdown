## Elección Framework

Durante las semanas previas a la entrega probamos Spring y Spark:

### Spark
No observamos particular beneficio de utilizar Spark, fuera a la simplicidad de levantar un HTTP Server con endpoints. Como negativo, Spark no resuelve ORM para bases de datos no relacionales, por lo que habría que integrarlo con algún framework adicional. Ademas, cuando se quiere dar funcionalidad a la API, es necesario más trabajo manual que Spring ya tiene contemplado. Finalmente, dentro del modelo de arquitectura que se utilizará  (MVC), Spark solo actúa como Controller, teniendo entonces que resolver aun la Vista y Modelo.

### Spring
Spring, al igual que Spark, nos da la solución de un HTTP Server mediante Spring Boot. Si bien Spring requiere de annotations adicionales que ensucian el código y su configuración es un poco mas complicada, está ampliamente documentada, resuelven ORM incluso con bases de datos no relacionales y es compatible con MVC. Además, Spring posee soporte para Inyección de Dependencias(DI) e Inversion de Control(IoC), lo cual no se puede hacer utilizando, por ejemplo, solo Spark. 


Como herramienta de gestión de tareas decidimos utilizar github.

#### Fuentes
https://stackoverflow.com/questions/9403155/what-is-dependency-injection-and-inversion-of-control-in-spring-framework
https://spring.io/guides/gs/spring-boot/
https://www.g2.com/compare/apache-spark-vs-spring-framework
