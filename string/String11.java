package org.example.string;

import java.util.Scanner;

public class String11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int idx = Integer.parseInt(sc.next());

        System.out.println(str.charAt(idx-1));
    }
}
