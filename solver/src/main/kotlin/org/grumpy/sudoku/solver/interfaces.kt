package org.grumpy.sudoku.solver

interface Solver {

    fun solve(unsolved : IntArray) : IntArray
}

interface Checker {
    fun check(puzzle: IntArray): Boolean
}

interface Asserter {

    /**
     * Determines if number is contained in line.
     *
     * @param value value to find
     * @param line line number, ranging from 0 to 8
     *
     */
    fun numberInLine(value: Int, line: Int, puzzle: IntArray) : Boolean

    fun numberInColumn(value: Int, column: Int, puzzle: IntArray) : Boolean

    /**
     * Determines if the square [3 X 3] contains the value.
     *
     * @param value value to find
     * @param line Y coordinate of square, ranging from 0 to 2
     * @param column X coordinate of square, ranging from 0 to 2
     *
     */
    fun numberInSquare(value: Int, line: Int, column: Int, puzzle: IntArray) : Boolean

    /**
     * Determines which number are possible in the position [column, line]
     *
     * @param line Y coordinate, ranging from 0 to 8
     * @param column X coordinate, ranging from 0 to 8
     *
     * @return list of options, empty if already filled in
     */
    fun possibleValues(line: Int, column: Int, puzzle: IntArray) : IntArray
}



