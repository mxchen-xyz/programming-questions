package 剑指Offer.树;

/**
 * @author 梦仙尘
 * @create 2020-03-31 12:01
 */
public class 序列化二叉树 {

    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     * <p>
     * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
     * 从而使得内存中建立起来的二叉树可以持久保存。
     * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
     * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
     * <p>
     * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
     */
    //序列化
    StringBuffer treeString = new StringBuffer();

    String Serialize(TreeNode root) {
        if (root == null) {
            treeString.append("#,");
        } else {
            treeString.append(root.val + ",");
            Serialize(root.left);
            Serialize(root.right);


        }
        return treeString.toString();
    }

    //反序列化
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        String[] nodeArray = str.split(",");
        return Deserializeing(nodeArray);
    }


    int index = -1;

    private TreeNode Deserializeing(String[] nodeArray) {
        index++;
        if (!nodeArray[index].equals("#")) {
            TreeNode node = new TreeNode(Integer.parseInt(nodeArray[index]));
            node.left = Deserializeing(nodeArray);
            node.right = Deserializeing(nodeArray);
            return node;
        }
        return null;
    }
}
