package array;

public class Replace {

    public  String   replaceSpace(StringBuffer s){
//        int  p1=s.length()- 1;
//
//        for (int i = 0; i <= p1; i++) {
//            if (s.charAt(i) == ' ') {
////                s.append("%20");
//                s.deleteCharAt(i);
//                s.insert(i,"%20");
//            }
//        }
////
////            int p2=s.length()-1;
////            while (p1>=0&& p2>p1){
////                char
////            }
//        return s.toString();

        int P1 = s.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (s.charAt(i) == ' ')
                s.append("  ");

        int P2 = s.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = s.charAt(P1--);
            if (c == ' ') {
                s.setCharAt(P2--, '0');
                s.setCharAt(P2--, '2');
                s.setCharAt(P2--, '%');
            } else {
                s.setCharAt(P2--, c);
            }
        }
        return s.toString();

    }

    public static void main(String[] args) {
        Replace replace = new Replace();
        String a="A B";
        //String 转换为StringBuffer
        StringBuffer stringBuffer = new StringBuffer(a);
        //或者　　　　StringBuffer sb=new StringBuffer();
        //           sb.append(a);
        //StringBuffer转换为String   sb.toString ()就可以了
        System.out.println(replace.replaceSpace(stringBuffer));
//      stringBuffer.appendCodePoint(1);
//        System.out.println(stringBuffer);
//        System.out.println(stringBuffer.capacity());
//        StringBuffer stringBuffer1 = new StringBuffer();
//        System.out.println(stringBuffer1.capacity());
//        StringBuffer a1 = new StringBuffer("adbcssasd");
//        System.out.println(a1.capacity());
////容量的内很迷惑啊
//        System.out.println(a1.charAt(0));
//        System.out.println(a1.codePointBefore(2));


    }

}
