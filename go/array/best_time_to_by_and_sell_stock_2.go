func maxProfit(prices []int) int {
    total_max := 0
    partial_max := 0
    start := 0
    current := start + 1

    for current < len(prices) {
        if prices[current - 1] > prices[current] {
            start = current
            total_max += partial_max
            partial_max = 0
        } else {
            current_max := prices[current] - prices[start]
            if partial_max < current_max {
                partial_max = current_max
            }
        }
        current++
    }
    if partial_max > 0 {
        total_max += partial_max
    }
    return total_max
}

