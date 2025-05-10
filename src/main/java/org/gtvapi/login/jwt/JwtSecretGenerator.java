package org.gtvapi.login.jwt;

import java.security.SecureRandom;
import java.util.Base64;

public class JwtSecretGenerator {
    public static void main(String[] args) {
        // JWT secret için 64 byte uzunluğunda güvenli rastgele bir veri üret
        SecureRandom secureRandom = new SecureRandom();
        byte[] secretBytes = new byte[64]; // 64 byte uzunluğunda
        secureRandom.nextBytes(secretBytes);

        // Byte dizisini Base64 formatına çevir
        String jwtSecret = Base64.getEncoder().encodeToString(secretBytes);

        // Sonucu ekrana yazdır
        System.out.println("Generated JWT Secret: " + jwtSecret);
    }
}

