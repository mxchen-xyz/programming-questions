package 剑指Offer.树;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author 梦仙尘
 * @create 2020-03-30 17:22
 */
public class 按之字形顺序打印二叉树 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode root21 = new TreeNode(2);
        TreeNode root22 = new TreeNode(3);
        TreeNode root31 = new TreeNode(4);
        TreeNode root32 = new TreeNode(5);
        TreeNode root33 = new TreeNode(6);
        TreeNode root34 = new TreeNode(7);
        TreeNode root42 = new TreeNode(8);
        TreeNode root43 = new TreeNode(9);
        root32.left = root42;
        root32.right = root43;
        root21.left = root31;
        root21.right = root32;
        root22.left = root33;
        root22.right = root34;
        root.left = root21;
        root.right = root22;
        System.out.println(Print(root));

    }

    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
     * 第三行按照从左到右的顺序打印，其他行以此类推。
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        /**
         * 思路：利用Java中的LinkedList的底层实现是双向链表的特点。
         * 可用做队列,实现树的层次遍历
         * 可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
         */
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null) {
            return arrayLists;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        Iterator<TreeNode> iter;
        queue.addLast(null);//层分隔符 在链表尾部添加一个元素
        queue.addLast(pRoot);
        boolean leftToRight = true;

        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) {//到达层分隔符
                if (leftToRight) {
                    iter = queue.iterator();//从前往后遍历
                } else {
                    iter = queue.descendingIterator();//从后往前遍历
                }
                leftToRight = !leftToRight;
                while (iter.hasNext()) {
                    TreeNode temp =iter.next();//遍历迭代器
                    list.add(temp.val);
                }
                arrayLists.add(new ArrayList<>(list));
                list.clear();//清空list
                queue.addLast(null);//添加层分隔符
                continue;//跳出当前操作，不往下执行
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        return arrayLists;
    }


}
