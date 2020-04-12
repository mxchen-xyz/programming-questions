package 剑指Offer.树;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author 梦仙尘
 * @create 2020-03-31 11:24
 */
public class 把二叉树打印成多行 {
    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(pRoot == null){
            return arrayLists;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        Iterator<TreeNode> iter;
        queue.addLast(null);
        queue.addLast(pRoot);
        while(queue.size()!=1){
            //取出第一个元素，并移除
            TreeNode node = queue.removeFirst();
            if(node == null){
                iter = queue.iterator();
                while(iter.hasNext()){
                    TreeNode treeNode = iter.next();
                    list.add(treeNode.val);
                }
                arrayLists.add(new ArrayList<>(list));
                list.clear();
                queue.addLast(null);
                continue;
            }
            if(node.left!=null){
                queue.addLast(node.left);
            }
            if(node.right!=null){
                queue.addLast(node.right);
            }
        }
        return arrayLists;
    }
}
