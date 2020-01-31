func rotate(nums []int, k int) {
    step := k % len(nums)
    if step == 0 {
        return
    }

    reverse(nums)
    reverse(nums[0:step])
    reverse(nums[step:len(nums)])
    return
}

func reverse(arr []int) {
    for left, right := 0, len(arr) - 1; left < right; left, right = left + 1, right - 1 {
        arr[left], arr[right] = arr[right], arr[left]
    }
}

