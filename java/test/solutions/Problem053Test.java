package solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static solutions.Problem053.maxSubArray;

class Problem053Test {
    @Test
    void sumup() {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(input);
        assertEquals(6, result);
    }
}