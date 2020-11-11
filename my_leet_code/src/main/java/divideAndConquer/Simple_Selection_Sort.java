package divideAndConquer;

import java.util.ArrayList;
import java.util.Scanner;
//简单选择排序
public class Simple_Selection_Sort {
    public ArrayList<Integer> init() {
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

    public void sort(ArrayList<Integer> list) {
        int i, j, min;
        for (i = 0; i < list.size(); i++) {
            min = i;
            for (j = i + 1; j < list.size(); j++) {
                if (list.get(min) > list.get(j)) {
                    min = j;
                }
            }
            if (i != min) {
                Integer big= list.get(i);
                Integer small = list.get(min);
                list.set(min,big);
                list.set(i, small);
            }
        }

    }

    public static void main(String[] args) {
        Simple_Selection_Sort sort = new Simple_Selection_Sort();
        ArrayList<Integer> init = sort.init();
        sort.sort(init);
        for (Integer s:init){
            System.out.println(s);
        }
    }
}
