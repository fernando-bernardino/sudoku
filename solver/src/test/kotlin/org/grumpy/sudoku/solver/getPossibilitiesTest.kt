package org.grumpy.sudoku.solver

import kotlin.test.*
import org.junit.*
import java.util.stream.IntStream

class GetPossibilitiesTest {
    private val puzzle = IntArray(9 * 9)
    private val finder = SudokuWrapper()

    @Before
    fun placeNumbersInSpecificPlaces() {
        /*
                 |         |
                 |         |
                 |         |       1
        ----------------------------
                 | 3       |
                 |         |
                 |       4 |
        ----------------------------
                 |         |
                 |         |
               2 |         |
         */
        place(1, 2, 8)
        place(2, 8, 2)
        place(3, 3, 3)
        place(4, 5, 5)
    }

    private fun place(number: Int, line: Int, column: Int) {
        puzzle[line * 9 + column] = number
    }

    @Test
    fun allNumbersInOption() {

        assertSame(
                intArrayOf(*IntStream.range(1, 9).toArray()),
                finder.possibleValues(0, 0, puzzle))
    }

    @Test
    fun numberInSameLineNotInOptions(){

        assertSame(
                intArrayOf(*IntStream.range(1, 9).filter{it != 1}.toArray()),
                finder.possibleValues(2, 0, puzzle))
    }

    @Test
    fun numberInSameColumnNotInOptions(){

        assertSame(
                intArrayOf(*IntStream.range(1, 9).filter{it != 2}.toArray()),
                finder.possibleValues(0, 2, puzzle))
    }

    @Test
    fun numberInSameSquareNotInOptions(){

        assertSame(
                intArrayOf(*IntStream.range(1, 9).filter{it != 3 && it != 4}.toArray()),
                finder.possibleValues(4, 4, puzzle))
    }

    @Test
    fun positionFilledReturnsElement() {
        assertSame(
                intArrayOf(1),
                finder.possibleValues(2, 8, puzzle))
    }

    val real = intArrayOf(
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

    @Test
    fun third(){
        assertSame(
                intArrayOf(1),
                finder.possibleValues(0, 6, real))
    }

    private fun assertSame(expected: IntArray, returned: IntArray) {

        assertTrue(expected.size == returned.size
                && expected.filter { !returned.contains(it) }
                        .toIntArray()
                        .isEmpty())
    }
}