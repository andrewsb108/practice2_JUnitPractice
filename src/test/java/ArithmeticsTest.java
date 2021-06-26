import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class ArithmeticsTest {
    private final double EPS = 1e-9;
    private static Arithmetics a;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @Rule
    public Timeout timeout = new Timeout(1000);

    @BeforeClass
    public static void setUp() {
        a = new Arithmetics();
    }



    @Test
    public void testAdd() {
        a = new Arithmetics();
        Arithmetics b = new Arithmetics();
        double res = a.add(3, 7);
        if (res != 10) {
            fail();
        }
        assertTrue(res == 10);
        assertFalse(res == 9);
        assertNotNull(a);
        assertEquals(10, res, EPS);
        assertNotSame(a, b);
    }

    @Test
    public void testMult() {
        a = new Arithmetics();
        double res = a.mult(3, 7);
        if (res != 21) {
            fail();
        }
        assertEquals(21, res, EPS);
    }

    @Test
    public void testDeduct() {
        a = new Arithmetics();
        double res = a.deduct(3, 7);
        if (res != -4) {
            fail();
        }
        assertEquals(-4, res, EPS);
    }

    @Test
    public void testDiv() {
        a = new Arithmetics();
        double res = a.div(10, 5);
        if (res != 2) {
            fail();
        }
        assertEquals(2, res, EPS);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivException() {
        a = new Arithmetics();
        a.div(10.0, 0.0);
    }

    @Test
    public void testDivExceptionWithRule() {
        exp.expect(ArithmeticException.class);
        a = new Arithmetics();
        a.div(10.0, 0.0);
    }

    @Test(timeout = 1000)
    public void testN() {
        a.div(10.0, 10.0);
    }
}