package interview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SequenceFindTest {

    private SequenceFind main = new SequenceFind();

    @Test
    public void testSampleInput() {
        List<Integer> in = Arrays.asList(2, 10, 4, 3, 8, 6, 9, 9, 18, 27);
        List<List<Integer>> result = main.findSequences(in);
        assertEquals(2, result.size());
        assertEquals(Arrays.asList(2, 4, 8), result.get(0));
        assertEquals(Arrays.asList(3, 9, 27), result.get(1));
    }

    @Test
    public void testFinalInput() {
        List<Integer> in = Arrays.asList(2, 10, 4, 3, 8, 6, 9, 9, 18, 27, 1, 52, 81, 10, 1, 0, 2, 0, 4, 0, 8, 0, 16, 0, 32, 0, 64, 0, 128, 2, 10, 4, 3, 8, 6, 9, 9, 18, 27, 1, 52, 81, 10, 100, 50, 0, 0, 0, 0, 0, 0);
        List<List<Integer>> result = main.findSequences(in);
        assertEquals(3, result.size());
    }

    @Test
    public void testEdgeCase1() {
        List<Integer> in = Arrays.asList(1, 0, 0, 3, 0, 0, 9);
        List<List<Integer>> result = main.findSequences(in);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1, 3, 9), result.get(0));
    }

    @Test
    public void testEdgeCase2() {
        List<Integer> in = Arrays.asList(1, 0, 2, 0, 4);
        List<List<Integer>> result = main.findSequences(in);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1, 2, 4), result.get(0));
    }

    @Test
    public void testEdgeCase3() {
        List<Integer> in = Arrays.asList(1, 0, 0, 0, 4, 0, 0, 0, 16);
        List<List<Integer>> result = main.findSequences(in);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1, 4, 16), result.get(0));
    }

}