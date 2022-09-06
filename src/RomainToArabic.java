class RomainToArabic {
    static int romainToArabic(String input) {
        input = input.toUpperCase();
        int result = 0;
        int prev = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            int curr = RomainNumber.valueOf(String.valueOf(input.charAt(i))).getArabicNumber();
            if (curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }
            prev = curr;
        }
        return result;
    }
}
