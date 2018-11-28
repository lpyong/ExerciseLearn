package cn.lipy.algorithms.chapter202;

import java.util.Comparator;

/**
 * Created by lipyong on 2018/11/22.
 */
public class MergeBU {
    private static Comparable[] aux;
    public static  void sort(Comparable[] a)
    {
        //进行lgN次两两归并
        int N =a.length;
        aux = new Comparable[N];
        for(int sz = 1;sz<N;sz = sz+sz)//sz子数组的大小
        {
           for (int lo = 0;lo< N-sz;lo+=sz+sz) {
               merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
           }
        }

    }
    public static  void  merge(Comparable[] a,int lo ,int mid , int hi ) {
//     将a[lo..mid] 和 a[mid..hi]归并
        int i = lo;
        int j = mid + 1;

//       将a数组复制为aux数组
        for(int k =lo;k<=hi;k++)
        {
            aux[k]=a[k];
        }
        for (int k=lo;k<=hi;k++){
            if (i>mid) a[k]=aux[j++];
            else if (j>hi) a[k]=aux[i++];
            else if (less(aux[j],a[i])) a[k]=aux[j++];
            else                      a[k] =aux[i++];
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
}
