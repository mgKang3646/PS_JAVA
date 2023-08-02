package org.example.fenwicktree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ3653 영화 수집
public class Ft2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String[] dvds = br.readLine().split(" ");
            int[] pos = new int[n+1];
            FenwickTree fenwickTree = new FenwickTree(n+m+1);

            for(int i=1;i<=n;i++){
                pos[i] = i + m;
                fenwickTree.update(pos[i],1);
            }

            for(int i=0;i<m;i++){
                int index = Integer.parseInt(dvds[i]);
                sb.append(fenwickTree.sum(pos[index]-1)).append(" ");
                fenwickTree.update(pos[index],-1);
                pos[index] = m - i;
                fenwickTree.update(pos[index],1);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static class FenwickTree{
        private int[] tree;

        public FenwickTree(int size){
            tree = new int[size];
        }

        public int sum(int index){
            int ans = 0;
            while(index>0){
                ans += tree[index];
                index -= ( index & -index );
            }
            return ans;
        }

        public void update(int index, int value){
            while(index < tree.length){
                tree[index] += value;
                index += ( index & -index);

            }
        }
    }
}
