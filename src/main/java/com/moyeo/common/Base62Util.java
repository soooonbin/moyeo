package com.moyeo.common;

public class Base62Util {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generate(Long id, String originalUrl) {
        StringBuilder sb = new StringBuilder();
        long sum = id;  // DB에서 가져온 PK 값으로 시작
/*
        byte[] urlBytes = originalUrl.getBytes(StandardCharsets.UTF_8);
        for (byte b : urlBytes) {
            sum += b;
        }

        // 62진수 변환
        while (sum > 1) {
            sb.append(BASE62.charAt((int)(sum % 62)));
            sum /= 62;
        }

        // 길이 맞추기
        if (sb.length() > 8) {
            return sb.substring(0, 8);
        } else if (sb.length() < 8) {
            Random random = new Random();
            while (sb.length() < 8) {
                sb.append(BASE62.charAt(random.nextInt(62)));
            }
            return sb.toString();
        } else {
            return sb.toString();
        }*/
        return "";
    }
}
