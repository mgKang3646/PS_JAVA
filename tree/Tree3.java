package org.example.tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//BOJ1068 트리
public class Tree3 {

    static List<Integer>[] tree;
    static boolean[] deleted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new List[n];
        deleted = new boolean[n];

        for(int i=0;i<n;i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 트리 구성하기
        for(int i=0;i<n;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1) tree[parent].add(i);
        }

        // 삭제 로직
        int deleteNode = Integer.parseInt(br.readLine());
        deleteTree(deleteNode);

        // 리프노드 카운트
        int leafNodeCount = 0;
        for(int i=0;i<n;i++){
            if(deleted[i]) continue;
            if(isLeafNode(i)) leafNodeCount++;
        }

        //출력
        System.out.println(leafNodeCount);


    }

    public static void deleteTree(int node){
        if(deleted[node]) return;

        deleted[node] = true;
        for (Integer child : tree[node]) {
            deleteTree(child);
        }
    }

    public static boolean isLeafNode(int node) {
        for (Integer child : tree[node]) {
            if (deleted[child] == false) return false;
        }
        return true;
    }

}
