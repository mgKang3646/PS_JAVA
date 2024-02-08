package org.example.implementation;

import java.io.*;
import java.util.*;
import java.util.stream.*;

//BOJ1138 한 줄로 서기
public class Impl11 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] ans = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++){
            int count = arr[i];
            for(int j=1;j<=n;j++){
                if(ans[j]==0){
                    if(count==0) {
                        ans[j] = i;
                        break;
                    }
                    else count--;
                }
            }
        }


        String result = Arrays.stream(ans,1,ans.length)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);



    }
}
