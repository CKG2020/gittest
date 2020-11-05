package algri;

/**
 * 获取两个字符串的最长公共子序列
 * @author kpp
 *
 */
public class LCSTest {
    private static String lcs = "";
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //保留空字符串是为了getLength()方法的完整性也可以不保留
        //但是在getLength()方法里面必须额外的初始化c[][]第一个行第一列
        String firstStr = "ABCBDAB";
        String secondStr = "BDCABA";


        /*String[] x = new String[firstStr.length()+1];
        String[] y = new String[secondStr.length()+1];*/

        String[] x = strToArray(firstStr);
        String[] y = strToArray(secondStr);
        /*String[] x = {"", "A", "B", "C", "B", "D", "A", "B"};
        String[] y = {"", "B", "D", "C", "A", "B", "A"}; */

        int[][] b = getSearchRoad(x, y);

        Display(b, x, x.length-1, y.length-1);

        System.out.println("lcs:"+lcs);
    }

    /**
     * 字符串转数组，并且数组的第0个元素为""
     * @param str
     * @return
     */

    private static String[] strToArray(String str){

        String[] strArray = new String[str.length()+1];

        strArray[0] = "";

        for(int i = 1; i < strArray.length;i++){
            strArray[i] = ""+str.charAt(i-1);
        }
        return strArray;
    }

    /**
     * 获得LCS矩阵的路径走向
     * @param x 第一个数组
     * @param y 第二个数组
     * @return 返回一个记录决定搜索的方向的数组
     */
    public static int[][] getSearchRoad(String[] x, String[] y)
    {
        int[][] b = new int[x.length][y.length];
        int[][] c = new int[x.length][y.length];

        for(int j = 0;j < y.length;j++){
            c[0][j] = 0;
        }
        for(int i = 0;i < x.length;i++){
            c[i][0] = 0;
        }

        for(int i=1; i<x.length; i++)
        {
            for(int j=1; j<y.length; j++)
            {
                //对应第一个性质
                //x[i].equals(y[j])是指x[i]与y[j]的值相同
                if( x[i].equals(y[j]))
                {
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 1;
                }
                //x[i] == y[j]是指x[i]与y[j]的地址相同
                /*if( x[i] == y[j])
                {
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 1;
                }*/
                //对应第二或者第三个性质
                else if(c[i-1][j] >= c[i][j-1])
                {
                    c[i][j] = c[i-1][j];
                    b[i][j] = 0;
                }
                //对应第二或者第三个性质
                else
                {
                    c[i][j] = c[i][j-1];
                    b[i][j] = -1;
                }
            }
        }

        return b;
    }
    /**
     * 自矩阵右下至左上回溯，根据搜索路径获取LCS
     * @param b 搜索路径数组
     * @param x 第一个数组
     * @param i
     * @param j
     */
    public static void Display(int[][] b, String[] x, int i, int j)
    {

        if(i == 0 || j == 0)
            return ;

        if(b[i][j] == 1)
        {
            Display(b, x, i-1, j-1);
            lcs += x[i];
        }
        else if(b[i][j] == 0)
        {
            Display(b, x, i-1, j);
        }
        else if(b[i][j] == -1)
        {
            Display(b, x, i, j-1);
        }
    }

}
