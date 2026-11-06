package com.bits.leave;

public class LeaveCalculator {

    // Remaining leave balance = entitled - taken
    public int calculateBalance(int entitled, int taken) {
        if (entitled < 0 || taken < 0) {
            throw new IllegalArgumentException("Leave days cannot be negative");
        }
        return Math.max(entitled - taken, 0);
    }

    // Encashment = balance days * (monthly basic salary / 30)
    public double calculateEncashment(int balanceDays, double monthlyBasic) {
        if (balanceDays < 0 || monthlyBasic < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        }
        return balanceDays * (monthlyBasic / 30.0);
    }
}
