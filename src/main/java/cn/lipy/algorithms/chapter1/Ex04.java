package cn.lipy.algorithms.chapter1;
import edu.princeton.cs.algs4.StdOut;
/**
 * Created by lipyong on 2018/11/20.
 */
public class Ex04 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}

