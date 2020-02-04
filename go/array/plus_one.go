func plusOne(digits []int) []int {
    l := len(digits)
    carry := 0
    for i := l - 1; i > -1; i-- {
        if i < l - 1 {
            if carry > 0 {
                digits[i]+= carry

                if digits[i] == 10 {
                    carry = 1
                    digits[i] = 0
                } else {
                    carry = 0
                }
            }
        } else {
            digits[i]++
            if digits[i] == 10 {
                carry = 1
                digits[i] = 0
            }

        }

    }
    if carry == 1 {
        digits = append([]int{1}, digits...) // prepend
    }
    return digits
}
