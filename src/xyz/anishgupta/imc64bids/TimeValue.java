package xyz.anishgupta.imc64bids;

public class TimeValue {
    public double calculateTime(int days, int hours, int minutes) {
        // 1 day    = 1/365. years
        // 1 hour   = 1/8760. years
        // 1 minute = 1/525600. years
        return days/365. + hours/8760. + minutes/525600.;
    }
}