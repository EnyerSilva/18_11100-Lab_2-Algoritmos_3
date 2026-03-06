# 18_11100-Lab_2-Algoritmos_3
Sudoku con Backtraking

El solver de Sudoku realizado en este laboratorio cuenta con dos niveles de poda, uno que verifica si el tablero inicial cumple con las condiciones necesarias para intentar empezar a resolver y el otro nivel de poda ocurre cuando se elige poner un número en una celda x verificando si este número puede ser colocado aquí o no con el uso de la función "esSeguro(). 

La técnica de retroceso aplicada consiste en las funciones "esSeguro()" y "resolver()", donde si ún número elegido no es posible colocarlo de ninguna manera en una celda entonces el algoritmo deshace todos los pasos que hizo e intenta de nuevo desviandose por alguna otra rama probando cada posibilidad hasta que llega a la rama de la solución que es la correcta o devolver que no hay solución para el tablero actual.

Enyerber Silva
18-11100
