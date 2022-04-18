package com.example.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class AuthenticationService {

    @Value("${security.hash_salt}")
    private String hashSalt;

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(hashSalt.getBytes());

            byte[] passwordBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte passwordByte : passwordBytes) {
                sb.append(Integer.toString((passwordByte & 0xff) + 0x100, 16)
                        .substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }

        return "";
    }

    public boolean verifyHash(String password, String hash) {
        return Objects.equals(hashPassword(password), hash);
    }
}
