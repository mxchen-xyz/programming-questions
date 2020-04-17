package 剑指Offer.代码的鲁棒性;

/**
 * @author 梦仙尘
 * @create 2020-04-14 15:54
 */
public class 树的子结构 {
    /*
     *题目描述
     *输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null){
            return false;
        }
        if(root1.val == root2.val){
            if(bfs(root1,root2)){
                return true;
            }
        }
        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    public boolean bfs(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val == root2.val){
            return bfs(root1.left,root2.left)&&bfs(root1.right,root2.right);
        }
        return false;
    }
}
