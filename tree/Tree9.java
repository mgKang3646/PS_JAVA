package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ1991 트리순회
public class Tree9 {

    public static class Node{

        int leftNode;
        int rightNode;

        boolean isRoot = true;

        public Node(int leftNode,int rightNode){
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    static Node[] tree;
    static final int LENGTH = 'Z'-'A'+1;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new Node[LENGTH];
        boolean[] isRoot = new boolean[LENGTH];

        Arrays.fill(isRoot,true);

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int node = getNodeIndex(st.nextToken().charAt(0));

            char leftChar = st.nextToken().charAt(0);
            char rightChar = st.nextToken().charAt(0);
            int leftNode = (leftChar != '.')? getNodeIndex(leftChar) : -1;
            int rightNode = (rightChar != '.')? getNodeIndex(rightChar) : -1;

            if(leftNode != -1) isRoot[leftNode] = false;
            if(rightNode != -1 ) isRoot[rightNode] = false;

            tree[node] = new Node(leftNode,rightNode);
        }

        int root = -1;
        for(int i=0;i<LENGTH;i++){
            if(tree[i] != null && isRoot[i]){
                root = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        sb.append("\n");
        inOrder(root,sb);
        sb.append("\n");
        postOrder(root,sb);

        System.out.println(sb.toString());

    }

    // 전위순회 : root->왼쪽->오른쪽
    public static void preOrder(int parent, StringBuilder sb){
        sb.append(String.valueOf(getNodeChar(parent)));
        if(tree[parent].leftNode != -1 ) preOrder(tree[parent].leftNode,sb);
        if(tree[parent].rightNode != -1 ) preOrder(tree[parent].rightNode,sb);

    }

    // 중위순회 : 왼쪽 -> root -> 오른쪽
    public static void inOrder(int parent, StringBuilder sb){
        if(tree[parent].leftNode != -1 ) inOrder(tree[parent].leftNode,sb);
        sb.append(String.valueOf(getNodeChar(parent)));
        if(tree[parent].rightNode != -1 ) inOrder(tree[parent].rightNode,sb);
    }

    // 후위순회 : 왼쪽 -> 오른쪽 -> root
    public static void postOrder(int parent,StringBuilder sb){
        if(tree[parent].leftNode != -1 ) postOrder(tree[parent].leftNode,sb);
        if(tree[parent].rightNode != -1 ) postOrder(tree[parent].rightNode,sb);
        sb.append(String.valueOf(getNodeChar(parent)));
    }

    public static int getNodeIndex(char node){
        return node-'A';
    }

    public static char getNodeChar(int idx){
        return (char)(idx+'A');
    }
}




