package org.grumpy.sudoku.solver

import kotlin.test.*
import org.junit.*

class FindNumberTest {
    private val toFind = 1
    private val puzzle = IntArray(9 * 9)
    private val finder = SudokuWrapper()

    @Before
    fun placeNumberInSpecificPlaces(){
        /*
         1       |         |
                 |         |
                 |         |
        ----------------------------
                 |         |
                 |    1    |
                 |         |
        ----------------------------
                 |         |
                 |         |
                 |         |       1
         */
        place(toFind, 0, 0)
        place(toFind, 4, 4)
        place(toFind, 8, 8)
    }

    private fun place(number: Int, line: Int, column: Int){
        puzzle[line * 9 + column] = number
    }

    @Test
    fun foundOnFirstLine() {
        assertTrue(finder.numberInLine(toFind, 0, puzzle))
    }

    @Test
    fun notFoundOnSecondLine() {
        assertFalse(finder.numberInLine(toFind, 1, puzzle))
    }

    @Test
    fun foundOnLastLine() {
        assertTrue(finder.numberInLine(toFind, 8, puzzle))
    }

    @Test
    fun foundInFirstColumn(){
        assertTrue(finder.numberInColumn(toFind, 0, puzzle))
    }

    @Test
    fun notFoundInSecondColumn(){
        assertFalse(finder.numberInColumn(toFind, 1, puzzle))
    }

    @Test
    fun foundOnLastColumn(){
        assertTrue(finder.numberInColumn(toFind, 8, puzzle))
    }

    @Test
    fun foundInSquare0_0(){
        assertTrue(finder.numberInSquare(toFind, 0, 0, puzzle))
    }

    @Test
    fun notFoundSquare1_0(){
        assertFalse(finder.numberInSquare(toFind, 1, 0, puzzle))
    }

    @Test
    fun foundInSquare1_1(){
        assertTrue(finder.numberInSquare(toFind, 1, 1, puzzle))
    }

    @Test
    fun numberFoundIfSquare2_2(){
        assertTrue(finder.numberInSquare(toFind, 2, 2, puzzle))
    }
}