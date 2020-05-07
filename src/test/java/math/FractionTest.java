package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FractionTest {

    private void assertFraction(int expectedNumerator, int expectedDenominator, Fraction actual) {
        assertAll("fraction",
                () -> assertEquals(expectedNumerator, actual.getNumerator(), "Invalid numerator"),
                () -> assertEquals(expectedDenominator, actual.getDenominator(), "Invalid denominator")
        );
    }

    @Test
    public void testFractionIntInt() {
        assertFraction(1, 4, new Fraction(1, 4));
        assertFraction(-13, 27, new Fraction(13, -27));
        assertFraction(5, 7, new Fraction(-5, -7));
        assertFraction(4, 2, new Fraction(4, 2));
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> new Fraction(11, 0));
        assertEquals("Division by zero", e.getMessage());
    }

    @Test
    public void testFractionInt() {
        assertFraction(0, 1, new Fraction(0));
        assertFraction(3, 1, new Fraction(3));
        assertFraction(-13, 1, new Fraction(-13));
    }

    @Test
    public void testAddInt() {
        Fraction f = new Fraction(13, 7);
        assertFraction(27, 7, f.add(2));
        assertFraction(-1, 7, f.add(-2));
    }

    @Test
    public void testSubtractInt() {
        Fraction f = new Fraction(111, 53);
        assertFraction(-154, 53, f.subtract(5));
        assertFraction(164, 53, f.subtract(-1));
    }

    @Test
    public void testMultiplyInt() {
        Fraction f = new Fraction(93, 13);
        assertSame(Fraction.ZERO, f.multiply(0));
        assertFraction(279, 13, f.multiply(3));
        assertFraction(-279, 13, f.multiply(-3));
    }

    @Test
    public void testDivideInt() {
        Fraction f = new Fraction(8, 3);
        assertFraction(8, 12, f.divide(4));
        assertFraction(-8, 33, f.divide(-11));
        assertThrows(ArithmeticException.class, () -> f.divide(0));
    }

    @Test
    public void testPow() {
        Fraction f = new Fraction(2, 5);
        assertFraction(1, 1, f.pow(0));
        assertFraction(4, 25, f.pow(2));
        assertFraction(25, 4, f.pow(-2));
    }

    @Test
    public void testAddFraction() {
        Fraction f = new Fraction(12, 17);
        assertFraction(13, 17, f.add(new Fraction(1, 17)));
        assertFraction(41, 34, f.add(new Fraction(1, 2)));
    }

    @Test
    public void testSubtractFraction() {
        Fraction f = new Fraction(12, 17);
        assertFraction(11, 17, f.subtract(new Fraction(1, 17)));
        assertFraction(7, 34, f.subtract(new Fraction(1, 2)));
    }

    @Test
    public void testDivideFraction() {
        Fraction f = new Fraction(-21, 7);
        assertFraction(147, 147, f.divide(f));
        assertThrows(ArithmeticException.class, () -> f.divide(Fraction.ZERO));
    }

    @Test
    public void testMultiplyFraction() {
        Fraction f = new Fraction(11, 13);
        assertSame(Fraction.ZERO, f.multiply(Fraction.ZERO));
        assertFraction(121, 169, f.multiply(f));
        assertFraction(143, 143, f.multiply(new Fraction(13, 11)));
    }

    @Test
    public void testReciprocal() {
        assertFraction(111, 1024, new Fraction(1024, 111).reciprocal());
        assertFraction(-13, 37, new Fraction(-37, 13).reciprocal());
        assertThrows(ArithmeticException.class, () -> new Fraction(0, 7).reciprocal());
    }

    @Test
    public void testAbs() {
        assertFraction(713, 31, new Fraction(713, 31).abs());
        assertFraction(713, 31, new Fraction(-713, 31).abs());
    }

    @Test
    public void testIsZero() {
        assertTrue(Fraction.ZERO.isZero());
        assertTrue(new Fraction(0, -13).isZero());
        assertFalse(new Fraction(4096, 19).isZero());
    }

    @Test
    public void testReduce() {
        assertFraction(1073, 1477, new Fraction(1073, 1477).reduce());
        assertFraction(193, 581, new Fraction(1329577, 4002509).reduce());
    }

    @Test
    public void testToString() {
        assertEquals("0", Fraction.ZERO.toString());
        assertEquals("-32000", new Fraction(-32000).toString());
        assertEquals("3/4", new Fraction(3, 4).toString());
        assertEquals("-51/48", new Fraction(51, -48).toString());
    }

    @Test
    public void testByteValue() {
        assertEquals(4, new Fraction(13, 3).byteValue());
        assertEquals(0, new Fraction(1, 4).byteValue());
        assertEquals(-1, new Fraction(-4, 3).byteValue());
        assertEquals(-126, new Fraction(-1638, 13).byteValue());
    }

    @Test
    public void testDoubleValue() {
        assertEquals(1.0 / 3, new Fraction(1, 3).doubleValue(), 1E-10);
        assertEquals(123456.0 / 101, new Fraction(123456, 101).doubleValue(), 1E-10);
    }

    @Test
    public void testFloatValue() {
        assertEquals(1f / 3, new Fraction(1, 3).floatValue(), 1E-10);
        assertEquals(123456f / 101, new Fraction(123456, 101).floatValue(), 1E-10);
    }

    @Test
    public void testIntValue() {
        assertEquals(4, new Fraction(13, 3).intValue());
        assertEquals(0, new Fraction(1, 4).intValue());
        assertEquals(-1, new Fraction(-4, 3).intValue());
        assertEquals(123456, new Fraction(1358016, 11).intValue());
    }

    @Test
    public void testLongValue() {
        assertEquals(4, new Fraction(13, 3).longValue());
        assertEquals(0, new Fraction(1, 4).longValue());
        assertEquals(-1, new Fraction(-4, 3).longValue());
        assertEquals(123456, new Fraction(1358016, 11).longValue());
    }

    @Test
    public void testShortValue() {
        assertEquals(4, new Fraction(13, 3).shortValue());
        assertEquals(0, new Fraction(1, 4).shortValue());
        assertEquals(-1, new Fraction(-4, 3).shortValue());
        assertEquals(32000, new Fraction(160000, 5).shortValue());
    }

    @Test
    public void testClone() {
        Fraction f = new Fraction(3, 4);
        Fraction copy = (Fraction) f.clone();
        assertNotSame(f, copy);
        assertFraction(3, 4, copy);
    }

    @Test
    public void testHashCode() {
        Fraction f = new Fraction(3, 7);
        assertTrue(f.hashCode() == f.hashCode());
        assertTrue(f.hashCode() == new Fraction(3, 7).hashCode());
    }

    @Test
    public void testEquals() {
        Fraction f = new Fraction(2, 5);
        assertFalse(f.equals(null));
        assertTrue(f.equals(f));
        assertTrue(f.equals(new Fraction(2, 5)));
        assertFalse(f.equals(new Fraction(2, 7)));
        assertFalse(f.equals(new Fraction(4, 10)));
    }

}
