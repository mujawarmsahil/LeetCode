class CountPalindromicSubsequence {
    public static int countPalindromicSubsequence(String word) {

        // Map that stores: character -> [firstIndex, lastIndex]
        Map<Character, int[]> map = new HashMap<>();

        // Step 1: Record first and last positions of each character
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // Create default array with {-1, -1}
            int[] positions = map.getOrDefault(ch, new int[]{-1, -1});

            // If first occurrence, set first index
            if (positions[0] == -1) {
                positions[0] = i;
            }

            // Always update last index
            positions[1] = i;

            map.put(ch, positions);
        }

        int total = 0;

        // Step 2: For each character, count distinct middle characters
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {

            int first = entry.getValue()[0];
            int last = entry.getValue()[1];

            // Character appears only once → can't form x_y_x palindrome
            if (first == last) continue;

            Set<Character> set = new HashSet<>();

            // Collect unique characters in-between
            for (int i = first + 1; i < last; i++) {
                set.add(word.charAt(i));
            }

            // Each unique middle char forms one palindrome
            total += set.size();
        }

        return total;
    }
}
