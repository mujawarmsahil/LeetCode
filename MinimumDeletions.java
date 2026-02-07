class MinimumDeletions {
    public int minimumDeletions(String s) {
        int bCount = 0;     // Number of 'b's seen so far
        int deletions = 0;  // Minimum deletions required

        // Traverse the string character by character
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                // Count 'b' because it may cause imbalance later
                bCount++;
            } else { // c == 'a'
                // If 'a' comes after some 'b's, it's an invalid pattern "ba"
                if (bCount > 0) {
                    deletions++; // Delete this 'a'
                    bCount--;    // Or equivalently, delete one previous 'b'
                }
            }
        }

        return deletions;
    }
}
