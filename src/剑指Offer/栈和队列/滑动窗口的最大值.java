package 剑指Offer.栈和队列;

import java.util.ArrayList;

/**
 * @author 梦仙尘
 * @create 2020-04-03 16:31
 */
public class 滑动窗口的最大值 {
    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
     * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
     * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
     * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     */
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int max = 0;
        for(int i = 0;i<num.length-size+1&&size>0;i++){
            for(int j = i;j<i+size;j++) {
                if (max < num[j]) {
                    max = num[j];
                }
            }
            arrayList.add(max);
            max = 0;
        }
        return arrayList;

    }
    public static void main(String[] args){
        int[] arr ={2,3,4,2,6,2,5,1};
        int size = 0;
        System.out.println(maxInWindows(arr,size));
    }
}
