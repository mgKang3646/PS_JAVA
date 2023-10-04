package org.example.tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//BOJ4256 트리
public class Tree7 {

    public static int[] preorder, inorder;
    public static List<Integer> postorder;
    public static int pointer, n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            preorder = new int[n];
            inorder = new int[n];
            postorder = new ArrayList<>();
            pointer = 0;

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int i =0;i<n;i++){
                preorder[i] = Integer.parseInt(st1.nextToken());
                inorder[i] = Integer.parseInt(st2.nextToken());
            }

            dfs(0,n-1,0);

            for (Integer integer : postorder) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

    }

    public static void dfs(int start, int end, int rootIndex){

        if( rootIndex >= n ) {
            return;
        }

        int parent = preorder[rootIndex];

        for(int i=start;i<=end;i++){
            if( parent == inorder[i]){
                dfs(start,i,rootIndex+1);
                dfs(i+1,end, rootIndex+i+1-start);
                postorder.add(parent);
                return;
            }
        }



    }








}
