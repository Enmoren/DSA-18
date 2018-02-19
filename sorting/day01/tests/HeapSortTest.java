import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HeapSortTest {
    private int[] emptyCase;
    private int[] oneCase;
    private int[] twoCase;
    private int[] threeCase;
    private int[] eightCase;
    private int[] nineCase;
    private int[] longCase;


    @BeforeEach
    public void setup() {
        emptyCase = new int[]{};
        oneCase = new int[]{2};
        twoCase = new int[]{2, 1};
        threeCase = new int[]{2, 1, 2};
        eightCase = new int[]{2, 1, 2, 0, 5, 6, 5, 2};
        nineCase = new int[]{2, 1, 2, 0, 5, 6, 5, 2, -1};
        longCase = new int[]{-78, 93, 88, 30, 82, 33, -78, 5, 2, -12, -85, -41, 95, -24, -2, -8, 36, 17, -5, 68, 21, -67, 56, -40, 60, 35, -60, 29, -84, -60, -38, -20, 66, 19, 33, -40, 54, -61, -59, -19, -9, -16, 22, -5, 9, 26, -76, 37, 80, -7, -59, 89, 95, -95, -59, 65, -89, 23, -36, -5, 92, -90, 54, -78, 91, 33, -45, 79, 79, -25, -84, 16, 23, 15, -92, -61, -84, -35, -47, -96, 77, 87, 17, 74, 68, 92, 87, -26, 33, -43, 94, -31, -49, 76, 89, -24, -31, -19, -78, -85, 90, -7, 20, -75, -1, 99, -4, 66, -88, 77, 78, 82, -52, 5, 97, 46, 94, -69, 68, -12, 12, -52, -71, 35, 67, -21, 11, 9, -67, 53, 75, -33, -33, 55, 46, 43, -32, 56, 92, -65, -78, 17, 22, -54, 74, 29, 36, 56, 41, -82, -70, 1, -80, 11, -3, -69, -85, 8, 92, 58, -99, -20, -30, 89, 65, 61, -80, -87, -41, -82, -15, 80, -34, -56, -10, -52, 62, 73, 63, -1, -12, -45, 38, -74, 9, -67, 49, -20, -14, 85, -96, 79, 85, 29, -10, 65, -54, -35, 40, 29, 88, -51, -48, -86, -23, -74, -16, -69, 26, -70, 53, -6, -98, -57, -42, 81, -21, -1, -58, -17, 22, 31, 12, -12, 78, 47, -45, 42, 57, -77, 55, 70, 70, 35, -93, -76, -68, -80, -84, 46, -97, -63, -76, 62, -59, -92, 53, 61, -35, -61, 18, 25, -41, -45, 57, 37, 82, -4, -16, -31, -53, -32, -98, 30, -20, -15, -64, 63, -65, -9, -89, 19, -69, 21, 92, -82, 46, 70, -41, -10, -82, -38, 6, -26, 63, -54, -74, 33, 100, 67, -87, -51, -100, 40, -90, 81, 96, 82, 79, 98, -63, -61, -76, 80, 20, -87, -87, 97, 35, 95, 0, -68, 83, -4, -78, 15, 56, 81, -67, -55, -57, -8, -19, 41, -99, -16, 77, 50, -17, -73, 14, -93, 9, -74, -18, 17, -99, 2, 11, 29, -46, -22, 23, 76, 34, -8, -41, 88, 28, 33, 7, 98, -17, 96, -30, 61, 7, -51, -30, 72, -66, 56, -70, 17, 70, -8, 51, 9, 71, 23, -86, 43, -82, 27, -87, 16, -90, -86, 47, 89, 61, -41, -73, 36, 72, 96, 89, -52, 54, 47, -39, 90, 31, 84, -57, 8, -97, 77, -59, 32, -97, -4, -80, 66, -32, 79, 46, 63, 52, 16, 72, 96, -58, -87, 68, -78, -78, -2, 55, 75, -71, -65, -29, 66, -49, 91, 56, -63, -59, -28, -67, -15, 76, -32, 74, 37, 38, -28, -99, 73, 71, -85, 38, -95, -47, -73, 12, 48, 21, 73, 32, -72, 70, -46, 20, -79, -19, 17, -39, 11, -99, -83, -14, -5, 72, -49, -21, -52, -25, -63, 69, 34, 73, 18, 11, -66, 46, 14, -44, -67, 16, 52, -80, -91, 5, -49, 75, -14, -7, 72, 73, -96, 18, -81, -90, -15, -48, 31, 33, -3, -3, -4, 2, 94, 90, 63, 53, 95, 46, 37, 70, -40, -21, 40, 100, -24, 7, 54, 2, -52, 57, -16, -48, -81, 93, -36, 80, 71, -72, 41, -35, -39, 12, 33, 21, 5, 9, -43, 93, -66, -73, -42, 53, -49, 80, -15, -74, 39, -47, 58, -82, 97, 39, -82, 74, 11, -75, -23, 69, 59, -75, -79, 40, 54, -69, 98, 62, 51, -21, -22, 41, 13, 88, -67, 78, -24, 77, 58, -11, -61, -81, -50, -61, -98, -94, -68, 82, 2, -49, 24, 31, -97, 13, -53, 95, 91, 31, 9, -16, -97, 72, 34, 51, -100, -7, 33, 34, -96, 22, -1, -16, 46, -19, -78, 58, -77, 52, 55, 98, -78, -55, 89, -41, -31, -38, 80, -54, 54, 84, -84, 55, -56, 11, -88, 58, 68, 33, 81, 5, -71, -50, 37, 65, -74, 97, 37, -19, 6, 14, -76, -64, 80, -20, -94, -25, 40, -88, 60, 18, 75, -2, 24, -13, 94, -8, -98, -98, -53, -44, 82, -96, -39, 89, 85, -82, -43, -18, -11, -92, 46, -59, 68, -27, -56, 28, 72, -74, -64, -33, 6, -88, -59, -98, 73, -50, 28, 18, 3, 92, -28, 34, -1, 12, 87, -11, -47, -64, 77, -5, -80, -50, 81, 26, -15, -93, -60, 28, 81, -3, -91, -72, -53, 71, -42, 61, 10, 87, -16, -35, -52, 71, -20, 96, 44, 40, 79, 29, 78, 70, 8, 35, 15, -85, -6, 31, -22, 38, 35, 94, 20, 3, -84, 34, -10, 17, 19, 12, 18, 68, -86, 72, -84, 6, 53, -80, -64, 57, -27, 51, 89, 69, 29, -25, -34, 17, -78, -92, -8, 21, -60, -32, -58, 80, -74, -14, 22, 19, 79, 93, 82, -90, 93, -16, -68, -52, -3, -28, -50, -19, -39, -52, 21, -62, 5, 58, -18, 68, 88, -46, -52, 93, -68, 43, -40, -22, -20, -47, -94, 27, -93, -40, 68, -13, 33, 61, 48, 41, -68, -37, -88, 30, -98, 81, 6, 6, -83, -79, 62, 71, 17, -43, -93, 21, 99, 94, -100, -64, -90, 18, -39, -12, 6, 63, -9, 62, -26, -84, 47, -91, 41, -48, 43, -86, 42, 2, -16, -16, -20, -45, -32, -75, -3, -58, -95, 39, -63, 78, 25, 94, 15, -89, 6, -44, 10, 90, 50, -30, 82, -60, -32, 100, -69, 31, 33, 38, -41, -48, -91, -31, -42, -21, 34, -42, 1, 1, 6, -71, -30, -6, 72, -17, 34, -100, -56, -93, -37, -4, -39, -50, -82, -53, -27, 6, -71, 84, -96, -91, -91, -28, -23, 12, 27, 53, 54, -25, -24, -6, -33, 22, -15, 73, -79, -95, -80, -91, -88, 45, -57, 95, 67, -55, -44, 47, -74, -94, -96, -41, 83, 23, 28, 97, -19, -70, 2, -21, 53, 68, -16, 65, 54, 92, 80, -16, 31, -12, -52, -81, -41, -95, -22, -29, -72, -64, 20, 41, 98, 42, 100, 50, -38, -89, 53, 77, -79, -31, 33, 69, 6, 44, -53};
    }

    @Test
    public void testHeapify() {
        HeapSort hs = new HeapSort();
        int[] in = new int[]{8, 2, 9, 1, 5, 6, 3, 1, 2};
        int[] heap = new int[]{9, 5, 8, 2, 2, 6, 3, 1, 1};
        hs.heapify(in);
        assertArrayEquals(in, heap);
        in = new int[]{1, 3, 2, 5, 1, 2, 7, 9};
        heap = new int[]{9, 5, 7, 3, 1, 2, 2, 1};
        hs.heapify(in);
        assertArrayEquals(in, heap);
    }

    @Test
    public void testSink() {
        HeapSort hs = new HeapSort();
        int[] in = new int[]{4, 2, 9, 1, 5, 6, 3, 1, 2};
        hs.heap = in;
        hs.size = in.length;
        hs.sink(5);
        hs.sink(7);
        hs.sink(8);
        int[] out = new int[]{4, 2, 9, 1, 5, 6, 3, 1, 2};
        assertArrayEquals(in, out);
        hs.sink(3);
        hs.sink(0);
        out = new int[]{9, 2, 6, 2, 5, 4, 3, 1, 1};
        assertArrayEquals(in, out);
    }

    private void testSort(SortAlgorithm sorter) {
        assertArrayEquals(sorter.sort(emptyCase), sort(emptyCase));
        assertArrayEquals(sorter.sort(oneCase), sort(oneCase));
        assertArrayEquals(sorter.sort(twoCase), sort(twoCase));
        assertArrayEquals(sorter.sort(twoCase), sort(twoCase));
        assertArrayEquals(sorter.sort(threeCase), sort(threeCase));
        assertArrayEquals(sorter.sort(eightCase), sort(eightCase));
        assertArrayEquals(sorter.sort(nineCase), sort(nineCase));
        assertArrayEquals(sorter.sort(twoCase), sort(twoCase));
        assertArrayEquals(sorter.sort(longCase), sort(longCase));
    }

    private int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    @Test
    public void testHeapSort() {
        testSort(new HeapSort());
    }

}
