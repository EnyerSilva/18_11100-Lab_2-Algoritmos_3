/*
* Laboratorio 2: Solver Sudoku
* Implementación usando ténica de Backtraking
* Estudiante: Enyerber Silva
* Carnet: 18-11100
*/

fun main(args: Array<String>) {
    /*
     * Si el usario no ingresa exactamente 81 dígitos o si no ingresa nada, entonces se le imprime en pantalla
     * el requerimiento para iniciar el solver de Sudoku
     */
    if (args.isEmpty() || args[0].length != 81){
        println ("Ingrese una cadena de caracteres de 81 dígitos para iniciar el solver de Sudoku")
        return
    }

    val cadenaEntrada = args[0] // Cadena de entrada del usuario
    val tablero = Array(9) {IntArray(9)} // Matriz 9x9 del tablero

    for (i in 0 until 81) {
        tablero[i/9][i%9] = cadenaEntrada[i] - '0' // Se resta 0 para que lo lea como número y no como carácter
                                                   // Convierte cada char en int (Por su código ASCII)
    }

    /*
     *En este punto hacemos una poda preventiva en el tablero inicial
     *Así verificamos si el tablero inicial es inválido y no perdemos tiempo
     */
    for (f in 0 until 9) {
        for (c in 0 until 9) {
            val num = tablero[f][c]
            if (num != 0) {
                tablero[f][c] = 0
                if (!esSeguro(tablero, f, c, num)) {
                    println ("NOSOLUTION")
                    return
                }
                tablero[f][c] = num
            }
        }
    }

    // Llamamos a la función resolver e iniciamos la solución desde la casilla (0,0)
    if(resolver(tablero, 0, 0)) {
        imprimirTablero(tablero)
    }
    else {
        println("NOSOLUTION")
    }
}

/* 
 * Función que se encarga de aplicar el Backtraking. 
 */
fun resolver(tablero: Array<IntArray>, fila: Int, col: Int): Boolean {
    // Si la fila llega a 9 entonces se ha recorrido todo el tablero
    if (fila == 9) return true

    // Se realiza el recorrido por filas
    val siguienteFila = if (col == 8) fila + 1 else fila
    val siguienteCol = if (col == 8) 0 else col + 1

    // Si la cel ya tiene número entonces se salta a la siguiente celda
    if (tablero[fila][col] != 0) {
        return resolver(tablero, siguienteFila, siguienteCol)
    }

    // Se intenta colocar número del 1 al 9
    for (num in 1..9) {
        // Procedemo si el número cumple con las condiciones de las reglas del Sudoku
        if (esSeguro(tablero, fila, col, num)) {
            tablero[fila][col] = num // Intento

            // Si el número que se decidió agregar funciona entonces continuamos
            if (resolver(tablero, siguienteFila, siguienteCol)) return true

            // Si el número no es una buena decisión entonces se reinicia
            tablero[fila][col] = 0
        }
    }
    // Si ninguno de los números puede ser colocado entonces no hay solución en esta rama
    return false
}

// Recorre filas, columnas y cuadrículas para verificar si el número elegido es posible de colocar
fun esSeguro(tablero: Array<IntArray>, fila: Int, col: Int, num: Int): Boolean {
    for (i in 0 until 9) {

        // Verifica que no haya un número igual en la fila
        if (tablero[fila][i] == num) return false

        // Verifica que no haya un número igual en la columna
        if (tablero[i][col] == num) return false

        // Verificación en la cuadrícula 3x3
        val filaInicio = (fila/3)*3
        val colInicio = (col/3)*3
        if (tablero[filaInicio + (i/3)][colInicio + (i%3)] == num) return false
    }
    return true
}

/*
 * Convierte la matriz resuelta en una cadena de 81 carácteres
 */
fun imprimirTablero(tablero: Array<IntArray>) {
    val resultado = StringBuilder() // Se usa la función StringBuilder() para la construcción del string de salida
    for (f in 0 until 9) {
        for (c in 0 until 9){
            resultado.append(tablero[f][c])
        }
    }
    println(resultado.toString())
}