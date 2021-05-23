package com.dev.java.arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] array = {11, 23, 34};

        for (int i = 0; i < array.length; i++)
        {
            System.out.println("This is array uni dimensional: " + array[i]);
        }

        int[][] matriz = {{10, 20}, {100, 200}};

        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[i].length; j++)
            {
                System.out.println("This is matriz " + i + ": " + matriz[i][j]);
            }
        }

    }
}
