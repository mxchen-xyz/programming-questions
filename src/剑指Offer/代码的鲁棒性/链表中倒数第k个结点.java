package 剑指Offer.代码的鲁棒性;

/**
 * @author 梦仙尘
 */
public class 链表中倒数第k个结点 {
    /**
     *输入一个链表，输出该链表中倒数第k个结点。
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        //判断head是否为空，为空直接返回null
        if(head == null){
            return null;
        }
        //设置临时变量，用于计算长度
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        //防止k越界，越界则返回一个null
        if(k<1||k>length){
            return null;
        }
        ListNode node = head;
        for(int i = 0;i<length-k;i++){
            node = node.next;
        }
        return node;
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
        System.out.println(FindKthToTail(node1,4));
    }
}
