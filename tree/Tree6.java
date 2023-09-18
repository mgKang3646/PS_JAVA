package org.example.tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

//BOJ3584 가장 가까운 공통 조상
public class Tree6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int root = 0;

        while(t-- > 0){

            int n = Integer.parseInt(br.readLine());
            int[] parents = new int[n+1];

            // STEP1) 부모 테이블 만들기
            StringTokenizer st;
            for(int i=0;i<n-1;i++){
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                parents[c] = p;
            }

            st = new StringTokenizer(br.readLine());


            // STEP2) 루트 찾기
            for(int i=1;i<=n;i++){
                if(parents[i] == 0){
                    root = i;
                    break;
                }
            }

            // STEP3) While문에 While문을 넣어 공통부모 찾기
            int child1 = Integer.parseInt(st.nextToken());
            int child2 = Integer.parseInt(st.nextToken());

            int parent1 = child1;
            int parent2 = child2;
            boolean flag = false;
            int ans = 0;

            while(parent1 != root){
                int tmpParent2= parent2;
                int tmpChild2 = child2;

                while(tmpParent2 != root ){
                    if(parent1 == tmpParent2){
                        flag = true;
                        break;
                    }else{
                        tmpParent2 = parents[tmpChild2];
                        tmpChild2 = tmpParent2;
                    }
                }

                if(flag){
                    ans = parent1;
                    break;
                }else{
                    parent1 = parents[child1];
                    child1 = parent1;
                }
            }

            if(flag) System.out.println(ans);
            else System.out.println(root);

        }
    }
}
