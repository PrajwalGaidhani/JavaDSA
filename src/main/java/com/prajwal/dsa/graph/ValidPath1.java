package com.prajwal.dsa.graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a rectangle with left bottom as (0, 0) and right up as (x, y).
 *
 * There are N circles such that their centers are inside the rectangle.
 *
 * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 *
 * Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 */



public class ValidPath1 {

    // mark all the the cell inside any circle as 1
    // normal graph traveral
    // note we have 8 direction
    public static final int[][] dir={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    public boolean bfs(int[][] matrix,int i,int j){
        if(matrix[i][j]==1){return false;}
        if(i==matrix.length-1 && j==matrix[0].length-1){
            return true;
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{i,j});
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            int x=temp[0];
            int y=temp[1];
            if(x==matrix.length-1 && y==matrix[0].length-1){
                return true;
            }
            for(int[] d:dir){
                int newx=x+d[0];
                int newy=y+d[1];
                if(newx>=0 && newy>=0
                        && newx<matrix.length && newy<matrix[0].length
                        && matrix[newx][newy]==0){
                    matrix[newx][newy]=1;
                    queue.offer(new int[]{newx,newy});

                }
            }
        }
        return false;
    }

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[][] matrix=new int[A+1][B+1];
        for(int[] t:matrix){
            Arrays.fill(t,0);
        }
        for(int i=0;i<C;i++){
            int x=E[i];
            int y=F[i];
            for(int j=0;j<=A;j++){
                for(int k=0;k<=B;k++){
                    // Euclidean distance check
                    if ((j - x)*(j - x) + (k - y)*(k - y) <= D*D) {
                        matrix[j][k] = 1; // Mark as blocked

                    }
                }
            }
        }
        if(bfs(matrix,0,0)){
            return "YES";
        }
        return "NO";
    }
}
