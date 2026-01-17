class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (sb.length() * 2 > s.length())
                break;

            if (s.length() % sb.length() != 0)
                continue;

            int times = s.length() / sb.length();
            String repeated = sb.toString().repeat(times);

            if (s.equals(repeated))
                return true;
        }

        return false;
    }
}
