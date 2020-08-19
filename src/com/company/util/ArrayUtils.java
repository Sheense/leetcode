package com.company.util;

import com.company.common.ListNode;
import java.util.List;
public class ArrayUtils {
    public static void print2(List<List<Integer>> array) {
        for(List<Integer> list : array){
            for(int i : list){
                System.out.println(i+' ');
            }

            System.out.println();
        }
    }

    public static void print(double[] array) {
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void print(String[] array) {
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

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
            for(int j=0;j<array[i].length;j++) {
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
        if(object instanceof Character) {
            System.out.print((char)object);
        }
        System.out.print(" ");
    }

    public static ListNode getNodeList(int... values) {
        if(values.length==0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode now = head;
        for(int i=1;i<values.length;i++) {
            now.next = new ListNode(values[i]);
            now = now.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        while(head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static void print(List list) {
        for(Object v : list){
            printObject(v);
        }
    }

}
