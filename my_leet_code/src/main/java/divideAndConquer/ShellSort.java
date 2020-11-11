package divideAndConquer;

public class ShellSort {
    public     void shellSort(int a[]){
        int i,temp;
        int incr=a.length;
        do {
            incr=incr/3+1;
            for ( i = incr+1; i <a.length ; i++) {
                if (a[i]<a[i-incr]) {
                    temp = a[i];
                    a[i]=a[i-incr];
                    a[i-incr]=temp;
                }
            }
        }while(incr>1);
        for(Integer x:a){
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        int a[]={14,52,31,10,2};
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(a);
//        shellSort(a);

    }
}
