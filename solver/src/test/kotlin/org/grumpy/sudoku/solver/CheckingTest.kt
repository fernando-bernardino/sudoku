package org.grumpy.sudoku.solver

import kotlin.test.*
import org.junit.*

class CheckerObjectTest {

    private val correct = intArrayOf(
            1, 2, 3,   4, 5, 6,    7, 8, 9,
            4, 5, 6,   7, 8, 9,    1, 2, 3,
            7, 8, 9,   1, 2, 3,    4, 5, 6,

            2, 3, 4,   5, 6, 7,    8, 9, 1,
            5, 6, 7,   8, 9, 1,    2, 3, 4,
            8, 9, 1,   2, 3, 4,    5, 6, 7,

            3, 4, 5,   6, 7, 8,    9, 1, 2,
            6, 7, 8,   9, 1, 2,    3, 4, 5,
            9, 1, 2,   3, 4, 5,    6, 7, 8)

    private val checker = CheckerObject(SudokuWrapper())

    @Test
    fun correctSolution() {

        assertTrue(checker.check(correct))
    }

    @Test
    fun sameValueInColumn() {
        val incorrect = correct.clone()
        incorrect[0] = 7
        incorrect[2 * 9] = 1

        assertFalse(checker.check(incorrect))
    }

    @Test
    fun sameValueInLine() {
        val incorrect = correct.clone()
        incorrect[5 * 9] = 1
        incorrect[5 * 9 + 2] = 8

        assertFalse(checker.check(incorrect))
    }

    @Test
    fun sameValueInSquare() {
        val incorrect = intArrayOf(
                1, 2, 3,   4, 5, 6,    7, 8, 9,
                4, 1, 6,   7, 8, 9,    1, 2, 3,
                7, 8, 9,   1, 2, 3,    4, 5, 6,

                2, 3, 4,   5, 6, 7,    8, 9, 1,
                5, 6, 7,   8, 9, 1,    2, 3, 4,
                8, 9, 1,   2, 3, 4,    5, 6, 7,

                3, 4, 5,   6, 7, 8,    9, 1, 2,
                6, 7, 8,   9, 1, 2,    3, 4, 5,
                9, 1, 2,   3, 4, 5,    6, 7, 8)

        assertFalse(checker.check(incorrect))
    }
}