package solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static solutions.Problem026.removeDuplicates;


class Problem026Test {

    @Test
    void test1() {
        int[] nums = new int[]{0, 0, 1, 1, 2, 3, 3, 3};
        int result = removeDuplicates(nums);
        assertEquals(4, result);
    }

    @Test
    void test2() {
        int[] nums = new int[]{0};
        int result = removeDuplicates(nums);
        assertEquals(1, result);
    }

    @Test
    void test3() {
        int[] nums = new int[]{0, 1, 2, 3};
        int result = removeDuplicates(nums);
        assertEquals(4, result);
    }

    @Test
    void test4() {
        int[] nums = new int[0];
        int result = removeDuplicates(nums);
        assertEquals(0, result);
    }
}