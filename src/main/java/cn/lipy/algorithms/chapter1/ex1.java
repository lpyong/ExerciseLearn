package cn.lipy.algorithms.chapter1;


import edu.princeton.cs.algs4.Point2D;
/**
 * Created by lipyong on 2018/11/20.
 */
public class ex1 {
    //    public class Ex01 {
//        public static void main(String[] args) {
//            int N = Integer.parseInt(args[0]);
//            Point2D[] points = new Point2D[N];
//            for (int i = 0; i < N; i++) {
//                points[i] = new Point2D(Math.random(), Math.random());
//                points[i].draw();
//            }
//            if (N > 1) {
//                double min = points[0].distanceTo(points[1]);
//                for (int i = 0; i < N - 1; i++) {
//                    for (int j = i + 1; j < N; j++) {
//                        if (points[i].distanceTo(points[j]) < min) {
//                            min = points[i].distanceTo(points[j]);
//                        }
//                    }
//                }
//                System.out.println("Min distance: " + min);
//            }
//        }
//    }
    public static void main(String[] args) {
        int N = Integer.parseInt("6");
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point2D(Math.random(), Math.random());
            points[i].draw();
        }
        if (N > 1) {
            double min = points[0].distanceTo(points[1]);
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (min > points[i].distanceTo(points[j])) {
                        min = points[i].distanceTo(points[j]);
                    }
                }
            }
            System.out.println("Min distance: " + min);
        }

    }
}
