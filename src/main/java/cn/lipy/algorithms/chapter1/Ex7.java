package main.java.cn.lipy.algorithms.chapter1;
import edu.princeton.cs.algs4.StdIn;
/**
 * Created by lipyong on 2018/11/20.
 */
public class Ex7 {
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) {
            return s;
        }
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        System.out.println(mystery(StdIn.readLine()));
    }
}
