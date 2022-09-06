import java.io.IOException;

class Calc {
    static String calc(String[] input, String action) throws IOException {
        ArabicToRoman arabicToRoman = new ArabicToRoman();
        int a = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int sum = 0;
        if (action.contains("+")) {
            sum = a + c;
        } else if (action.contains("-")) {
            sum = a - c;
        } else if (action.contains("*")) {
            sum = a * c;
        } else if (action.contains("/")) {
            sum = a / c;
        }
        if (Converter.isB() && sum < 0) {
            throw new IOException("в римской системе нет отрицательных чисел");
        }
        if (Converter.isB()) {
            return arabicToRoman.arabicNumToRoman(sum);
        }
        return Integer.toString(sum);
    }
}
