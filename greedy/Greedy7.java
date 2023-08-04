package org.example.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

//BOJ10610 30 ( 메모리 초과 발생 )
public class Greedy7 {

    static Integer[] nums;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        nums = new Integer[charArray.length];
        visited = new boolean[charArray.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = charArray[i] - '0';
        }
        Arrays.sort(nums, Collections.reverseOrder());

        if(nums[nums.length-1] != 0){
            System.out.println(-1);
        }
        else{
            int ans = 0;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]==0) break;
                visited[i] = true;
                ans = dfs(nums[i]+"",1);
                if(ans > 0) {
                    System.out.println(ans+""+"0");
                    return;
                }
                visited[i] = false;
            }
            System.out.println(-1);
        }
    }

    public static int dfs(String str1, int depth){
        if(depth == nums.length-1){
            int ans = Integer.parseInt(str1);
            if(ans%3==0) return ans;
            else return -1;
        }

        for(int i=0;i<nums.length-1;i++) {
            if (!visited[i]) {
                visited[i] = true;
                String tmp = str1 + nums[i];
                int value = dfs(tmp, depth + 1);
                if ( value > 0) return value;
                visited[i] = false;
            }
        }
        return -1;
    }
}
