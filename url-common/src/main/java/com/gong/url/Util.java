package com.gong.url;

import java.security.SecureRandom;

/**
 * @author gongjunbing
 * @date 2020/03/14 15:44
 **/
public class Util {

    /**
     * 62进制字符
     */
    private static final String BASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

    /**
     * 幂数
     */
    private static final int EXPONENT = BASE.length();

    /**
     * 十进制转62进制
     *
     * @param value 十进制
     * @return 62进制
     */
    public static String convertToBase62(long value) {
        long mixValue = insertRandomBitPer5Bits(value);
        StringBuilder result = new StringBuilder();
        do {
            int index = (int) (mixValue % EXPONENT);
            result.append(BASE.charAt(index));
            mixValue /= EXPONENT;

        } while (mixValue > 0);

        return result.reverse().toString();
    }

    /**
     * 从低位开始每5位后插入一个随机为直到高位都是0
     *
     * @param value 十进制数
     * @return 混淆结果
     */
    private static long insertRandomBitPer5Bits(long value) {
        long result = value;
        long high = value;

        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            if (high == 0) {
                break;
            }

            int pos = 5 + 5 * i + i;
            high = result >> pos;
            result = ((high << 1 | secureRandom.nextInt(2)) << pos) | (result & (-1L >>> (64 - pos)));
        }

        return result;
    }
}
