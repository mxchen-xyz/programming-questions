package 剑指Offer.链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 梦仙尘
 * @create 2020-03-28 20:42
 */
public class 从尾到头打印链表 {
    public static void main(String[] args){
        ListNode head=new ListNode(0);
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        head.val=1;
        head.next=firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        System.out.println(head);
        System.out.println(printListFromTailToHead(head));
    }
    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while(!stack.isEmpty()){
            arr.add(stack.pop());
        }
        return arr;
    }
}
