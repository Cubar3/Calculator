import java.io.IOException;

class Converter {
        static boolean b = false;

    static boolean isB() {
        return b;
    }

    static String[] converter(String input) throws IOException {
        input = input.toUpperCase();
        input = input.replace(" ", "");
        if (input.length() < 3 || input.length() > 5) {
            throw new IOException("Строка не является математической операцией");
        }
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' ||
                    input.charAt(i) == '*' || input.charAt(i) == '/') {
                cnt += 1;
            }
        }
        if (cnt == 0 || cnt > 1) {
            throw new IOException("Формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+,-,/,*)");
        }
        String[] exp = input.split("[+-/*]");
        boolean d, e, f;
        char ch1;
        char ch2;
        int count = 0;
        int count1 = 0;

        for (int i = exp[0].length() - 1; i >= 0; i--) {
            ch1 = exp[0].charAt(i);
            ch2 = exp[1].charAt(i);
            if (ch1 == 'I' || ch1 == 'V' || ch1 == 'X' || ch1 == 'L' || ch1 == 'C' || ch1 == 'D' || ch1 == 'M'){
                count += 1;
            }
            if (ch2 == 'I' || ch2 == 'V' || ch2 == 'X' || ch2 == 'L' || ch2 == 'C' || ch2 == 'D' || ch2 == 'M') {
                count1 += 1;
            }
        }
        d = count > 0;
        e = count1 > 0;
        f = d == e;

        if (f == false){
            throw new IOException("Используются одновременно разные системы счисления");
        }

        char a = ' ';
        for (int i = 0; i < exp.length - 1; i++) {
            for (int j = exp[i].length() - 1; j >= 0; j--) {
                a = exp[i].charAt(j);
            }
        }
        if (a == 'I' || a == 'V' || a == 'X' || a == 'L' || a == 'C' || a == 'D' || a == 'M') {
            b = true;
        }
        if (b) {
            exp[0] = String.valueOf(RomainToArabic.romainToArabic(exp[0]));
            exp[1] = String.valueOf(RomainToArabic.romainToArabic(exp[1]));
        }
        if (Integer.parseInt(exp[0]) > 10 || Integer.parseInt(exp[1]) > 10){
            throw new IOException("Операнд не должен быть больше 10");
        }
        return exp;
        }
    }

