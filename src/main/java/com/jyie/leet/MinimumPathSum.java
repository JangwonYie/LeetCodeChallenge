package com.jyie.leet;

/**
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 *
 * Created by Jangwon Yie on 7/20/17.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSum(0,0, grid, memo);
    }

    private int minPathSum(int i, int j, int[][] grid, int[][] memo){
        int x = grid.length;
        int y = grid[0].length;

        int goRight;
        if(i + 1 >= x)
            goRight = -1;
        else{
            if(memo[i+1][j] == 0){
                memo[i+1][j] = minPathSum(i+1, j, grid, memo);
                goRight = memo[i+1][j];
            }else
                goRight = memo[i+1][j];
        }


        int goDown;
        if(j + 1 >= y)
            goDown = -1;
        else{
            if(memo[i][j+1] == 0){
                memo[i][j+1] = minPathSum(i, j+1, grid, memo);
                goDown = memo[i][j+1];
            }else
                goDown = memo[i][j+1];
        }

        if(goRight == -1 && goDown == -1)
            return grid[i][j];

        if(goRight > -1 && goDown > -1){
            if(goRight < goDown)
                return grid[i][j] + goRight;
            else
                return grid[i][j] + goDown;
        }

        if(goRight == -1)
            return grid[i][j] + goDown;
        return grid[i][j] + goRight;
    }

}
