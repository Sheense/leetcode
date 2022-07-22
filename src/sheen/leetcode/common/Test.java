package sheen.leetcode.common;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname Test
 * @Date 2021/8/28 5:17 下午
 * @Created by sheen
 * @Description TODO
 */
public class Test {
    public static void main(String[] args) {
        Float.compare(1.0f, 2.0f);
        Comparator<Integer> c = Comparator.comparingInt(o -> o);
        PriorityQueue<Integer> p = new PriorityQueue<>(c);
        p.offer(10);
        p.offer(1);
        p.offer(12);
        while (!p.isEmpty()) {
            System.out.println(p.poll());
        }

    }

    public boolean equals(Object o) {
        throw new AssertionError();
    }

    public static void getString(String src, String dst) {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst);
             ){
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getStringV2(String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }
}
