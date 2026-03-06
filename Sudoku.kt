/*
* Laboratorio 2: Solver Sudoku
* Implementaciómn usando ténica de Backtraking
* Estudiante: Enyerber Silva
* Carnet: 18-11100
*/

fun main(args: Array<Strings>) {
    if (args.isEmpty() || args[0].length != 81) return

    val cadenaEntrada = args[0]
    val tablero = Array(9) {IntArray(9)}

    for (i in 0 until 81) {
        tablero[i/9][i%9] = cadenaEntrada[i]
    }

    if(resolver(tablero, 0, 0)) {
        imprimirTablero(tablero)
    }

    else {
        println("NOSOLUTION")
    }
}

fun resolver(tablero: Array<IntArray>, fila: Int, col: Int): Boolean {

}

fun esSeguro(tablero: Array<IntArray>, fila: Int, col: Int, num: Int): Boolean {

}

fun ImprimirTablero(tablero: Array<IntArray>) {
    
}