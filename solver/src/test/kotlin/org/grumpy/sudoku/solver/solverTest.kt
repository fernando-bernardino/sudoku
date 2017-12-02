package org.grumpy.sudoku.solver

import kotlin.test.*
import org.junit.*

class SolverTest {

    private val solver = BruteForceSolver()

    private val checker = CheckerObject(SudokuWrapper())

    @Test
    fun correctSolution1(){
        val unsolved = intArrayOf(
                7, 5, 0,    0, 6, 0,    0, 0, 4,
                0, 0, 0,    0, 0, 0,    0, 0, 0,
                0, 2, 1,    0, 0, 9,    0, 6, 0,

                6, 0, 0,    0, 0, 2,    0, 7, 5,
                0, 0, 0,    7, 9, 8,    0, 0, 0,
                2, 8, 0,    5, 0, 0,    0, 0, 9,

                0, 4, 0,    3, 0, 0,    7, 9, 0,
                0, 0, 0,    0, 0, 0,    0, 0, 0,
                5, 0, 0,    0, 2, 0,    0, 4, 6
        )

        val solution = solver.solve(unsolved)

        println(solution.toList())

        assertTrue(checker.check(solution))
    }

    @Test
    fun correctSolution2(){
        val unsolved = intArrayOf(
                1, 0, 0,    0, 0, 0,    0, 0, 5,
                4, 9, 3,    0, 5, 1,    0, 0, 0,
                0, 0, 7,    3, 0, 0,    0, 0, 0,

                0, 0, 1,    0, 0, 3,    9, 0, 8,
                0, 3, 0,    0, 0, 0,    0, 1, 0,
                6, 0, 8,    2, 0, 0,    7, 0, 0,

                0, 0, 0,    0, 0, 7,    1, 0, 0,
                0, 0, 0,    5, 4, 0,    2, 3, 9,
                3, 0, 0,    0, 0, 0,    0, 0, 7
        )

        val solution = solver.solve(unsolved)

        println(solution.toList())

        assertTrue(checker.check(solution))
    }

    @Test
    fun correctSolution3(){
        val unsolved = intArrayOf(
                0, 0, 5,    0, 0, 6,    0, 0, 0,
                0, 4, 3,    0, 0, 0,    0, 0, 1,
                1, 2, 0,    0, 3, 0,    0, 0, 0,

                0, 0, 2,    0, 0, 0,    0, 8, 3,
                4, 3, 0,    0, 6, 0,    0, 5, 9,
                5, 9, 0,    0, 0, 0,    4, 0, 0,

                0, 0, 0,    0, 8, 0,    0, 4, 2,
                2, 0, 0,    0, 0, 0,    8, 7, 0,
                0, 0, 0,    7, 0, 0,    9, 0, 0
        )

        val solution = solver.solve(unsolved)

        println(solution.toList())

        assertTrue(checker.check(solution))
    }

    @Test
    fun correctSolution4(){
        val unsolved = intArrayOf(
                1, 0, 8,    3, 0, 0,    7, 0, 0,
                0, 3, 0,    0, 0, 0,    0, 0, 9,
                0, 6, 0,    0, 0, 9,    8, 0, 0,

                0, 0, 0,    7, 6, 2,    4, 0, 0,
                0, 0, 0,    0, 0, 0,    0, 0, 0,
                0, 0, 4,    9, 3, 8,    0, 0, 0,

                0, 0, 2,    1, 0, 0,    0, 5, 0,
                6, 0, 0,    0, 0, 0,    0, 1, 0,
                0, 0, 3,    0, 0, 7,    9, 0, 2
        )

        val solution = solver.solve(unsolved)

        println(solution.toList())

        assertTrue(checker.check(solution))
    }
}