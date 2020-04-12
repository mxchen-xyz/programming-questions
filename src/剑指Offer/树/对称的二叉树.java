package 剑指Offer.树;

import java.util.Stack;

/**
 * @author 梦仙尘
 * @create 2020-03-30 16:45
 */
public class 对称的二叉树 {
    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        /**
         * 思路：
         *首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
         * 左子树的右子树和右子树的左子树相同即可，采用递归
         * 非递归也可，采用栈或队列存取各级子树根节点
         */
        if(pRoot == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while(!stack.empty()) {
            TreeNode right = stack.pop();//成对取出
            TreeNode left = stack.pop();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            //成对插入
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;

    }

}
