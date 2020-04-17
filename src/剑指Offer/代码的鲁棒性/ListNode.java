package 剑指Offer.代码的鲁棒性;

/**
 * @author 梦仙尘
 * @create 2020-04-13 16:20
 */
public class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
