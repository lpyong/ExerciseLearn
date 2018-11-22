package cn.lipy.algorithms.chapter202;

import java.util.Comparator;

/**
 * Created by lipyong on 2018/11/22.
 * 选择排序 选出做小的放在首个位置
 *
 */

public class SelectSort {
    public static  void  sort (Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[i])) min = j; //最小元素的索引
                exch(a, i, min);

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


