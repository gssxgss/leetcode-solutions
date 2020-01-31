func containsDuplicate(nums []int) bool {
    m := make(map[int]int)

    for i := 0; i < len(nums); i++ {
        key := nums[i]
        if _, ok := m[key]; ok {
            m[key]++
        } else {
            m[key] = 0
        }
    }

    for _, value := range m {
        if value > 0 {
            return true
        }
    }
    return false
}

