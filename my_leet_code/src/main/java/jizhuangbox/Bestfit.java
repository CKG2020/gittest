package jizhuangbox;

public class Bestfit {
    public static void main(String[] args) {
        int min,m,temp;
        int n = 5;  //货物数
        int  C = 10; // 集装箱容量
        int  k=0; //所需要集装箱的数量
        int b[] = new int[10];  //表示当前每个集装箱已经装入货物的体积
        int s[]={4,2,7,3,5}; //每个货物的体积
        int j ;
        int i=0;

        //  i j min m temp  k=0
        for ( i = 0; i <n ; i++) {
            min=C;
            m=k+1;
            for ( j = 0; j <k+1 ; j++) {
                temp=C-b[j]-s[i];
                if (temp>0&&temp<min){
                    //待填写

                    m=j;
            }
        }
 //待填写

            k=k>(m+1)?k:(m+1);
        }
        System.out.println(k);
    }

}
