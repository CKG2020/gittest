package algri;

public class LCS {
      static   int max;
    static char x[];
    static char y[];
//
//    static  String x[];
//    static  String y[];

    private static char[] strToArray(String str) {
        char[] strArray = new char[str.length()];
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = str.charAt(i);
        }
        return strArray;
    }


//    private static String[] strToArray1(String str){
//
//        String[] strArray = new String[str.length()+1];
//
//        strArray[0] = "";
//
//        for(int i = 1; i < strArray.length;i++){
//            strArray[i] = ""+str.charAt(i-1);
//        }
//        return strArray;
//    }

//java 递归只是实现了求出最长公共子序列的长度　
    public static int compare(int m, int n) {
        if (m <0 || n <0) {
            return 0;
        }
        if (x[m] == y[n]) {
            return compare(m - 1, n - 1) + 1;
        } else {
            return Math.max(compare(m - 1, n), compare(m, n - 1));
        }
 }



    public static void main(String[] args) {
//        String a ="xxxxx";
////        System.out.println(a.charAt(8));
//        System.out.println(a.length());
//        char[] strings = strToArray(a);
//        System.out.println(strings.length);
////        for (int i = 0; i < strings.length; i++) {
////            System.out.println(strings[i]);
////        }
//        System.out.println(strings[1]);


        String firstStr = "ABCBDAB";
        String secondStr = "BDCABA";
        char[] x = strToArray(firstStr);
        char[] y = strToArray(secondStr);

        LCS.x = x;
        LCS.y = y;
        int m = x.length;
        int n = y.length;
        System.out.println(compare(m - 1, n - 1));
//        compare(m-1,n-1);


//        String firstStr = "ABCBDAB";
//        String secondStr = "BDCABA";
//        String[] x = strToArray1(firstStr);
//        String[] y = strToArray1(secondStr);
//        LCS.x=x;
//        LCS.y=y;
//        int length = x.length-1;
//        int length1 = y.length-1;
//        System.out.println(compare(length, length1));


    }


}
