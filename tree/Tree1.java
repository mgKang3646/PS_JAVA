package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ2250 트리의 높이와 너비
public class Tree1 {

    static Node[] nodes; // 노드 테이블
    static Level[] levels; // 레벨 테이블

    static int nodePointer = 1; // 가로축 포인터 ( 1 ~ n )
    static int n ;
    static int root;
    public static class Node{
        int parent; // 노드의 부모
        int left; // 노드의 왼쪽 자식
        int right; // 노드의 오른쪽 자식

    }
    public static class Level{
        int leftEnd = n; // 가로축 좌측끝 수
        int rightEnd = 0; // 가로축 우측끝 수
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nodes = new Node[n+1];
        levels = new Level[n+1];

        // 노드, 레벨 테이블 객체생성
        for(int i=1;i<=n;i++){
            nodes[i] = new Node();
            levels[i] = new Level();
        }

        // 노드 테이블 초기화
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            nodes[parent].left = left;
            nodes[parent].right = right;
            if(left != -1) nodes[left].parent = parent;
            if(right != -1) nodes[right].parent = parent;
        }

        // 루트 탐색
        for(int i=1;i<=n;i++){
            if(nodes[i].parent==0){
                root = i;
                break;
            }
        }

        // 중위순회 시작
        inorder(root,1);

        // 너비가 최대인 레벨 탐색
        int maxCount = 0;
        int maxLevel = 0;
        for(int i=1;i<=n;i++){
            int count = levels[i].rightEnd - levels[i].leftEnd + 1; // 너비 구하기
            if( count > maxCount ){
                maxCount = count;
                maxLevel = i;
            }
        }
        System.out.println(maxLevel+" "+maxCount); // 출력
    }


    // 중위 순회
    public static void inorder(int root, int level){
        Node currNode = nodes[root]; // 현재 탐색 중인 중간노드

        //왼쪽 서브트리 탐색
        if(currNode.left != -1){
            inorder(currNode.left,level+1);
        }

        // 중간노드의 왼쪽서브트리 탐색이 완료되면
        // 레벨의 가로축 좌측끝, 우측끝 데이터 세팅
        // 왼쪽서버트리 탐색을 완료한 상태의 가로축 포인터를 이용.
        levels[level].leftEnd = Math.min(levels[level].leftEnd, nodePointer); // 가로축 포인터가 가리키는 수와 현재 레벨의 좌측끝 가로축 수 비교
        levels[level].rightEnd = nodePointer++; // 좌측 -> 우측 탐색이므로 현재 탐색 중인 노드가 가장 우측끝

        // 오른쪽 서브트리 탐색
        if(currNode.right != -1){
            inorder(currNode.right,level+1);
        }
    }
}
