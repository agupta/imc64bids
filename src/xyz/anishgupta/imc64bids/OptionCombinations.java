package xyz.anishgupta.imc64bids;

    import java.math.*;

    public class OptionCombinations {
        public String countCombinations(int strikes, int expiries) {
            int options = 2 * strikes * expiries;
            BigInteger result = new BigInteger("2");
            result = result.pow(options).subtract(BigInteger.valueOf(options + 1));
            return result.toString();
        }
    }
