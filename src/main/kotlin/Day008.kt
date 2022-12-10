class Day008 {

    fun visibleTreesCount(input: List<String>): Int {

        // add input data in a 2D array
        val rows = input.size
        val columns = input[0].length
        var visibleTrees = 0

        val forrest = input.map { row ->
            row.map(Char::digitToInt).toIntArray()
        }
            .toTypedArray()

        // count edge trees
//        visibleTrees = countEdgeTrees(rows, columns, visibleTrees)

        // check inner trees
        var innerTreesVisible = 0
        println(forrest[4][2])
        // 1-2 -> to verify with left 1-1, 1-0, with right 1-3, 1-4
//                          with up 0-2, with down 2-2, 3-2, 4-2
//        i vertical, j horizontal

         for (i in 0 until rows) {
            A@ for (j in 0 until columns) {
                if (i == 0 || i == rows - 1) {
                    visibleTrees++
                    continue
                } else if (j == 0 || j == columns - 1) {
                    visibleTrees++
                    continue
                } else {
                    // search left  1-2
                    for (k in j - 1 downTo 0)
                        if (forrest[i][j] <= forrest[i][k]) break
                        else if (k == 0) {
                            visibleTrees++
                            continue@A
                        }
                    // search right
                    for (k in j + 1 until rows)
                        if (forrest[i][j] <= forrest[i][k]) break
                        else if (k == rows - 1) {
                            visibleTrees++
                            continue@A
                        }
                    // search up
                    for (k in i - 1 downTo 0)
                        if (forrest[i][j] <= forrest[k][j]) break
                        else if (k == 0) {
                            visibleTrees++
                            continue@A
                        }
                    // search down
                    for (k in i + 1 until columns)
                        if (forrest[i][j] <= forrest[k][j]) break
                        else if (k == columns - 1) {
                            visibleTrees++
                            continue@A
                        }

                }

            }
        }

        return visibleTrees
    }

    private fun countEdgeTrees(rows: Int, columns: Int, visibleTrees: Int): Int {
        var visibleTrees1 = visibleTrees
        val edgeTreesVisible = (rows - 1) * (columns - 1)
        visibleTrees1 += edgeTreesVisible
        return visibleTrees1
    }

}

