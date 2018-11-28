package cn.lipy.algorithms.chapter202;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lipyong on 2018/11/22.
 * 自定向下的归并排序
 */
public class MergeSort {

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
    public static Comparable[] aux;  //归并所需的辅助数组
    public  static  void sort(Comparable[] a)
    {
        aux =new Comparable[a.length];//一次性分配空间
        sort(a,0,a.length-1);

    }
    private  static  void sort(Comparable[] a,int lo,int hi)
    {
        //将数组a[lo..hi]排序
        if(hi<=lo) return ;
        int mid = lo + (hi - lo) / 2;
        sort(a,lo,mid);              //将左半边排序
        sort(a, mid + 1, hi);   //将右半边排序
        merge(a, aux, lo, mid, hi); //归并结果
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
