package divideAndConquer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
    //     private List<Integer> list=new ArrayList<Integer>();
    public   ArrayList<Integer> init() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组的大小：");
        int num = scanner.nextInt();
        System.out.println("初始化数组：");
        for (int i = 0; i < num; i++) {
            list.add(scanner.nextInt());
        }
        return list;
    }

    public void sort(ArrayList<Integer> arrayList) {
        int i, j;
        for (i = 0; i < arrayList.size(); i++) {
            for (j = arrayList.size() - 1; j >= i; j--) {
                   if (arrayList.get(j)<arrayList.get(i)){
                       int small=arrayList.get(j);
                       Integer big= arrayList.get(i);
                       arrayList.set(i,small);
                       arrayList.set(j,big);
                   }
            }
        }

    }


    public static void main(String[] args) {
//        ArrayList<Integer> integers = new ArrayList<Integer>();
//        integers.add(2);
//        integers.add(3);
//        Integer integer = integers.get(1);
//        Integer integer1 = integers.get(0);
//        integers.set(0,99);
//        System.out.println(integers.get(0));

//
//        System.out.println(integer>integer1);
//        System.out.println(integer);
        BubbleSort bubbleSort = new BubbleSort();
        ArrayList<Integer> init = bubbleSort.init();
        bubbleSort.sort(init);
        for(Integer s : init)
            System.out.println(s);

    }


}
