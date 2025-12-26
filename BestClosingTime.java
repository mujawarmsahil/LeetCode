class BestClosingTime {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        // prefixN[i] = number of 'N' in range [0 ... i-1]
        int[] prefixN = new int[n + 1];

        // suffixY[i] = number of 'Y' in range [i ... n-1]
        int[] suffixY = new int[n + 1];

        // Build prefix array
        for (int i = 1; i <= n; i++) {
            prefixN[i] = prefixN[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                prefixN[i]++;
            }
        }

        // Build suffix array
        for (int i = n - 1; i >= 0; i--) {
            suffixY[i] = suffixY[i + 1];
            if (customers.charAt(i) == 'Y') {
                suffixY[i]++;
            }
        }

        int minPenalty = Integer.MAX_VALUE;
        int bestTime = 0;

        // Try closing time from 0 to n
        for (int i = 0; i <= n; i++) {
            int penalty = prefixN[i] + suffixY[i];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestTime = i;
            }
        }

        return bestTime;
    }
}
