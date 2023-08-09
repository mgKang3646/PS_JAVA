package org.example.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//BOJ10930 SHA-256
public class Ds1 {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        sh.update(str.getBytes());
        byte[] bytes = sh.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x",b));
        }
        System.out.println(sb.toString());
    }
}
