class WordBreak {

    // Entry point for the Word Break problem
    public boolean wordBreak(String s, List<String> wordDict) {
        // Memo map stores whether a substring can be broken or not
        // Key   -> substring
        // Value -> true / false
        return helper(s, wordDict, new HashMap<>());
    }

    // Recursive helper function with memoization
    private boolean helper(String s, List<String> wordDict, Map<String, Boolean> memo) {

        // Base case:
        // If the string is empty, it means we successfully segmented it
        if (s.isEmpty()) {
            return true;
        }

        // If this substring was already computed, return the stored result
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        // Try breaking the string using each word in the dictionary
        for (String word : wordDict) {

            // Check if the current string starts with the dictionary word
            if (s.startsWith(word)) {

                // Recursively check the remaining substring
                if (helper(s.substring(word.length()), wordDict, memo)) {

                    // If successful, store result in memo and return true
                    memo.put(s, true);
                    return true;
                }
            }
        }

        // If no dictionary word leads to a valid segmentation,
        // mark this substring as not breakable
        memo.put(s, false);
        return false;
    }
}
