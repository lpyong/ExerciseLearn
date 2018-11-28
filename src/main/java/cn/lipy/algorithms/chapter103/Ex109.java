package cn.lipy.algorithms.chapter103;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by lipyong on 2018/11/28.
 */
public class Ex109 {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")||s.equals(")")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                String val = vals.pop();
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    val = String.format("( %s %s %s )", vals.pop(), op, val);
                } else if (op.equals("sqrt")) {
                    val = String.format("( %s %s )", op, val);

                    vals.push(val);
                } else vals.push(s);
            }
            StdOut.println(vals.pop());
        }
    }
}



