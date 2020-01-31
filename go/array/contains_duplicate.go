func containsDuplicate(nums []int) bool {
    m := make(map[int]bool)

    for _, key := range nums {
        if _, ok := m[key]; ok {
            return true
        }
        m[key] = true
    }
    return false
}

