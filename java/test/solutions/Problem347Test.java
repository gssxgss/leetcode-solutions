package solutions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static solutions.Problem347.topKFrequent;

class Problem347Test {
    @Test
    void test1() {
        int[] list = new int[]{1, 1, 1, 2, 2, 3};
        List<Integer> res = topKFrequent(list, 1);
        assertArrayEquals(new Object[]{1}, res.toArray());
    }

    @Test
    void test2() {
        int[] list = new int[]{1, 1, 1, 2, 2, 3};
        List<Integer> res = topKFrequent(list, 2);
        assertArrayEquals(new Object[]{1, 2}, res.toArray());
    }

    @Test
    void test3() {
        int[] list = new int[]{1, 2, 3};
        List<Integer> res = topKFrequent(list, 2);
        assertArrayEquals(new Object[]{1, 2}, res.toArray());
    }

    @Test
    void test4() {
        int[] list = new int[]{4, 1, -1, 2, -1, 2, 3};
        List<Integer> res = topKFrequent(list, 2);
        assertArrayEquals(new Object[]{-1, 2}, res.toArray());
    }
}
