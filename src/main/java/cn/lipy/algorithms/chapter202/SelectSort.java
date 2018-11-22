package cn.lipy.algorithms.chapter202;

import java.util.Comparator;

/**
 * Created by lipyong on 2018/11/22.
 */
public class SelectSort {
    public static  void  sort (Comparable[] a){
        int N= a.length;
        for (int i=1;i<N;i++){
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

}
