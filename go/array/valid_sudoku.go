import (
	"strconv"
)

func getRowKey(row int, val byte) string {
	return "r" + strconv.Itoa(row) + "v" + string(val)
}

func getColKey(col int, val byte) string {
	return "c" + strconv.Itoa(col) + "v" + string(val)
}

func getBoxKey(row int, col int, val byte) string {
	return "b" + strconv.Itoa(row/3) + strconv.Itoa(col/3) + string(val)
}

func isValidSudoku(board [][]byte) bool {
	set := make(map[string]bool)

	for row, line := range board {
		for col, val := range line {
			if val == '.' {
				continue
			}

			rowKey := getRowKey(row, val)
			colKey := getColKey(col, val)
			boxKey := getBoxKey(row, col, val)

			if _, ok := set[rowKey]; ok {
				return false
			} else {
				set[rowKey] = true
			}

			if _, ok := set[colKey]; ok {
				return false
			} else {
				set[colKey] = true
			}

			if _, ok := set[boxKey]; ok {
				return false
			} else {
				set[boxKey] = true
			}
		}
	}

	return true

}

