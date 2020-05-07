package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GCDTest {

    @Test
    public void testGcd() {
        assertEquals(307, GCD.gcd(8388161, 31007));
        assertEquals(307, GCD.gcd(31007, 8388161));
        assertEquals(1, GCD.gcd(211, 1024));
        assertEquals(1, GCD.gcd(1024, 211));
        assertEquals(0, GCD.gcd(0, 0));
        assertEquals(73, GCD.gcd(0, 73));
        assertEquals(73, GCD.gcd(73, 0));
        assertEquals(25, GCD.gcd(-2125, 825));
        assertEquals(25, GCD.gcd(2125, -825));
        assertEquals(25, GCD.gcd(-2125, -825));
    }

}
