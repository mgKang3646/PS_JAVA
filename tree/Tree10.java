package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//BOJ1068 트리
public class Tree10 {
    static List<Integer>[] tree;
    static boolean[] deleted;
    static int deletedNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new List[n];
        deleted = new boolean[n];

        for(int i=0;i<tree.length;i++){
            tree[i] = new ArrayList<>();
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) root = i;
            else tree[parent].add(i);
        }


        deletedNode = Integer.parseInt(br.readLine());

        searchTree(root,false);

        int ans = 0;
        for(int i=0;i<n;i++){
            if(deleted[i]) continue;

            if(tree[i].size()==0) ans++;
            else{
                boolean isLeaf = true;
                for(int nextNode : tree[i]){
                    if(!deleted[nextNode]) {
                        isLeaf = false;
                        break;
                    }
                }
                if(isLeaf) ans++;
            }
        }

        System.out.println(ans);


    }


    public static void searchTree(int node, boolean isDeleted ){

        if(node == deletedNode) isDeleted = true;

        deleted[node] = isDeleted;

        for(int nextNode : tree[node]){
            searchTree(nextNode,isDeleted);
        }
    }
}

