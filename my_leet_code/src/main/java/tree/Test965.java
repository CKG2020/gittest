package tree;

import java.util.Scanner;


class Solution965 {

    boolean flag = true;


    public boolean isUnivalTree(TreeNode root) {
        help(root, root.val);
        return flag;
    }

    public void help(TreeNode treeNode, int val) {
        if (!flag) {
            return;
        }
        if (treeNode == null) {
            return;
        }
        if (treeNode.val != val) {
            flag = false;
        }
//if (treeNode.left.left!=null&treeNode.)
        help(treeNode.left, val);
        help(treeNode.right, val);
    }
}

public class Test965 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //创建Scanner
//        TreeNode965 treeNode965 = new TreeNode965(sc.nextInt());
//        treeNode965.left.val=


//        while (sc.hasNext()) {
//
//            System.out.println(sc.nextInt() + "=============");
//
//        }
//
//        String[] c = s.split("/s+");//用空格将其分割成字符串数组
//        int size = c.length;
//        int[] b = new int[size];
//        for (int m = 0; m < b.length; m++) {
//            b[m] = Integer.parseInt(c[m]);
//        }



        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(1);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(3);


        Solution965 solution965 = new Solution965();
        boolean univalTree = solution965.isUnivalTree(t);
        System.out.println(univalTree);


    }
}


