package cn.lipy.algorithms.chapter103;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by lipyong on 2018/11/28.
 */
public class Ex111
{
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if (s.equals("(") || s.equals(")")) ;
            else if (s.equals("+") ||
                      s.equals("-") ||
                      s.equals("*")||
                      s.equals("/")||
                      s.equals("sqrt"))
            {
                double val = vals.pop();
                if (s.equals("+")) val = vals.pop() + val;
                else if (s.equals("-")) val = vals.pop() - val;
                else if (s.equals("*")) val = vals.pop() * val;
                else if (s.equals("/")) val = vals.pop() / val;
                else if (s.equals("sqrt")) val = Math.sqrt(val);

                vals.push(val);
            }
            else
                 vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
