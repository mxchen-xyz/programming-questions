package 剑指Offer.树;

/**
 * @author 梦仙尘
 * @create 2020-03-30 16:04
 */
public class 二叉树的下一个结点 {
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    public TreeNode getNext(TreeNode pNode){
        /**
         * 思路：
         * 假设有一个二叉树:
         *        a
         *    b       c
         * d    e   f   g
         *    h   i
         *写出该二叉树的中序遍历：dbheiafcg
         * 结合题目得出规律：
         * 如果一个节点有右子树的时候，那么它的下一个节点就是它的右子树中的最左子节点。
         * 如果一个节点没有右子树的时候，并且节点是它的父节点的左子节点，那么该节点的下一个节点就是它的父节点。
         * 如果一个节点没有右子树，并且它还是它父节点的右子节点的话，我们可以沿着指向父节点的指针一直向上遍历，
         * 直到找到一个是它父节点的左子节点的节点。如果这样的节点存在的话，那么这个节点的父节点就是我们
         * 要找的下一个节点。
         */
        if(pNode == null){
            return null;
        }
        if(pNode.right!=null){
            pNode = pNode.right;
            while (pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }else{
            while (pNode.next!=null){
                if(pNode.next.left == pNode){
                    return pNode.next;
                }else{
                    pNode = pNode.next;
                }
            }
            return null;
        }
    }
}
