package 剑指Offer.链表;

/**
 * @author 梦仙尘
 * @create 2020-03-28 20:51
 */
public class 链表中环的入口结点 {
    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        /**
         * 设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，一定相遇于环中某点。
         * 接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，最终相遇于环入口
         */
        ListNode fast=pHead;//快指针
        ListNode low=pHead;//慢指针
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low)
                break;
        }
        if(fast==null||fast.next==null)
            return null;
        low=pHead;
        while(fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }
}
