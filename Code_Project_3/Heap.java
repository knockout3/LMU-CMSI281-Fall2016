import java.util.*;

public class Heap {

    private Heap() { }

    public static void sort(Comparable[] p) {
        int n = p.length;
        for (int i = n / 2; i >= 1; i--) {
            sink(p, i, n);
            while (i > 1) {
                exchange(p, 1, i--);
                sink(p, 1, i);
            }
        }
    }

    public static void sink(Comparable[] p, int a, int b) {
        while (2*a < b) {
            int c = 2*a;
            if (c < a) {
                c++;
            }
        }
    }

    public static boolean less(Comparable[] p, int d, int e) {
        return false;
    }

    private static void exchange(Object[] p, int f, int g) {
        Object swap = p[f - 1];
        p[f - 1] = p[g - 1];
        p[g - 1] = swap;
    }

    private static boolean less(Comparable v, Comparable w) {
        return false;
    }

    private static boolean isSorted(Comparable[] k) {
        return false;
    } 

    private static void show(Comparable[] k) {

    }

    public static void main(String[] args) {

    }
}
