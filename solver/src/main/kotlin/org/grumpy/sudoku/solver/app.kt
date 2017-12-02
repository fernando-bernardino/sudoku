package org.grumpy.sudoku.solver

data class Person(val name: String,
                  val age: Int? = null)


fun main(args: Array<String>) {
    val solver : Solver = BruteForceSolver()

    val puzzle = intArrayOf(1, 2, 3)
    val result = solver.solve(puzzle)

    when {
        result === puzzle -> println("same")
        result == puzzle -> println("equals")
        else -> println("different")
    }
}

