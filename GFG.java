package top;

// Java program to solve Gold Mine problem
import java.util.Arrays;

import static java.lang.Integer.max;

class GFG {


   // Returns maximum amount of gold that
   // can be collected when journey started
   // from first column and moves allowed
   // are right, up
   static int getMaxGold(int gold[][], int m, int n)
   {

      // Create a table for storing
      // intermediate results and initialize
      // all cells to 0. The first row of
      // goldMineTable gives the maximum
      // gold that the miner can collect
      // when starts that row
      int goldTable[][] = new int[m][n];

      for (int col = n-1; col >= 0; col--)
      {
         for (int row = 0; row < m; row++)
         {
            // Gold collected on going to the cell on the right(->)
            int right = (col==n-1)? 0: goldTable[row][col+1];

            // Gold collected on going to the cell to right up (/)
            int up = (row==0)? 0: goldTable[row-1][col];

            // Max gold collected from taking either of the
            // above 3 paths
            goldTable[row][col] = gold[row][col] + max(right, up);

         }
      }

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            System.out.printf("%4d",goldTable[i][j]);

         }

         System.out.println();
      }

      // The max amount of gold collected will be
      // the max value in first column of all rows
      int res = goldTable[0][0];

      for (int i = 1; i < m; i++)
         res = Math.max(res, goldTable[i][0]);

      return res;
   }

   //driver code
   public static void main(String arg[])
   {
      int gold[][]= {
              {1, 0, 1, 5},
              {3, 20, 0, 4},
              {2, 10, 5, 2},
              {6, 3, 0, 1}
      };
   int gold2[][]= {
              {2, 5},
              {4, 1}
      };

      int m = gold.length, n = gold[0].length;

      System.out.print(getMaxGold(gold, m, n));
   }
}

// This code is contributed by Anant Agarwal.
