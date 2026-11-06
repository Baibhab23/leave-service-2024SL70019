package com.bits.leave;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeaveCalculatorTest {

    private final LeaveCalculator calc = new LeaveCalculator();

    @Test
    public void testBalanceNormal() {
        assertEquals(12, calc.calculateBalance(30, 18));
    }

    @Test
    public void testBalanceNeverNegative() {
        assertEquals(0, calc.calculateBalance(10, 15));
    }

    @Test
    public void testEncashment() {
        assertEquals(10000.0, calc.calculateEncashment(10, 30000.0), 0.001);
    }
}
