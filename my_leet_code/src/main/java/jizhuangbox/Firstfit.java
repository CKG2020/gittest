package jizhuangbox;

public class Firstfit {
    public static void main(String[] args) {
        int n = 5;  //货物数
        int  C = 10; // 集装箱容量
        int  k=0; //所需要集装箱的数量
        int b[] = new int[10];  //表示当前每个集装箱已经装入货物的体积
        int s[]={4,2,7,3,5}; //每个货物的体积
        int j ;
        int i=0;
        for (i = 0;i<n;i++) {
//待填写
            j=0;
            while (C-b[j]<s[i]){
                j++;
            }
            b[j]+=s[i];
            //待填写
            k=k>(j+1)?k:(j+1);
        }
        System.out.println(k);


//            while(b[i]>=s[j]){
//                b[i]-=s[j];
//                j++;
//            }

    }
}
