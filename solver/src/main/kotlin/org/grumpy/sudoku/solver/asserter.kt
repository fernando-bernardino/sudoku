package org.grumpy.sudoku.solver

import java.util.stream.IntStream

class SudokuWrapper : Asserter {

    override fun numberInLine(value: Int, line: Int, puzzle: IntArray) : Boolean = IntProgression
                .fromClosedRange(0, 8, 1)
                .find { puzzle[line * 9 + it] == value } != null


    override fun numberInColumn(value: Int, column: Int, puzzle: IntArray) : Boolean =  IntProgression
                .fromClosedRange(0, 8, 1)
                .find { puzzle[it * 9 + column] == value} != null

    override fun numberInSquare(value: Int, line: Int, column: Int, puzzle: IntArray) : Boolean = IntProgression
                .fromClosedRange(0, 2, 1)
                .map { line * 9 * 3 + column * 3 + it * 9 }
                .find { puzzle[it] == value || puzzle[it + 1] == value || puzzle[it + 2] == value } != null

    override fun possibleValues(line: Int, column: Int, puzzle: IntArray) : IntArray {

        val valueAtPosition = puzzle[line * 9 + column]

        return when((1..9).contains(valueAtPosition)) {

                true -> intArrayOf(valueAtPosition)

                false -> (1 .. 9).filter {
                        !numberInLine(it, line, puzzle)
                        && !numberInColumn(it, column, puzzle)
                        && !numberInSquare(it, line.div(3), column.div(3), puzzle)
                }.toIntArray()
        }
    }
}

class CheckerObject(private val asserter: Asserter) : Checker {

    override fun check(puzzle: IntArray): Boolean {
        return (0..2).find { squareLine ->
                    (0..2).filter { squareColumn ->
                        (1..9).filter { !asserter.numberInSquare(it, squareLine, squareColumn, puzzle) }.count() > 0
                    }.count() > 0
                } == null
                &&  (0..8).find { column -> (1..9).filter { !asserter.numberInColumn(it, column, puzzle) }.count() > 0 } == null
                && (0..8).find { line -> (1..9).filter { !asserter.numberInLine(it, line, puzzle) }.count() > 0} == null
    }
}