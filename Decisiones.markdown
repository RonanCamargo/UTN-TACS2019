## Elección Framework

Durante las semanas previas a la entrega probamos Spring y Spark.
No observamos particular beneficio de utilizar Spark, fuera a la simplicidad de levantar un HTTP Server con endpoints. Como negativo, Spark no resuelve ORM para bases de datos no relacionales, por lo que habría que integrarlo con algún framework adicional. Ademas, cuando se quiere dar funcionalidad a la API, es necesario más trabajo manual que Spring ya tiene contemplado. Finalmente, dentro del modelo de arquitectura que se utilizará  (MVC), Spring solo actúa como Controller, teniendo entonces que resolver aun la Vista y Modelo.
Sobre Spring, si bien hay que utilizar annotations adicionales que ensucian el código y su configuración es un poco mas complicada, está ampliamente documentada, resuelven ORM incluso con bases de datos no relacionales y es compatible con MVC.


Como herramienta de gestión de tareas decidimos utilizar github.
