package cn.lipy.algorithms.chapter202;

import java.util.Comparator;

/**
 * Created by lipyong on 2018/11/22.
 */
public class ShellSort {
    public static  void  sort (Comparable[] a){
//        将a[]按照升序排列
        int N= a.length;
        int h=1;
        while(h<N/3) h=3*h+1;
        while (h>=1){
//            将数组变为h有序
            for (int i=h;i<N;i++)
            {
//              将a[i] 插入到a[i-h]...之中
                for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
                {
                    exch(a,j,j-h);
                }
                h=h/3;


            }
        }
        for (int i=1;i<N;i++){
//            将a[i]插入到a[i-1]。。。当中
            for (int j=i;j>0&&(less(a[j],a[j-1]));j--){
                exch(a,j,j-1);

            }
        }
    }
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }


    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}


