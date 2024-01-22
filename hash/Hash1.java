package org.example.hash;

import java.io.*;
import java.util.*;

//BOJ7785 회사에 있는 사람
public class Hash1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String,String> map = new HashMap<>();

        StringTokenizer st;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();

            if(command.equals("enter")){
                map.put(name,command);
            }
            else if(command.equals("leave")){
                map.remove(name);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String name : list){
            sb.append(name).append("\n");
        }

        System.out.println(sb.toString());


    }
}
