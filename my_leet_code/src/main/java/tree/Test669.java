package tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution669 {
//    TreeNode goal;

    public TreeNode trimBST(TreeNode root, int low, int high) {
        //传入节点为空的时候
        if (root == null) {
            return null;
        }
        //如果根节点为空的时候　就一直找他的子节点　　　直到找到合适范围的节点
        if (root.val > high) {
            //一个不满足了　进入了递归寻找满足值的节点　　在哪里交换数值呢　
            trimBST(root.left, low, high);
//            System.out.println("不满足");
        }
        if (root.val < low) {
            trimBST(root.right, low, high);
        }
        //如果都满足呢　怎么处理　　此处也需要递归　那和上面的递归改如何区分　
        if (root.val >= low && root.val <= high) {
            return root;

//    dao3    //新的ｉｄｅａ　　把满足的节点复制到另一颗树上　
        }

//  dao2  //用来生成ｇｏａｌ树

//dao1  //如果先递归把所有满足的节点先找出来　　
//    public  void help(TreeNode t,int low,int high){
//
//     trimBST( t,low, high);
//        }

  return  root;
    }

}

public  class Test669{





}
