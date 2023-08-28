package org.example.string;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//BOJ2608 로마숫자
public class String3 {
    static Map<String,Integer> RomeToNumMap = new HashMap<>();
    static Map<Integer,String> NumToRomeMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        String value1 = br.readLine();
        String value2 = br.readLine();

        int num1 = convertRomeNumToDecimal(value1);
        int num2 = convertRomeNumToDecimal(value2);

        int sum = num1 + num2;
        String ans = convertDecimalToRomeNum(sum);

        System.out.println(sum);
        System.out.println(ans);

    }


    public static void init(){
        // 로마숫자 -> 십집법 Map 자료구조
        RomeToNumMap.put("I",1);
        RomeToNumMap.put("V",5);
        RomeToNumMap.put("X",10);
        RomeToNumMap.put("L",50);
        RomeToNumMap.put("C",100);
        RomeToNumMap.put("D",500);
        RomeToNumMap.put("M",1000);
        RomeToNumMap.put("IV",4);
        RomeToNumMap.put("IX",9);
        RomeToNumMap.put("XL",40);
        RomeToNumMap.put("XC",90);
        RomeToNumMap.put("CD",400);
        RomeToNumMap.put("CM",900);

        // 십진법 숫자 -> 로마숫자 Map 자료구조
        NumToRomeMap.put(1,"I");
        NumToRomeMap.put(5,"V");
        NumToRomeMap.put(10,"X");
        NumToRomeMap.put(50,"L");
        NumToRomeMap.put(100,"C");
        NumToRomeMap.put(500,"D");
        NumToRomeMap.put(1000,"M");
        NumToRomeMap.put(4,"IV");
        NumToRomeMap.put(9,"IX");
        NumToRomeMap.put(40,"XL");
        NumToRomeMap.put(90,"XC");
        NumToRomeMap.put(400,"CD");
        NumToRomeMap.put(900,"CM");
    }

    // 로마숫자를 십진법 숫자로 변경
    public static int convertRomeNumToDecimal(String romeNum){
        int decimal = 0;
        String before = null;

        for(int i =0; i<romeNum.length();i++){
            String curr = String.valueOf(romeNum.charAt(i));

            if(before == null) before = curr; // 이전문자가 null인 경우
            else if(RomeToNumMap.get(before) >= RomeToNumMap.get(curr)) { // 이전문자가 현재문자보다 큰 경우
                decimal += RomeToNumMap.get(before);
                before = curr;
            }else{
                decimal += RomeToNumMap.get(before.concat(curr)); // 이전문자가 현재문자보다 작은 경우
                before = null;
            }
        }

        if(before != null ){ // 마지막 문자
            decimal += RomeToNumMap.get(before);
        }

        return decimal;
    }

    // 십진법 숫자를 로마 숫자로 변경
    public static String convertDecimalToRomeNum(int decimal){
        String ans = "";
        int digit = 1000;

        while(true){
            int m = decimal/digit;
            decimal -= m*digit;

            ans = convert(ans,m,digit);
            if(digit==1) break;
            digit = digit/10;
        }

        return ans;
    }

    // 각 자리수에 맞는 로마숫자로 변경
    private static String convert(String ans, int m, int digit) {
        if( m == 9 ) ans += NumToRomeMap.get(9*digit);
        else if( m == 4 ) ans += NumToRomeMap.get(4*digit);
        else if ( m >= 5 ) {
            m -= 5;
            ans += NumToRomeMap.get(5*digit);
            while(m-- > 0){
                ans += NumToRomeMap.get(digit);
            }
        }
        else{
            while(m-- > 0){
                ans += NumToRomeMap.get(digit);
            }
        }
        return ans;
    }
}
