Nombre: Elias William Abraham Valle Arias.
Rol: 202173537-2

Para ejecutar el programa hay que abrir una terminal directorio que contenga el Makefile y la carpeta llamada Tarea, luego en la misma hay que escribir make, esto compilara los archivos en la carpeta Tarea y empezara el programa.


En el juego primero tienes que escribir el nombre de tu personaje, luego escribir el Alto que quieres que tenga el mundo, y despues, el ancho del mismo.

Al tener generado el mundo por consola se mostrara el mapa del mundo, el nivel de este y la cantidad de enemigos que lo habitan.

Luego el usuario podra ingresar las siguientes opciones:

-stats, esto mostrada por pantalla las estadisticas y el arma actual del personaje.

-inv, esto mostrara por pantalla el inventario del personaje.

-equip, esto empieza la acción de equipar un Item, para esto luego hay que escribir el nombre del Item en la siguiente linea.

-Arriba, esto desplazara hacia arriba al personaje(si es posible).

-Abajo, esto desplazara hacia abajo al personaje(si es posible).

-Derecha, esto desplazara hacia la derecha al personaje(si es posible).

-Izquierda, esto desplazara hacia la izquierda al personaje(si es posible).

-salir, esto terminara el programa.



Funcionamiento del juego:

En el juego, puedes controlar a un personaje que se desplaza por un mapa 2D. En este, se generan ítems y enemigos en posiciones aleatorias. Para recolectar los objetos, debes caminar hasta la casilla donde se encuentran, y se guardarán automáticamente en el inventario del jugador. Por otro lado, en cuanto a los enemigos, si intentas caminar hasta su casilla, te atacarán cada vez que intentes entrar a la casilla en la que se encuentran. Si estos mueren, entonces podrás caminar por su casilla. Si logras acabar con todos los enemigos, el mapa se reiniciará, regresarás a la posición inicial con un extra de HP y en el mundo se generarán nuevos objetos con estadísticas mejoradas a medida que aumenta el nivel. Además, aparecerán nuevos enemigos que tendrán más daño y HP dependiendo de qué tan alto sea el nivel.


Datos adicionales del juego:


-Los enemigos empiezan con 5 de HP y 5 de daño, este se multiplica con el nivel del mundo.

-Cada enemigo asesinado da 15 de XP.

-Los enemigos SIEMPRE te haran daño mientras intentes matarlos, por lo que aunque logres matarlo si tu vida llega a 0, se terminara el juego.

-Si tu HP llega a 0 o menos el juego se acabara dejando por consola un mensajito.

Comentarios:

-Si es que por probabilidad no se generan enemigos en el mapa una vez empieza el juego o se suba de nivel, el juego lo detectara como que el mundo debe subir de nuevo de nivel (Lo deje como un boost).






















