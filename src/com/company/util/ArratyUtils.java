package com.company.util;

public class ArratyUtils {
    public static void print(int[] array) {
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void print(boolean[] array) {
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void print2(int[][] array) {
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<array[0].length;j++) {
                printObject(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void print2(char[][] array) {
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<array[0].length;j++) {
                printObject(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void print2(double[][] array) {
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<array.length;j++) {
                printObject(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void print2(String[][] array) {
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<array.length;j++) {
                printObject(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void print2(boolean[][] array) {
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<array.length;j++) {
                printObject(array[i][j]);
            }
            System.out.println();
        }
    }

    private static void printObject(Object object) {
        if(object instanceof Integer) {
            System.out.print((int)object);
        }
        if(object instanceof String) {
            System.out.print((String)object);
        }
        if(object instanceof Boolean) {
            System.out.print((boolean) object);
        }
        if(object instanceof Double) {
            System.out.print((double) object);
        }
        System.out.print(" ");
    }
}
