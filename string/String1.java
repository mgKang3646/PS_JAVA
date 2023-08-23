package org.example.string;


import java.util.Scanner;

//BOJ165000 문자열 판별
public class String1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            String a = sc.next();
            s = removeValueInTarget(s, a);
        }

        if(s.length() == 0) System.out.println(1);
        else System.out.println(0);

    }


    public static String removeValueInTarget(String target, String value){
        int targetP = 0;
        int valueP = 0;

        for(int i=0;i<target.length();i++){
            if(target.charAt(i) == value.charAt(valueP)){
                targetP = i + 1;
                valueP += 1;
                while( targetP < target.length() && valueP < value.length()){
                    if(target.charAt(targetP) != value.charAt(valueP)) break;
                    if(valueP == value.length()-1){
                        return target.substring(0,i) + target.substring(targetP+1);
                    }
                    targetP++;
                    valueP++;
                }
                targetP =0;
                valueP = 0;
            }

        }

        return target;
    }
}
