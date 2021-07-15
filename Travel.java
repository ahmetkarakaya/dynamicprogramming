package top;

import java.awt.*;
import java.util.Stack;

public class Travel {

   static int X_MAX;
   static int Y_MAX;


   public static void main(String[] args) {


      int[][] rocks = {
              {0, 0, 0, 0, 0, 5},
              {1, 0, 0, 2, 4, 0},
              {2, 1, 1, 3, 0, 0}
      };


      X_MAX = rocks.length;
      Y_MAX = rocks[0].length;

      System.out.println("X_MAX:" + X_MAX);
      System.out.println("Y_MAX:" + Y_MAX);

      maxRock(rocks);


   }

   static int totalMAX=0;

   static int maxRock(int[][] rocks) {

      int[][] path = {
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0}
      };

      int totalValue=0;
      Stack stack = new Stack<>();
      maxRockRec(rocks, X_MAX-1, 0, stack, path, 0);
      //return maxRockRec(rocks, max, rocks.length - 1, 0);


      System.out.println("---- Best Path -----");
      print(path);
      System.out.println("Total="+totalMAX);

      return 1;
   }



   static void maxRockRec(int[][] rocks, int x, int y,Stack stack,int[][] path , int totalValue) {


      path[x][y]=1;
      stack.push(new StepCustom(x,y, rocks[x][y]));
      totalValue+=rocks[x][y];

      //reached the buttom
      if (x == 0 && y == Y_MAX - 1) {
         System.out.println("Reached-> Total:"+totalValue);
         if(totalMAX <totalValue) {
            totalMAX = totalValue;
         }
         //print stack
         print(path);
         return;
      }

      if (x > 0) {
         maxRockRec(rocks, x-1, y,stack,path,totalValue);
         path[x-1][y]=0;
         stack.pop();
         totalValue-=rocks[x-1][y];
      }

      if (y <Y_MAX-1) {
         maxRockRec(rocks, x, y + 1,stack,path,totalValue);
         path[x][y+1]=0;
         stack.pop();
         totalValue-=rocks[x][y+1];
      }



   }

   static class StepCustom{

      private final int value;
      private int x;
      private int y;

      StepCustom(int x, int y, int value){
         this.x = x;
         this.y = y;
         this.value=value;
      }

      public int getX() {
         return x;
      }
      public int getY() {
         return y;
      }

      public int getValue() {
         return value;
      }
   }

   static void print(int [][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j <a[0].length ; j++) {
            System.out.printf("%4d",a[i][j]);
         }
         System.out.println();
      }
   }
}
