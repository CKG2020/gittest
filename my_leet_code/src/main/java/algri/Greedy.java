package algri;

import java.util.Scanner;
public class Greedy {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入物品个数n：");
        int n = reader.nextInt();
        System.out.println("请输入背包容量c：");
        float c = reader.nextFloat();
        float[] w = new float[n+1];		//物品重量
        float[] v = new float[n+1];		//物品价值
        for(int i=0;i<n;i++){//物品重量取随机数（20）以内
            w[i] = (float) Math.floor(Math.random()*20);
        }
        System.out.println("物品重量为：");
        for(int j=0;j<n;j++){
            System.out.print(w[j]+" ");
        }
        System.out.println("");
        for(int i=0;i<n;i++){//物品价值取随机数（20）以内
            v[i] = (float) Math.floor(Math.random()*20);
        }
        System.out.println("物品价值为：");
        for(int j=0;j<n;j++){
            System.out.print(v[j]+" ");
        }
        System.out.println("");
        float[] x = new float[n+1];		//问题的解
         Greedy p = new Greedy();
        p.Sort(n, v, w);
        float s = p.Knapsack(w, v, x, c, n);
        System.out.println("最优解的最终价值为："+s);
    }
    float Knapsack(float w[],float v[],float x[],float c,int n){
        float total = 0;
        int i;
        Sort(n,v,w);
        for(i=0;i<n;i++)
            x[i] = 0;
        i = 1;
        while(w[i]<c){
            x[i] = 1;
            total = total + v[i];
            c = c - w[i];
            i++;
        }
        x[i] = c/w[i];
        total = total + x[i]*v[i];
        System.out.println("问题的解为：");
        for(int j=0;j<n;j++){
            System.out.print(x[j]+" ");
        }
        System.out.println("");
        return total;
    }
    private void Sort(int n,float v[],float w[]) {//从大到小排序
        int i;
        float j;
        float k;
        for(i =0;i<n;i++){
            if( v[i+1]/w[i+1] > v[i]/w[i] ){
                j = v[i];
                k = w[i];
                v[i] = v[i+1];
                w[i] = w[i+1];
                v[i+1] = j;
                w[i+1] = k;
            }
        }
    }
}