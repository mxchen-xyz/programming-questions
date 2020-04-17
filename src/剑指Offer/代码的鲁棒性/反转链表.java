package 剑指Offer.代码的鲁棒性;

/**
 * @author 梦仙尘
 * @create 2020-04-13 16:54
 */
public class 反转链表 {
    public static ListNode ReverseList(ListNode head) {
        /**
         * 思路：假设有一个链表 ：a->b->c ;而反转链表：a<-b<-c
         * 所以咱就利用两个指针，pre :存储当前节点的前一个节点，nex :存储当前节点的下一个节点
         * 将当前节点与链表分离，然后重新为当前节点指向下一个节点
         * pre,next都为null
         * 演示while循环部分：
         *  head = a 不等于 null 执行内部代码 nex = b ,head.next = null,pre = a ,head = b
         *  head = b 不等于 null 执行内部代码 nex = c ,head.next = a,pre = b ,head = c
         *  head = c 不等于 null 执行内部代码 nex = null ,head.next = b,pre = c ,head = null
         *  head = null 循环结束
         */
        // 判断链表为空或长度为1的情况
        if (head == null || head.next == null) {
            return head;
        }
        //初始化pre指针，用于记录当前结点的前一个节点地址
        ListNode pre = null;
        //初始化nex指针，用于记录当前结点的下一个节点地址
        ListNode nex = null;
        //head指向null时，循环终止。
        while (head != null) {
            //先用nex指针记录当前结点的下一个节点。
            nex = head.next;
            //让当前节点与链表断开并指向前一个节点pre。
            head.next = pre;
            //pre指针指向当前结点
            pre = head;
            //head指向nex(保存着原链表中head的下一个节点)
            head = nex;
        }
        return pre;//当循环结束时,pre所指的就是反转链表的头结点

    }
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(ReverseList(node1));
    }
}
