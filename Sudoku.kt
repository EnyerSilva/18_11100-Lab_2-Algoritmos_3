/*
* Laboratorio 2: Solver Sudoku
* Implementación usando ténica de Backtraking
* Estudiante: Enyerber Silva
* Carnet: 18-11100
*/

fun main(args: Array<String>) {
    if (args.isEmpty() || args[0].length != 81){
        println ("Ingrese una cadena de caracteres de 81 dígitos para iniciar el solver de Sudoku")
        return
    }

    val cadenaEntrada = args[0]
    val tablero = Array(9) {IntArray(9)}

    for (i in 0 until 81) {
        tablero[i/9][i%9] = cadenaEntrada[i] - '0'
    }

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

    if(resolver(tablero, 0, 0)) {
        imprimirTablero(tablero)
    }

    else {
        println("NOSOLUTION")
    }
}

fun resolver(tablero: Array<IntArray>, fila: Int, col: Int): Boolean {
    if (fila == 9) return true

    val siguienteFila = if (col == 8) fila + 1 else fila
    val siguienteCol = if (col == 8) 0 else col + 1

    if (tablero[fila][col] != 0) {
        return resolver(tablero, siguienteFila, siguienteCol)
    }

    for (num in 1..9) {

        if (esSeguro(tablero, fila, col, num)) {
            tablero[fila][col] = num

            if (resolver(tablero, siguienteFila, siguienteCol)) return true

            tablero[fila][col] = 0
        }
    }
    return false
}

fun esSeguro(tablero: Array<IntArray>, fila: Int, col: Int, num: Int): Boolean {
    for (i in 0 until 9) {
        if (tablero[fila][i] == num) return false

        if (tablero[i][col] == num) return false

        val filaInicio = (fila/3)*3
        val colInicio = (col/3)*3
        if (tablero[filaInicio + (i/3)][colInicio + (i%3)] == num) return false
    }
    return true
}

fun imprimirTablero(tablero: Array<IntArray>) {
    val resultado = StringBuilder()
    for (f in 0 until 9) {
        for (c in 0 until 9){
            resultado.append(tablero[f][c])
        }
    }
    println(resultado.toString())
}