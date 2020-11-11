package divideAndConquer;

import java.util.ArrayList;
import java.util.Scanner;
//直接插入排序 玩扑克牌
public class Straight_Insertion_Sort {

    public static void sort(int a[]) {
        int i, j;
        for (i = 2; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                a[0] = a[i];
                for (j = i - 1; a[j] > a[0]; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = a[0];
            }

        }
        a[0]=0;
        for (Integer s : a) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        int a[] = {0,1, 5, 2,55,88,99,54,12,64,75,62};
        sort(a);
    }
}
