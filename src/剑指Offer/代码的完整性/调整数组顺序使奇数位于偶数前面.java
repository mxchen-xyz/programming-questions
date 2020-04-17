package 剑指Offer.代码的完整性;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 梦仙尘
 */
public class 调整数组顺序使奇数位于偶数前面 {
    /**
     *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public static int[] reOrderArray(int [] array) {
        Queue<Integer> oddQueue = new LinkedList<>();
        Queue<Integer> evenQueue = new LinkedList<>();
        for(int i = 0;i<array.length;i++){
            if((array[i]&1)!=0){
                oddQueue.offer(array[i]);
            }else{
                evenQueue.offer(array[i]);
            }
        }
        int i = 0;
        while(!oddQueue.isEmpty()){
            array[i++] = oddQueue.poll();
        }
        while(!evenQueue.isEmpty()){
            array[i++] = evenQueue.poll();
        }
        return array;
    }
    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,2,5,4,6,7,8,9};
        System.out.println(Arrays.toString(reOrderArray(arr)));
    }
}
