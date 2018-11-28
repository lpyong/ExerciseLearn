package cn.lipy.algorithms.chapter103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Created by lipyong on 2018/11/28.
 */
public class Ex104 {
    public static boolean isBalanced(String s){
        Stack<Character> open = new Stack<Character>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if (c=='('||c=='['||c=='{'){
                open.push(c);
            }
           else if ((c==')'&&(open.isEmpty()||open.pop()!=')'))||
                    (c==']'&&(open.isEmpty()||open.pop()!=']'))||
                    (c=='}'&&(open.isEmpty()||open.pop()!='}'))){
                    return false;
            }

        }
        return open.isEmpty();
    }
    public static void main(String[] args)
    {
        String s = StdIn.readAll().trim();

        StdOut.println(isBalanced(s));
    }
}
