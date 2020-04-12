package 剑指Offer.树;

/**
 * @author 梦仙尘
 * @create 2020-03-31 13:31
 */
public class 二叉搜索树的第k个结点 {
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，
     * 按结点数值大小顺序第三小结点的值为4。
     */
    static int count = 0;//计数器
    static TreeNode node;
    public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        /**
         * 思路：
         * 二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
         * 所以，按照中序遍历顺序找到第k个结点就是结果。
         */
        if(pRoot==null||k<1){
            return null;
        }
        node = KthNode(pRoot.left,k);
        if(node!=null){
            return node;
        }
        count++;
        if(count == k){
            return pRoot;
        }
        node = KthNode(pRoot.right,k);
        if(node!=null){
            return node;
        }
        return null;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode root21 = new TreeNode(3);
        TreeNode root22 = new TreeNode(7);
        TreeNode root31 = new TreeNode(2);
        TreeNode root32 = new TreeNode(4);
        TreeNode root33 = new TreeNode(6);
        TreeNode root34 = new TreeNode(8);
        root21.left = root31;
        root21.right = root32;
        root22.left = root33;
        root22.right = root34;
        root.left = root21;
        root.right = root22;
        System.out.println(KthNode(root,4).val);
    }
}
