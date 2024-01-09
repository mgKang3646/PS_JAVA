package org.example.string;

import java.io.*;

// BOJ4659 비밀번호 발음하기
// 모음이 반드시 한 개 이상 오고, 모음과 자음이 3연속 하면 안되고 같은 문자는 연속할 수 없지만 ee나 oo는 가능한 패스워드인지 분석하라.
public class String14 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        while(!str.equals("end")){
            if(isValid(str)){
                sb.append("<"+str+"> is acceptable.").append("\n");
            }else{
                sb.append("<"+str+"> is not acceptable.").append("\n");
            }

            str = br.readLine();
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    public static boolean isValid(String str){

        char beforeChar = 'A';
        int sequence = 0;
        int vowelCount = 0;

        for(int i=0;i<str.length();i++){

            char ch = str.charAt(i);
            if(isVowel(ch)) vowelCount++;
            if(isVowel(beforeChar) == isVowel(ch)){
                if(sequence >= 2){
                    return false;
                }
                sequence++;
            }else{
                sequence=1;
            }

            if(beforeChar==ch && ( ch!='e' && ch != 'o')){
                return false;
            }

            beforeChar = ch;
        }

        if(vowelCount == 0) {
            return  false;
        }else{
            return true;
        }
    }

    public static boolean isVowel(char ch){
        return ( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) ? true : false;
    }



}
