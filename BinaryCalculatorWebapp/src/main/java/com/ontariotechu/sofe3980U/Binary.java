package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary {
    private String number = "0"; // string containing the binary value '0' or '1'

    public Binary(String number) {
        if (number == null || number.isEmpty()) {
            this.number = "0";
            return;
        }

        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0";
                return;
            }
        }

        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') {
                break;
            }
        }

        this.number = (beg == number.length()) ? "0" : number.substring(beg);

        if (this.number.isEmpty()) {
            this.number = "0";
        }
    }

    public String getValue() {
        return this.number;
    }

    public static Binary add(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        int carry = 0;
        String num3 = "";

        while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
            int sum = carry;
            if (ind1 >= 0) {
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }
            carry = sum / 2;
            sum = sum % 2;
            num3 = ((sum == 0) ? "0" : "1") + num3;
        }
        return new Binary(num3);
    }

    public static Binary or(Binary a, Binary b) {
        String x = a.number;
        String y = b.number;

        int maxLen = Math.max(x.length(), y.length());
        x = String.format("%" + maxLen + "s", x).replace(' ', '0');
        y = String.format("%" + maxLen + "s", y).replace(' ', '0');

        String result = "";
        for (int i = 0; i < maxLen; i++) {
            result += (x.charAt(i) == '1' || y.charAt(i) == '1') ? "1" : "0";
        }

        return new Binary(result);
    }

    public static Binary and(Binary a, Binary b) {
        String x = a.number;
        String y = b.number;

        int maxLen = Math.max(x.length(), y.length());
        x = String.format("%" + maxLen + "s", x).replace(' ', '0');
        y = String.format("%" + maxLen + "s", y).replace(' ', '0');

        String result = "";
        for (int i = 0; i < maxLen; i++) {
            result += (x.charAt(i) == '1' && y.charAt(i) == '1') ? "1" : "0";
        }

        return new Binary(result);
    }

    public static Binary multiply(Binary a, Binary b) {
        Binary result = new Binary("0");
        String x = a.number;
        String y = b.number;

        int shift = 0;
        for (int i = y.length() - 1; i >= 0; i--) {
            if (y.charAt(i) == '1') {
                String shifted = x;
                for (int j = 0; j < shift; j++) {
                    shifted += "0";
                }
                result = Binary.add(result, new Binary(shifted));
            }
            shift++;
        }

        return result;
    }
}
