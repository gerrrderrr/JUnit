import org.junit.jupiter.api.*;

public class MatrixTest {
    private static long startTime;
    private long testStartTime;
    private final int sutSize = 8;
    Matrix sut = new Matrix(sutSize);

    @BeforeAll
    public static void init() {
        System.out.println("Testing started");
        startTime = System.nanoTime();
    }

    @AfterAll
    public static void completedAll() {
        System.out.println("All tests completed in " + (System.nanoTime() - startTime));
    }

    @BeforeEach
    public void startTest() {
        System.out.println("Test started");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void testCompleted() {
        System.out.println("Test completed in " + (System.nanoTime() - testStartTime));
    }

    @Test
    public void matrixTest() {
        Assertions.assertNotNull(sut);
    }

    @Test
    public void amountOfElementsTest() {
        int expected = sutSize * sutSize;
        int actual = sut.amountOfElements();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void rotate90Test() {
        int[][] basic = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4}
        };
        int[][] expected = {
                {4, 3, 2, 1, 0},
                {4, 3, 2, 1, 0},
                {4, 3, 2, 1, 0},
                {4, 3, 2, 1, 0},
                {4, 3, 2, 1, 0},
        };
        int[][] actual = sut.rotate90(basic);
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void rotate180Test() {
        int[][] basic = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4}
        };
        int[][] expected = {
                {4, 4, 4, 4, 4},
                {3, 3, 3, 3, 3},
                {2, 2, 2, 2, 2},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
        };
        int[][] actual = sut.rotate180(basic);
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void rotate270Test() {
        int[][] basic = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4}
        };
        int[][] expected = {
                {0, 1, 2, 3, 4},
                {0, 1, 2, 3, 4},
                {0, 1, 2, 3, 4},
                {0, 1, 2, 3, 4},
                {0, 1, 2, 3, 4},
        };
        int[][] actual = sut.rotate270(basic);
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void getFirstNumTest() {
        int[][] basic = sut.getMatrix();
        int expected = basic[0][0];
        int actual = sut.getFirstNum();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void getLastNumTest() {
        int[][] basic = sut.getMatrix();
        int expected = basic[sutSize-1][sutSize-1];
        int actual = sut.getLastNum();
        Assertions.assertEquals(actual, expected);
    }
}
