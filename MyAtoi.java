class MyAtoi {
    public int myAtoi(String s) {
        int index = 0;
        int n = s.length();
        boolean isPositive = true;

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            if (s.charAt(index) == '-') {
                isPositive = false;
            }
            index++;
        }

        int num = 0;

        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            index++;
        }

        return isPositive ? num : -num;
    }
}
