package io.github.pheerathach;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class ThaiBahtUtils {

    private static final String[] UNIT_WORDS = new String[]{"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน", "ล้าน"};
    private static final String[] NUM_WORDS = new String[]{"ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า"};
    private static final String WORD_ONLY = "ถ้วน";
    private static final String WORD_TWENTY = "ยี่";
    private static final String WORD_ONE = "เอ็ด";
    private static final String WORD_BAHT = "บาท";
    private static final String WORD_SATANG = "สตางค์";
    private static final String WORD_MINUS = "ลบ";
    private static final String AMOUNT_BAHT_SATANG_DELIMITER = "\\.";
    private static final String EMPTY_STRING = "";

    private ThaiBahtUtils() {
    }

    public static String toText(BigDecimal amount) {
        String sign = EMPTY_STRING;
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            sign = WORD_MINUS;
        }
        return sign + toText(amount.abs().setScale(2, RoundingMode.DOWN).toString());
    }

    private static String toText(String amount) {
        String[] parts = amount.split(AMOUNT_BAHT_SATANG_DELIMITER);

        BigInteger integerPartBigInteger = new BigInteger(parts[0]);
        String integerPartText = toText(integerPartBigInteger.toString(), 0) + WORD_BAHT;
        if (parts.length == 1) {
            return integerPartText + WORD_ONLY;
        }

        String decimalPartText = null;
        BigInteger decimalPartBigInteger = new BigInteger(parts[1]);
        if (parts[1].length() == 1) {
            decimalPartBigInteger = decimalPartBigInteger.multiply(BigInteger.TEN);
        }

        if (!BigInteger.ZERO.equals(decimalPartBigInteger)) {
            decimalPartText = toText(decimalPartBigInteger.toString(), 0) + WORD_SATANG;
        }

        if (BigInteger.ZERO.equals(integerPartBigInteger) && decimalPartText != null) {
            return decimalPartText;
        }

        if (decimalPartText == null) {
            return integerPartText + WORD_ONLY;
        }

        return integerPartText + decimalPartText;
    }

    private static String toText(String amount, int index) {
        int number = amount.charAt(index) - 48;

        String numWord = NUM_WORDS[number];
        int unit = amount.length() - index - 1;

        if (unit > 6) {
            return toText(amount.substring(0, amount.length() - 6), 0) + UNIT_WORDS[6] + toText(amount.substring(amount.length() - 6), 0);
        }

        String unitWord = UNIT_WORDS[unit];
        if ((index > 0 || unit > 0) && number == 0) {
            numWord = EMPTY_STRING;
            unitWord = EMPTY_STRING;
        }

        if (index == amount.length() - 1 && amount.length() > 1 && number == 1) {
            numWord = WORD_ONE;
        }

        if (index == amount.length() - 2) {
            if (number == 1) {
                numWord = EMPTY_STRING;
            } else if (number == 2) {
                numWord = WORD_TWENTY;
            }
        }

        return numWord + unitWord + (index < amount.length() - 1 ? toText(amount, index + 1) : EMPTY_STRING);
    }

}
