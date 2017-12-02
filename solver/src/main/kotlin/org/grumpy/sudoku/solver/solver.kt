package org.grumpy.sudoku.solver


class BruteForceSolver : Solver {

    private val wrapper = SudokuWrapper()

    override fun solve(unsolved : IntArray) : IntArray {


        val result = (0..80).map { calculate(0, unsolved) }.find { !it.isEmpty() }

        if(result != null) {
            return result
        } else {
            return IntArray(0)
        }
    }

    private fun createPuzzle(position: Int, puzzle: IntArray, value: Int): IntArray {
        var clone = puzzle.clone()
        clone[position] = value
        return clone
    }

    private fun calculate(position: Int, puzzle: IntArray): IntArray {

        val possibleValues = wrapper.possibleValues(position.div(9), position % 9, puzzle)

        if (possibleValues.isEmpty()) {
            return possibleValues
        } else if (position == 80) {
            if (possibleValues.size == 1) {
                return  createPuzzle(position, puzzle, possibleValues[0])
            } else {
                return IntArray(0)
            }
        } else {
            val solution = possibleValues.map {
                    calculate(
                            position + 1,
                            createPuzzle(position, puzzle, it))
            }.find { !it.isEmpty() }

            if (solution != null) {
                return solution
            } else {
                return IntArray(0)
            }
        }
    }
}