public class NumSub {
    public static int numSub(String s) {
        long sum = 0;
        long mod = 1000000007;
        int index = 0;

        while (index < s.length()) {

            // Count consecutive 1s
            long substringLength = 0;
            while (index < s.length() && s.charAt(index) == '1') {
                substringLength++;
                index++;
            }

            // Formula for number of substrings in a block of 1s
            long total = substringLength * (substringLength + 1) / 2;

            // Add to sum with modulo
            sum = (sum + total) % mod;

            // Move to next character normally
            index++;
        }

        return (int)(sum % mod);
    }
}
