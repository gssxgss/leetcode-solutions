func singleNumber(nums []int) int {
    m := make(map[int]bool)

    for _, v := range nums {
        if _, ok := m[v]; ok {
            delete(m, v)
        } else {
            m[v] = true
        }
    }

    for k, _ := range m {
        return k
    }
    return 0
}
