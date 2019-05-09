package com.wyl.tms.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;

public class CodeUtils {
    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final String UTF8 = "UTF8";
    private static final String DASHED = "-";

    public static String code(int n) {
        if (n < MIN || n > MAX) {
            throw new IllegalArgumentException("Cannot random " + n + " bit number!");
        }

        Random r = new Random();
        if (n == 1) {
            return String.valueOf(r.nextInt(MAX));
        }

        int bitField = 0;
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                int k = r.nextInt(MAX);
                if ((bitField & (1 << k)) == 0) {
                    bitField |= 1 << k;
                    arr[i] = (char) (k + '0');
                    break;
                }
            }
        }
        return new String(arr);
    }

    public static String genKey(String src) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(src.getBytes(UTF8));
            return convertToHexString(m.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String genKey() {
        return UUID.randomUUID().toString().replace(DASHED, StringUtils.EMPTY);
    }

    public static String UUIDString() {
        return UUID.randomUUID().toString();
    }

    public static String md5Hex(String src) throws Exception {
        return byte2HexStr(MessageDigest.getInstance("MD5").digest(src.getBytes("utf-8")));
    }

    public static String base64Encoder(String src) throws Exception {
        return new String(Base64.encodeBase64(src.getBytes()), "UTF-8");
    }

    private static String convertToHexString(byte data[]) {
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            strBuffer.append(Integer.toHexString((0x000000FF & data[i]) | 0xFFFFFF00).substring(6));
        }

        return strBuffer.toString();
    }

    private static String byte2HexStr(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            String s = Integer.toHexString(b[i] & 0xFF);
            if (s.length() == 1) {
                sb.append("0");
            }
            sb.append(s.toUpperCase());
        }
        return sb.toString();
    }

    public static String hexSHA1(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(value.getBytes("utf-8"));
            byte[] digest = md.digest();
            return byteToHexString(digest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String byteToHexString(byte[] bytes) {
        return String.valueOf(Hex.encodeHex(bytes));
    }
}
