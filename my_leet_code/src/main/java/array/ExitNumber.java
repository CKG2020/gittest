package array;

public class ExitNumber {
public boolean exit(int target,int [][] array){
    if (array==null || array.length==0 || array[0].length==0){
        return false;
    }
    int rows=array.length;
    int cols=array[0].length;
    int r=0;
    int c=cols-1;
    while(r<=rows-1&&c>=0){
        if (target==array[r][c]){
            return true;
        }
        else if (target>array[r][c]){
            r++;
        }
        else
            c--;
    }
    return false;
}

    public static void main(String[] args) {

        int arr1 [][]=new int[2][]; //行数必须指定
        int [][] arr2= new int [2][];
        int [] arr3 []=new int [2][];


        int [][] arr={{2,3,4},{3,5,6},{4,6,8}};


        ExitNumber exitNumber = new ExitNumber();
        boolean exit = exitNumber.exit(1, arr);
        if (exit==true){
            System.out.println("存在该数字");
        }
        else{
            System.out.println("不存在该数字");
        }


    }









}
