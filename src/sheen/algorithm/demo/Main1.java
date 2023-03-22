package sheen.algorithm.demo;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Main1
 * @Date 2023/3/5 12:03 下午
 * @Created by sheen
 * @Description TODO
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] next = null;
        if(scanner.hasNext()) {
            next = new String(scanner.nextLine().getBytes(StandardCharsets.UTF_8)).split(",");
        }
        String[] indexs = new String[next.length];
        for(int i = 0; i < next.length; i++) {
            String[] v = next[i].split(" ");
            int start = Integer.parseInt(v[0]);
            int end = Integer.parseInt(v[1]);
            indexs[i] = text.substring(start, end + 1);
        }

        String newText = "";
        int i = 0;
        while (i < text.length()) {
            if(text.charAt(i) == ' ') {
                newText += ' ';
                while (i < text.length() && text.charAt(i) == ' ') {
                    i++;
                }
            }else if(text.charAt(i) == '\'') {
                newText += text.charAt(i++);
                while (i < text.length() && text.charAt(i) != '\'') {
                    newText += text.charAt(i++);
                }
                newText += text.charAt(i++);
            }else {
                newText += text.charAt(i++);
            }
        }

        System.out.println(newText);
        int[][] list = new int[indexs.length][2];
        for(int j = 0; j < indexs.length; j++) {
            int start = newText.indexOf(indexs[j]);
            list[j][0] = start;
            list[j][1] = start + indexs[j].length() - 1;
        }

        print(list);

    }

    public static void print(int[][] arr) {
        if(arr.length == 0) {
            System.out.println("[[]]");
            return;
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            String item = "[";
            for(int j = 0; j < arr[i].length; j++) {
                item += arr[i][j];
                if(j != arr[i].length - 1) {
                    item += ", ";
                }
            }
            item += "]";
            res.add(item);
        }

        String print = "";
        for(int i = 0; i < res.size(); i++) {
            print += res.get(i);
        }
        print += "";
        System.out.println(print);
    }
}
