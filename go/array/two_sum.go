func twoSum(nums []int, target int) []int {
    m := make(map[int]int)
    res := make([]int, 2)

    for i := 0; i < len(nums); i++ {
        rem := target - nums[i]
        if idx, ok := m[rem]; ok {
            res[0] = idx
            res[1] = i
            break
        } else {
            m[nums[i]] = i
        }
    }
    return res
}

