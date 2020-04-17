package 剑指Offer.代码的鲁棒性;

/**
 * @author 梦仙尘
 * @create 2020-04-13 17:40
 */
public class 合并两个排序的链表 {
    public static void main(String[] args) {
        MyLinkedList head1 = new MyLinkedList();
        MyLinkedList head2 = new MyLinkedList();
        for(int i = 1 ;i<10;i+=2){
            head1.addNode(i);
        }
        for(int i = 2 ;i<10;i+=2){
            head2.addNode(i);
        }
        System.out.println(Merge2(head1.getHead(),head2.getHead()));
    }
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    //方法一：将两个链表结点挨个进行比较，插入到一个新表中。
    public static ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //传入任意值初始化head，避免空指针异常
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 == null) {
            temp.next = list2;
        }
        if (list2 == null) {
            temp.next = list1;
        }
        return head.next;
    }

    //方法二：把list2往list1的中插。
    public static ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode pre = null;//list1的前一个节点
        ListNode nex;//list2的下一个节点
        ListNode head;//合并后的头节点
        if (list1.val > list2.val) {
            head = list2;
        } else {
            head = list1;
        }
        while (list1 != null && list2 != null) {
            if (list1.val >list2.val) {
                //将list2往前面插
                //保存list2当前节点的下一个节点
                nex = list2.next;
                //将list1与list2相连
                list2.next = list1;
                //让list1的前一个节点指向list2;
                pre.next = list2;
                /**
                 * 说明：
                 * 假设有两个链表：list1:a->b->c;list2:d->g;d要插到b的前面
                 * 那么b就是list1的当前节点，nex = c,pre = a,要使d插入到b前面成 a->d->b->c
                 * 有些值便有些变化，pre.next = d ,d.next不再是g而是b,然后更新当前节点，毕竟b的前一个节点不再是
                 * a而是d
                 */
                //更新pre
                pre = list2;
                //更新list2
                list2 = nex;
            } else {
                pre = list1;
                list1 = list1.next;
            }

        }
        //判断list2是否还有剩余的值
        if(list2!=null){
            pre.next = list2;
        }
        return head;
    }

    //方法三：递归
    //如果list1小于list2，则list1作为合并序列的开头，后面应该接的部分等同于list1.next和list2的合并序列，反之同理。
    public static ListNode Merge3(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = Merge3(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge3(list2.next, list1);
            return list2;
        }

    }

}
