package org.example.hash;

import java.io.*;
import java.util.*;

//BOJ1620 나는야 포켓몬 마스터 이다솜
public class Hash2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer,String> pBookInt = new HashMap<>();
        HashMap<String,Integer> pBookString = new HashMap<>();


        for(int i=1;i<=n;i++){
            String name = br.readLine();
            pBookInt.put(i,name);
            pBookString.put(name,i);
        }

        for(int i=0;i<m;i++){
            String input = br.readLine();
            char c = input.charAt(0);

            if(c>='1'&&c<='9') {
                int value = Integer.parseInt(input);
                System.out.println(pBookInt.get(value));
            }else{
                System.out.println(pBookString.get(input));
            }
        }
    }
}
